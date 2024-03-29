package com.example.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.YonghuxinxiInfo;
import com.example.dao.YonghuxinxiInfoDao;
import com.example.service.YonghuxinxiInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.YonghuxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import cn.hutool.crypto.SecureUtil;

@RestController
@RequestMapping(value = "/yonghuxinxiInfo")
public class YonghuxinxiInfoController {

    @Resource
    private YonghuxinxiInfoService yonghuxinxiInfoService;
	@Resource
    private YonghuxinxiInfoDao yonghuxinxiInfoDao;

    @PostMapping
    public Result<YonghuxinxiInfo> add(@RequestBody YonghuxinxiInfoVo yonghuxinxiInfo) {

            yonghuxinxiInfo.setMima(SecureUtil.md5(yonghuxinxiInfo.getMima()));

		yonghuxinxiInfoService.add(yonghuxinxiInfo);
        return Result.success(yonghuxinxiInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yonghuxinxiInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YonghuxinxiInfoVo yonghuxinxiInfo) {
        yonghuxinxiInfoService.update(yonghuxinxiInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody YonghuxinxiInfoVo yonghuxinxiInfo) {
//        yonghuxinxiInfoService.update2(yonghuxinxiInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<YonghuxinxiInfo> detail(@PathVariable Long id) {
        YonghuxinxiInfo yonghuxinxiInfo = yonghuxinxiInfoService.findById(id);
        return Result.success(yonghuxinxiInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<YonghuxinxiInfo> changeStatus(@PathVariable Long id) {
        yonghuxinxiInfoService.changeStatus(id);
        return Result.success();
    }

    @GetMapping
    public Result<List<YonghuxinxiInfoVo>> all() {
        return Result.success(yonghuxinxiInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<YonghuxinxiInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(yonghuxinxiInfoService.findPage(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<YonghuxinxiInfo> register(@RequestBody YonghuxinxiInfo yonghuxinxiInfo) {
//        if (StrUtil.isBlank(yonghuxinxiInfo.getName()) || StrUtil.isBlank(yonghuxinxiInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(yonghuxinxiInfoService.add(yonghuxinxiInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<YonghuxinxiInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(YonghuxinxiInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<YonghuxinxiInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getYonghuming())).collect(Collectors.toList());
            for (YonghuxinxiInfo info : resultList) {
                yonghuxinxiInfoService.add(info);
            }
        }
        return Result.success();
    }
	//yoxutonxgjitu
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel，构造Msp数据
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("yonghuming", "A用户名");
        row.put("mima", "A密码");
        row.put("xingming", "A姓名");
        row.put("xingbie", "A性别");
        row.put("shouji", "A手机");
        row.put("shenfenzheng", "A身份证");
        row.put("youxiang", "A邮箱");
        row.put("zhaopian", "A照片");
        row.put("beizhu", "A备注");
		row.put("status", "是");
		row.put("level", "yonghuxinxi");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        // 通过工具类创建writer，默认创建xlsx格式
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=yonghuxinxiInfoModel.xlsx");

        //本地测试下载
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        //关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(System.out);
    }
	private void getPieData(String name, List<EchartsData> pieList, Map<String, Double> dataMap) {
        EchartsData pieData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        Map<String, String> titleMap = new HashMap<>(2);
        titleMap.put("text", name);
        pieData.setTitle(titleMap);

        series.setName(name + "比例");
        series.setType("pie");
        series.setRadius("55%");

        List<Object> objects = new ArrayList<>();
        List<Object> legendList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            objects.add(new JSONObject().putOpt("name", key).putOpt("value", value));
            legendList.add(key);
        }
        series.setData(objects);

        pieData.setSeries(Collections.singletonList(series));
        Map<String, Boolean> map = new HashMap<>();
        map.put("show", true);
        pieData.setTooltip(map);

        Map<String, Object> legendMap = new HashMap<>(4);
        legendMap.put("orient", "vertical");
        legendMap.put("x", "left");
        legendMap.put("y", "center");
        legendMap.put("data", legendList);
        pieData.setLegend(legendMap);

        pieList.add(pieData);
    }

    private void getBarData(String name, List<EchartsData> barList, Map<String, Double> dataMap) {
        EchartsData barData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        List<Object> seriesObjs = new ArrayList<>();
        List<Object> xAxisObjs = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            xAxisObjs.add(key);
            seriesObjs.add(value);
        }

        series.setType("bar");
        series.setName(name);
        series.setData(seriesObjs);
        barData.setSeries(Collections.singletonList(series));

        Map<String, Object> xAxisMap = new HashMap<>(1);
        xAxisMap.put("data", xAxisObjs);
        barData.setxAxis(xAxisMap);

        barData.setyAxis(new HashMap<>());

        Map<String, Object> legendMap = new HashMap<>(1);
        legendMap.put("data", Collections.singletonList(name));
        barData.setLegend(legendMap);

        Map<String, Boolean> map = new HashMap<>(1);
        map.put("show", true);
        barData.setTooltip(map);

        Map<String, String> titleMap = new HashMap<>(1);
        titleMap.put("text", name);
        barData.setTitle(titleMap);

        barList.add(barData);
    }
}