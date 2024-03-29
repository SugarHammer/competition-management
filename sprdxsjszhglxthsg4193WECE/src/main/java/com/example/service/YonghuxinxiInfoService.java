package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.YonghuxinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
//import com.example.vo.XueshengxinxiInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.YonghuxinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.YonghuxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class YonghuxinxiInfoService {

    @Resource
    private YonghuxinxiInfoDao yonghuxinxiInfoDao;

    //kuabiaojisuan3

    public YonghuxinxiInfo add(YonghuxinxiInfo yonghuxinxiInfo) {
        List<Long> zhaopianflst = yonghuxinxiInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            yonghuxinxiInfo.setZhaopian(zhaopianflst.toString());
        }

        //shangxchxuantupxian
        // 唯一校验
        int count = yonghuxinxiInfoDao.checkRepeat("yonghuming", yonghuxinxiInfo.getYonghuming(), null);
        if (count > 0) {
            throw new CustomException("1001", "该用户名\"" + yonghuxinxiInfo.getYonghuming() + "\"已存在");
        }
        // yonghuxinxiInfo.setAccount((double) 0);

        yonghuxinxiInfoDao.insertSelective(yonghuxinxiInfo);
        return yonghuxinxiInfo;
    }

    public void delete(Long id) {
        yonghuxinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(YonghuxinxiInfo yonghuxinxiInfo) {
        List<Long> zhaopianflst = yonghuxinxiInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            yonghuxinxiInfo.setZhaopian(zhaopianflst.toString());
        }

        //shangxchxuantupxian
        yonghuxinxiInfoDao.updateByPrimaryKeySelective(yonghuxinxiInfo);
    }

    public YonghuxinxiInfo findById(Long id) {
        return yonghuxinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<YonghuxinxiInfoVo> findAll() {
        return yonghuxinxiInfoDao.findByXingming("all");
    }

    public PageInfo<YonghuxinxiInfoVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<YonghuxinxiInfoVo> all = yonghuxinxiInfoDao.findByXingming(name);
        return PageInfo.of(all);
    }

    public YonghuxinxiInfoVo findByYonghuming(String yonghuming) {
        return yonghuxinxiInfoDao.findByYonghuming(yonghuming);
    }

    public YonghuxinxiInfo login(String yonghuming, String mima) {
        YonghuxinxiInfo yonghuxinxiInfo = yonghuxinxiInfoDao.findByYonghuming(yonghuming);
        if (yonghuxinxiInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(mima).equalsIgnoreCase(yonghuxinxiInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return yonghuxinxiInfo;
    }

    public YonghuxinxiInfoVo findByUserName(String name) {
        return yonghuxinxiInfoDao.findByYonghuming(name);
    }

    public void changeStatus(Long id) {
        YonghuxinxiInfo yonghuxinxiInfo = yonghuxinxiInfoDao.selectByPrimaryKey(id);
        if(yonghuxinxiInfo.getStatus().equals("是")){
            yonghuxinxiInfo.setStatus("否");
            yonghuxinxiInfoDao.updateByPrimaryKey(yonghuxinxiInfo);
        }else if(yonghuxinxiInfo.getStatus().equals("否")){
            yonghuxinxiInfo.setStatus("是");
            yonghuxinxiInfoDao.updateByPrimaryKey(yonghuxinxiInfo);
        }
    }
    //youtixing
    public void update2(YonghuxinxiInfoVo yonghuxinxiInfo) {
        List<Long> zhaopianflst = yonghuxinxiInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            yonghuxinxiInfo.setZhaopian(zhaopianflst.toString());
        }

        //shangxchxuantupxian
        if (StringUtils.isEmpty(yonghuxinxiInfo.getMima())) {
            // 默认密码123456
            yonghuxinxiInfo.setMima(SecureUtil.md5("123456"));
        } else {
            yonghuxinxiInfo.setMima(SecureUtil.md5(yonghuxinxiInfo.getMima()));
        }
        yonghuxinxiInfoDao.updateByPrimaryKeySelective(yonghuxinxiInfo);
    }


}
