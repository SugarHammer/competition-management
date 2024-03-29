package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.TieziInfoDao;
import com.example.entity.Account;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.TieziInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.TieziInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class TieziInfoService {

    @Resource
    private TieziInfoDao tieziInfoDao;
    @Resource
    private AdminInfoService adminInfoService;

    @Resource
    private YonghuxinxiInfoService yonghuxinxiInfoService;

	//kuabiaojisuan3

    public TieziInfo add(TieziInfo tieziInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // tieziInfo.setAccount((double) 0);
//        TieziInfo tieziInfo = tieziInfoDao.selectByPrimaryKey(tieziInfo.getId());
//        tieziInfo.setHts(String.valueOf(Integer.valueOf(tieziInfo.getHts()+1)));
//        tieziInfoDao.updateByPrimaryKeySelective(tieziInfo);

//         tieziInfo = tieziInfoDao.selectByID(String.valueOf(tieziInfo.getId()));
//        //tieziInfo.setHts(Long.valueOf(tieziInfo.getHts())+1);
//        tieziInfo.setHuitieshu(String.valueOf(Integer.valueOf(tieziInfo.getHuitieshu())+1));
//        tieziInfoDao.updateByPrimaryKeySelective(tieziInfo);

//        TieziInfo tiezi = findById(tieziInfo.getId());
//        tieziInfo.setHuitieshu(String.valueOf(Integer.valueOf(tiezi.getHuitieshu()) + 1));
//        tieziInfoDao.updateByPrimaryKeySelective(tieziInfo);

        tieziInfoDao.insertSelective(tieziInfo);
        return tieziInfo;
    }

    public void delete(Long id) {
        tieziInfoDao.deleteByPrimaryKey(id);
    }

    public void update(TieziInfo tieziInfo) {
        //shangxchxuantupxian
		 if (tieziInfo.getDianzan_d() != null) {
            TieziInfo tiezi = findById(tieziInfo.getId());
            tieziInfo.setDianzan_d(String.valueOf(Integer.valueOf(tiezi.getDianzan_d()) + Integer.valueOf(tieziInfo.getDianzan_d())));
        }
        if (tieziInfo.getDianzan_c() != null) {
            TieziInfo tiezi = findById(tieziInfo.getId());
            tieziInfo.setDianzan_c(String.valueOf(Integer.valueOf(tiezi.getDianzan_c()) + Integer.valueOf(tieziInfo.getDianzan_c())));
        }
        tieziInfoDao.updateByPrimaryKeySelective(tieziInfo);
    }

    public TieziInfo findById(Long id) {
        return tieziInfoDao.selectByPrimaryKey(id);
    }

    public List<TieziInfoVo> findAll() {
        return tieziInfoDao.findByBiaoti("all");
    }

    public PageInfo<TieziInfoVo> findPage(String biaoti, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<TieziInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = tieziInfoDao.findByBiaoti(biaoti);}
			if (user.getLevel().equals("注册用户")) {all = tieziInfoDao.findByBiaotilist2(biaoti,user.getYonghuming()); }

        List<TieziInfo> tieziInfoList = tieziInfoDao.selectAll();
        for (TieziInfoVo tieziInfoVo : all) {
            if(tieziInfoVo.getFid() == 0){
                int count = 0;
                for (TieziInfo info : tieziInfoList) {
                    if(info.getFid()==tieziInfoVo.getId()){
                        count++;
                    }
                }
                tieziInfoVo.setHuitieshu(count+"");
            }
        }

        
        return PageInfo.of(all);
    }
	
	public PageInfo<TieziInfoVo> findPageqt(String biaoti, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);

        List<TieziInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = tieziInfoDao.findByBiaoti(biaoti);
        //list2 if (user.getLevel().equals("cxcxx2")) {all = tieziInfoDao.findByBiaotilist2(biaoti,user.getdxzhujian2()); }
        //list3 if (user.getLevel().equals("cxcxx3")) {all = tieziInfoDao.findByBiaotilist3(biaoti,user.getdxzhujian3()); }


        return PageInfo.of(all);
    }

    public PageInfo<TieziInfoVo> findPagebbs(String biaoti, String bk, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);

        List<TieziInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = tieziInfoDao.findByBiaotibbs(biaoti,bk);

        List<TieziInfo> tieziInfoList = tieziInfoDao.selectAll();
        for (TieziInfoVo tieziInfoVo : all) {
            if(tieziInfoVo.getFid() == 0){
                int count = 0;
                for (TieziInfo info : tieziInfoList) {
                    if(info.getFid()==tieziInfoVo.getId()){
                        count++;
                    }
                }
                tieziInfoVo.setHuitieshu(count+"");
            }
        }

        return PageInfo.of(all);
    }
    public List<TieziInfo> huitie(Long shujuid) {
        List<TieziInfo> list = tieziInfoDao.huitie(shujuid);
        if (!CollectionUtil.isEmpty(list)) {
            for (TieziInfo info : list) {
                String ftr = info.getFaburen();
                String level = info.getLevel();
//                if (level.equals("管理员")) {
//                    info.setUserName(adminInfoService.findById(userId).getUsername());
//                }
//                if (level.equals("用户")) {
//                    info.setUserName(yonghuxinxiInfoService.findById(userId).getYonghuming());
//                }

            }
        }
        return list;
    }

   // public TieziInfoVo findByUserName(String name) {
//        return tieziInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        TieziInfo tieziInfo = tieziInfoDao.selectByPrimaryKey(id);
        if(tieziInfo.getStatus().equals("是")){
            tieziInfo.setStatus("否");
            tieziInfoDao.updateByPrimaryKey(tieziInfo);
        }else if(tieziInfo.getStatus().equals("否")){
            tieziInfo.setStatus("是");
            tieziInfoDao.updateByPrimaryKey(tieziInfo);
        }
    }
	//youtixing
	
	
   
}
