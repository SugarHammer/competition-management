package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.BankuaiInfoDao;
import com.example.dao.TieziInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import com.example.vo.TieziInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.BankuaiInfo;
import com.example.entity.TieziInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.BankuaiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class BankuaiInfoService {

    @Resource
    private BankuaiInfoDao bankuaiInfoDao;
    @Resource
    private TieziInfoDao tieziInfoDao;
	//kuabiaojisuan3

    public BankuaiInfo add(BankuaiInfo bankuaiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        int count = bankuaiInfoDao.checkRepeat("bankuaimingcheng", bankuaiInfo.getBankuaimingcheng(), null);
if (count > 0) {
	throw new CustomException("1001", "该版块名称\"" + bankuaiInfo.getBankuaimingcheng() + "\"已存在");
}
      // bankuaiInfo.setAccount((double) 0);
	  
        bankuaiInfoDao.insertSelective(bankuaiInfo);
        return bankuaiInfo;
    }

    public void delete(Long id) {
        bankuaiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(BankuaiInfo bankuaiInfo) {
        //shangxchxuantupxian
		//youdianzan
        bankuaiInfoDao.updateByPrimaryKeySelective(bankuaiInfo);
    }

    public BankuaiInfo findById(Long id) {
        return bankuaiInfoDao.selectByPrimaryKey(id);
    }

    public List<BankuaiInfoVo> findAll() {
        return bankuaiInfoDao.findByBankuaimingcheng("all");
    }

    public PageInfo<BankuaiInfoVo> findPage(String bankuaimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BankuaiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = bankuaiInfoDao.findByBankuaimingcheng(bankuaimingcheng);}
        List<TieziInfoVo> alltz=null;
        alltz = tieziInfoDao.findByBiaoti("");
        List<BankuaiInfo> bankuaiInfoList = bankuaiInfoDao.selectAll();
        for (BankuaiInfoVo bankuaiInfoVo : all) {
            //if(tieziInfoVo.getFid() == 0){
            int count = 0;
            for (TieziInfoVo tieziInfoVo : alltz) {
                if(tieziInfoVo.getSuozaibankuai()!=null) {
                    if (tieziInfoVo.getSuozaibankuai().equals(bankuaiInfoVo.getBankuaimingcheng())) {
                        count++;
                    }
                }
            }
            bankuaiInfoVo.setYiyoutieshu(count+"");
            //  }
        }

        return PageInfo.of(all);
    }
	
	public PageInfo<BankuaiInfoVo> findPageqt(String bankuaimingcheng, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BankuaiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = bankuaiInfoDao.findByBankuaimingcheng(bankuaimingcheng);

        List<TieziInfoVo> alltz=null;
        alltz = tieziInfoDao.findByBiaoti("");

        List<BankuaiInfo> bankuaiInfoList = bankuaiInfoDao.selectAll();
        for (BankuaiInfoVo bankuaiInfoVo : all) {
            //if(tieziInfoVo.getFid() == 0){
                int count = 0;
                 for (TieziInfoVo tieziInfoVo : alltz) {
                     if(tieziInfoVo.getSuozaibankuai()!=null) {
                         if (tieziInfoVo.getSuozaibankuai().equals(bankuaiInfoVo.getBankuaimingcheng())) {
                             count++;
                         }
                     }
                }
                bankuaiInfoVo.setYiyoutieshu(count+"");
          //  }
        }
	
        
        return PageInfo.of(all);
    }

    public void changeStatus(Long id) {
        BankuaiInfo bankuaiInfo = bankuaiInfoDao.selectByPrimaryKey(id);
        if(bankuaiInfo.getStatus().equals("是")){
            bankuaiInfo.setStatus("否");
            bankuaiInfoDao.updateByPrimaryKey(bankuaiInfo);
        }else if(bankuaiInfo.getStatus().equals("否")){
            bankuaiInfo.setStatus("是");
            bankuaiInfoDao.updateByPrimaryKey(bankuaiInfo);
        }
    }
	//youtixing

}
