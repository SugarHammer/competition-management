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
import com.example.entity.CommentInfo;
import com.example.entity.TieziInfo;
import com.example.dao.TieziInfoDao;
import com.example.service.TieziInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.TieziInfoVo;
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
@RequestMapping(value = "/tieziInfo")
public class TieziInfoController {

    @Resource
    private TieziInfoService tieziInfoService;
	@Resource
    private TieziInfoDao tieziInfoDao;

    @PostMapping
    public Result<TieziInfo> add(@RequestBody TieziInfoVo tieziInfo) {
        
		//mixmajixami
		tieziInfoService.add(tieziInfo);
        return Result.success(tieziInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        tieziInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody TieziInfoVo tieziInfo) {
        tieziInfoService.update(tieziInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody TieziInfoVo tieziInfo) {
//        tieziInfoService.update2(tieziInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<TieziInfo> detail(@PathVariable Long id) {
        TieziInfo tieziInfo = tieziInfoService.findById(id);
        return Result.success(tieziInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<TieziInfo> changeStatus(@PathVariable Long id) {
        tieziInfoService.changeStatus(id);
        return Result.success();
    }

    @GetMapping
    public Result<List<TieziInfoVo>> all() {
        return Result.success(tieziInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<TieziInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(tieziInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<TieziInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(tieziInfoService.findPageqt(name, pageNum, pageSize, request));
    }
    @GetMapping("/pagebbs/{name}/{bk}")
    public Result<PageInfo<TieziInfoVo>> pagebbs(@PathVariable String name,@PathVariable String bk,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(tieziInfoService.findPagebbs(name, bk,pageNum, pageSize, request));
    }

    @GetMapping("/huitie/{shujuid}")
    public Result<List<TieziInfo>> huitie(@PathVariable("shujuid") Long shujuid) {
        return Result.success(tieziInfoService.huitie(shujuid));
    }

    @GetMapping("/getTotal/{fid}")
    Result<Map<String, Object>> getTotal(@PathVariable Long fid) {
        Map<String, Object> map = new HashMap<>(4);
        //   获取用户总数
        map.put("totalUser", getUserCount(fid) == null ? 0 : getUserCount(fid));
        // 获取评论总数
        //map.put("totalComment", commentInfoDao.count() == null ? 0 : commentInfoDao.count());
        // 获取总销售额
        //   map.put("totalPrice", orderInfoDao.totalPrice() == null ? 0 : orderInfoDao.totalPrice());
        // 获取总销量
        //  map.put("totalShopping", orderGoodsRelDao.totalShopping() == null ? 0 : orderGoodsRelDao.totalShopping());
        return Result.success(map);
    }
    private Integer getUserCount(@PathVariable long fid) {
        Integer count = 0;
        count += tieziInfoDao.counthts(fid);
        //count += sellerInfoDao.count();
        //	count += userInfoDao.count();

        return count;
    }

   // @PostMapping("/register")
//    public Result<TieziInfo> register(@RequestBody TieziInfo tieziInfo) {
//        if (StrUtil.isBlank(tieziInfo.getName()) || StrUtil.isBlank(tieziInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(tieziInfoService.add(tieziInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<TieziInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(TieziInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<TieziInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getBiaoti())).collect(Collectors.toList());
            for (TieziInfo info : resultList) {
                tieziInfoService.add(info);
            }
        }
        return Result.success();
    }
	@GetMapping("/get/tiezi_tj_suozaibankuai")
    Result<List<EchartsData>> tiezi_tj_suozaibankuai() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> tiezi_tj_suozaibankuaiList = tieziInfoDao.tiezi_tj_suozaibankuai();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : tiezi_tj_suozaibankuaiList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("帖子按所在版块统计", list, typeMap);
        getBarData("帖子按所在版块统计", list, typeMap);
        return Result.success(list);
    }

    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("suozaibankuai", "A所在版块");
row.put("biaoti", "A标题");
row.put("neirong", "A内容");
row.put("leixing", "A类型");
row.put("faburen", "A发布人");
row.put("huitieshu", "A回帖数");

		row.put("status", "是");
		row.put("level", "tiezi");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=tieziInfoModel.xlsx");

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