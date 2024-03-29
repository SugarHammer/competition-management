package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.XitongjianjieInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.XitongjianjieInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.XitongjianjieInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class XitongjianjieInfoService {

    @Resource
    private XitongjianjieInfoDao xitongjianjieInfoDao;
	
	//kuabiaojisuan3

    public XitongjianjieInfo add(XitongjianjieInfo xitongjianjieInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // xitongjianjieInfo.setAccount((double) 0);
	  
        xitongjianjieInfoDao.insertSelective(xitongjianjieInfo);
        return xitongjianjieInfo;
    }

    public void delete(Long id) {
        xitongjianjieInfoDao.deleteByPrimaryKey(id);
    }

    public void update(XitongjianjieInfo xitongjianjieInfo) {
        //shangxchxuantupxian
		//youdianzan
        xitongjianjieInfoDao.updateByPrimaryKeySelective(xitongjianjieInfo);
    }

    public XitongjianjieInfo findById(Long id) {
        return xitongjianjieInfoDao.selectByPrimaryKey(id);
    }

    public XitongjianjieInfo findByLeibie(String leibie) {
        return xitongjianjieInfoDao.selectByLeibie(leibie);
    }

    public List<XitongjianjieInfoVo> findAll() {
        return xitongjianjieInfoDao.findByLeibie("all");
    }

    public PageInfo<XitongjianjieInfoVo> findPage(String leibie, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XitongjianjieInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = xitongjianjieInfoDao.findByLeibie(leibie);}
		//list2 if (user.getLevel().equals("cxcxx2")) {all = xitongjianjieInfoDao.findByLeibielist2(leibie,user.getdxzhujian2()); }
		//list3 if (user.getLevel().equals("cxcxx3")) {all = xitongjianjieInfoDao.findByLeibielist3(leibie,user.getdxzhujian3()); }
	
        
        return PageInfo.of(all);
    }
	
	public PageInfo<XitongjianjieInfoVo> findPageqt(String leibie, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XitongjianjieInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = xitongjianjieInfoDao.findByLeibie(leibie);
		//list2 if (user.getLevel().equals("cxcxx2")) {all = xitongjianjieInfoDao.findByLeibielist2(leibie,user.getdxzhujian2()); }
		//list3 if (user.getLevel().equals("cxcxx3")) {all = xitongjianjieInfoDao.findByLeibielist3(leibie,user.getdxzhujian3()); }
	
        
        return PageInfo.of(all);
    }

   // public XitongjianjieInfoVo findByUserName(String name) {
//        return xitongjianjieInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        XitongjianjieInfo xitongjianjieInfo = xitongjianjieInfoDao.selectByPrimaryKey(id);
        if(xitongjianjieInfo.getStatus().equals("是")){
            xitongjianjieInfo.setStatus("否");
            xitongjianjieInfoDao.updateByPrimaryKey(xitongjianjieInfo);
        }else if(xitongjianjieInfo.getStatus().equals("否")){
            xitongjianjieInfo.setStatus("是");
            xitongjianjieInfoDao.updateByPrimaryKey(xitongjianjieInfo);
        }
    }
	//youtixing
	
	
   
}
