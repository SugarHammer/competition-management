package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.SaishibaomingInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.SaishibaomingInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.SaishibaomingInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SaishibaomingInfoService {

    @Resource
    private SaishibaomingInfoDao saishibaomingInfoDao;
	
	//kuabiaojisuan3

    public SaishibaomingInfo add(SaishibaomingInfo saishibaomingInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // saishibaomingInfo.setAccount((double) 0);
	  
        saishibaomingInfoDao.insertSelective(saishibaomingInfo);
        return saishibaomingInfo;
    }

    public void delete(Long id) {
        saishibaomingInfoDao.deleteByPrimaryKey(id);
    }

    public void update(SaishibaomingInfo saishibaomingInfo) {
        //shangxchxuantupxian
		//youdianzan
        saishibaomingInfoDao.updateByPrimaryKeySelective(saishibaomingInfo);
    }

    public SaishibaomingInfo findById(Long id) {
        return saishibaomingInfoDao.selectByPrimaryKey(id);
    }

    public List<SaishibaomingInfoVo> findAll() {
        return saishibaomingInfoDao.findBySaishimingcheng("all");
    }

    public PageInfo<SaishibaomingInfoVo> findPage(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<SaishibaomingInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = saishibaomingInfoDao.findBySaishimingcheng(saishimingcheng);}
		if (user.getLevel().equals("注册用户")) {all = saishibaomingInfoDao.findBySaishimingchenglist2(saishimingcheng,user.getYonghuming()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<SaishibaomingInfoVo> findPageqt(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<SaishibaomingInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = saishibaomingInfoDao.findBySaishimingcheng(saishimingcheng);
		if (user.getLevel().equals("注册用户")) {all = saishibaomingInfoDao.findBySaishimingchenglist2(saishimingcheng,user.getYonghuming()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public SaishibaomingInfoVo findByUserName(String name) {
//        return saishibaomingInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        SaishibaomingInfo saishibaomingInfo = saishibaomingInfoDao.selectByPrimaryKey(id);
        if(saishibaomingInfo.getStatus().equals("是")){
            saishibaomingInfo.setStatus("否");
            saishibaomingInfoDao.updateByPrimaryKey(saishibaomingInfo);
        }else if(saishibaomingInfo.getStatus().equals("否")){
            saishibaomingInfo.setStatus("是");
            saishibaomingInfoDao.updateByPrimaryKey(saishibaomingInfo);
        }
    }
	public void changeIszf(Long id) {
       SaishibaomingInfo saishibaomingInfo = saishibaomingInfoDao.selectByPrimaryKey(id);
        if(saishibaomingInfo.getIszf().equals("是")){
            saishibaomingInfo.setIszf("否");
            saishibaomingInfoDao.updateByPrimaryKey(saishibaomingInfo);
        }else if(saishibaomingInfo.getIszf().equals("否")){
            saishibaomingInfo.setIszf("是");
            saishibaomingInfoDao.updateByPrimaryKey(saishibaomingInfo);
        }
    }
	//youtixing
	
	
   
}
