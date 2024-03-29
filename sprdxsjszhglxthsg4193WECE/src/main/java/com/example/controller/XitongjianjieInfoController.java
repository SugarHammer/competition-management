package com.example.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.XitongjianjieInfo;
import com.example.dao.XitongjianjieInfoDao;
import com.example.service.XitongjianjieInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.XitongjianjieInfoVo;
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

@RestController
@RequestMapping(value = "/xitongjianjieInfo")
public class XitongjianjieInfoController {

    @Resource
    private XitongjianjieInfoService xitongjianjieInfoService;
	@Resource
    private XitongjianjieInfoDao xitongjianjieInfoDao;

    @PostMapping
    public Result<XitongjianjieInfo> add(@RequestBody XitongjianjieInfoVo xitongjianjieInfo) {
        
		//mixmajixami
		xitongjianjieInfoService.add(xitongjianjieInfo);
        return Result.success(xitongjianjieInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        xitongjianjieInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody XitongjianjieInfoVo xitongjianjieInfo) {
        xitongjianjieInfoService.update(xitongjianjieInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody XitongjianjieInfoVo xitongjianjieInfo) {
//        xitongjianjieInfoService.update2(xitongjianjieInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<XitongjianjieInfo> detail(@PathVariable Long id) {
        XitongjianjieInfo xitongjianjieInfo = xitongjianjieInfoService.findById(id);
        return Result.success(xitongjianjieInfo);
    }
    @GetMapping("/detailqt/{lb}")
    public Result<XitongjianjieInfo> detailqt(@PathVariable String lb) {
        XitongjianjieInfo xitongjianjieInfo = xitongjianjieInfoService.findByLeibie(lb);
        return Result.success(xitongjianjieInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<XitongjianjieInfo> changeStatus(@PathVariable Long id) {
        xitongjianjieInfoService.changeStatus(id);
        return Result.success();
    }

    @GetMapping
    public Result<List<XitongjianjieInfoVo>> all() {
        return Result.success(xitongjianjieInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<XitongjianjieInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(xitongjianjieInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<XitongjianjieInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(xitongjianjieInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<XitongjianjieInfo> register(@RequestBody XitongjianjieInfo xitongjianjieInfo) {
//        if (StrUtil.isBlank(xitongjianjieInfo.getName()) || StrUtil.isBlank(xitongjianjieInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(xitongjianjieInfoService.add(xitongjianjieInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<XitongjianjieInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(XitongjianjieInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<XitongjianjieInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getLeibie())).collect(Collectors.toList());
            for (XitongjianjieInfo info : resultList) {
                xitongjianjieInfoService.add(info);
            }
        }
        return Result.success();
    }
	//yoxutonxgjitu
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("leibie", "A类别");
row.put("neirong", "A内容");

		row.put("status", "是");
		row.put("level", "xitongjianjie");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=xitongjianjieInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
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