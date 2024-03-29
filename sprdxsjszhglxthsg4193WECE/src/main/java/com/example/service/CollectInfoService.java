package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.dao.CollectInfoDao;
import com.example.entity.Account;
import com.example.entity.CollectInfo;
import com.example.vo.CollectInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectInfoService {

    @Resource
    private CollectInfoDao collectInfoDao;

    public CollectInfo add(CollectInfo collectInfo) {
        collectInfo.setAddtime(DateUtil.formatDateTime(new Date()));
        collectInfoDao.addCollectInfo(collectInfo);

        return collectInfo;
    }

    public void delete(Long id) {
        collectInfoDao.deleteCollectInfo(id);
    }


    public List<CollectInfo> findAll(Long userId, String level) {
        List<CollectInfo> list = collectInfoDao.findCollectInfoByUserId(userId, level);
        return list;
    }

    public Integer findCount(Long userId, String level){
        return collectInfoDao.findCountByUserId(userId,level);
    }

    public CollectInfo findByShoucangmingcheng(String shoucangmingcheng) {
        CollectInfo collectInfo = collectInfoDao.findByShoucangmingcheng(shoucangmingcheng);
        return collectInfo;
    }

    public PageInfo<CollectInfoVo> findPage(Long userid, String level, Integer pageNum, Integer pageSize, HttpServletRequest request, String name) {
        PageHelper.startPage(pageNum, pageSize);

        List<CollectInfoVo> all=new ArrayList<>();
//        Account user = (Account) request.getSession().getAttribute("user");
        all = collectInfoDao.findByuseridlevel(userid,level,name);

        return PageInfo.of(all);
    }

}
