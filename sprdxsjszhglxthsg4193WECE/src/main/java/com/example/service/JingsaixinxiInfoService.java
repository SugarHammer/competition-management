package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JingsaixinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JingsaixinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JingsaixinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JingsaixinxiInfoService {

    @Resource
    private JingsaixinxiInfoDao jingsaixinxiInfoDao;
	
	//kuabiaojisuan3

    public JingsaixinxiInfo add(JingsaixinxiInfo jingsaixinxiInfo) {
        List<Long> tupianflst = jingsaixinxiInfo.getTupianflst();
        if (!CollectionUtil.isEmpty(tupianflst)) {
            jingsaixinxiInfo.setTupian(tupianflst.toString());
        }
		
		        //shangxchxuantupxian
        // 唯一校验

        jingsaixinxiInfoDao.insertSelective(jingsaixinxiInfo);
        return jingsaixinxiInfo;
    }

    public void delete(Long id) {
        jingsaixinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JingsaixinxiInfo jingsaixinxiInfo) {
        List<Long> tupianflst = jingsaixinxiInfo.getTupianflst();
        if (!CollectionUtil.isEmpty(tupianflst)) {
            jingsaixinxiInfo.setTupian(tupianflst.toString());
        }
		
		        //shangxchxuantupxian
		//youdianzan
        jingsaixinxiInfoDao.updateByPrimaryKeySelective(jingsaixinxiInfo);
    }

    public JingsaixinxiInfo findById(Long id) {
        return jingsaixinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<JingsaixinxiInfoVo> findAll() {
        return jingsaixinxiInfoDao.findBySaishimingcheng("all");
    }

    public PageInfo<JingsaixinxiInfoVo> findPage(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JingsaixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jingsaixinxiInfoDao.findBySaishimingcheng(saishimingcheng);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JingsaixinxiInfoVo> findPageqt(String saishimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JingsaixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jingsaixinxiInfoDao.findBySaishimingcheng(saishimingcheng);
		
	
	
        
        return PageInfo.of(all);
    }

   // public JingsaixinxiInfoVo findByUserName(String name) {
//        return jingsaixinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        JingsaixinxiInfo jingsaixinxiInfo = jingsaixinxiInfoDao.selectByPrimaryKey(id);
        if(jingsaixinxiInfo.getStatus().equals("是")){
            jingsaixinxiInfo.setStatus("否");
            jingsaixinxiInfoDao.updateByPrimaryKey(jingsaixinxiInfo);
        }else if(jingsaixinxiInfo.getStatus().equals("否")){
            jingsaixinxiInfo.setStatus("是");
            jingsaixinxiInfoDao.updateByPrimaryKey(jingsaixinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}
