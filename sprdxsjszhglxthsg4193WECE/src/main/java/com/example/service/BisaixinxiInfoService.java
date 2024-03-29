package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.BisaixinxiInfoDao;

import com.example.dao.SaishibaomingInfoDao;

//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.BisaixinxiInfo;
import com.example.entity.SaishibaomingInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.BisaixinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class BisaixinxiInfoService {

    @Resource
    private BisaixinxiInfoDao bisaixinxiInfoDao;

    @Resource
    private SaishibaomingInfoDao saishibaomingInfoDao;
	
	//kuabiaojisuan3

    public BisaixinxiInfo add(BisaixinxiInfo bisaixinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
      // bisaixinxiInfo.setAccount((double) 0);
	  
        bisaixinxiInfoDao.insertSelective(bisaixinxiInfo);
        return bisaixinxiInfo;
    }

    public void delete(Long id) {
        bisaixinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(BisaixinxiInfo bisaixinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        bisaixinxiInfoDao.updateByPrimaryKeySelective(bisaixinxiInfo);
    }

    public BisaixinxiInfo findById(Long id) {
        return bisaixinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<BisaixinxiInfoVo> findAll() {
        return bisaixinxiInfoDao.findBySaishimingcheng("all");
    }

    public PageInfo<BisaixinxiInfoVo> findPage(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BisaixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = bisaixinxiInfoDao.findBySaishimingcheng(saishimingcheng);}
		if (user.getLevel().equals("注册用户")) {all = bisaixinxiInfoDao.findBySaishimingchenglist3(saishimingcheng,user.getYonghuming()); } 
        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<BisaixinxiInfoVo> findPageqt(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BisaixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = bisaixinxiInfoDao.findBySaishimingcheng(saishimingcheng);
		if (user.getLevel().equals("注册用户")) {all = bisaixinxiInfoDao.findBySaishimingchenglist3(saishimingcheng,user.getYonghuming()); } 
        
	
	
        
        return PageInfo.of(all);
    }

   // public BisaixinxiInfoVo findByUserName(String name) {
//        return bisaixinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        BisaixinxiInfo bisaixinxiInfo = bisaixinxiInfoDao.selectByPrimaryKey(id);
        if(bisaixinxiInfo.getStatus().equals("是")){
            bisaixinxiInfo.setStatus("否");
            bisaixinxiInfoDao.updateByPrimaryKey(bisaixinxiInfo);
        }else if(bisaixinxiInfo.getStatus().equals("否")){
            bisaixinxiInfo.setStatus("是");
            bisaixinxiInfoDao.updateByPrimaryKey(bisaixinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
