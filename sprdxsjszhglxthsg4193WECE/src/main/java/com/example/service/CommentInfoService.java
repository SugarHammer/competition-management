package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.example.dao.CommentInfoDao;
import com.example.entity.Account;
import com.example.entity.CommentInfo;


import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class CommentInfoService {

    @Resource
    private CommentInfoDao commentInfoDao;

	@Resource
	private AdminInfoService adminInfoService;

   @Resourceprivate YonghuxinxiInfoService yonghuxinxiInfoService;



    public CommentInfo add(CommentInfo commentInfo) {
        commentInfo.setCreateTime(DateUtil.formatDateTime(new Date()));
        String content = commentInfo.getContent();
        if (content.length() > 255) {
            commentInfo.setContent(content.substring(0, 250));
        }
        commentInfoDao.insertSelective(commentInfo);
        return commentInfo;
    }

    public void delete(Long id) {
        commentInfoDao.deleteByPrimaryKey(id);
    }

    public void update(CommentInfo commentInfo) {
        String content = commentInfo.getContent();
        if (content.length() > 255) {
            commentInfo.setContent(content.substring(0, 250));
        }
        commentInfoDao.updateByPrimaryKeySelective(commentInfo);
    }

    public CommentInfo findById(Long id) {
        return commentInfoDao.selectByPrimaryKey(id);
    }

    public List<CommentInfo> findAll() {
        return commentInfoDao.selectAll();
    }

    public List<CommentInfo> findAll(Long shujuid) {
        List<CommentInfo> list = commentInfoDao.findByShujuid(shujuid);
        if (!CollectionUtil.isEmpty(list)) {
            for (CommentInfo info : list) {
                Long userId = info.getUserId();
                String level = info.getLevel();
				if (level.equals("管理员")) {
					info.setUserName(adminInfoService.findById(userId).getUsername());
				}
//				if (level == 2) {
//					info.setUserName(sellerInfoService.findById(userId).getName());
//				}
				if (level.equals("注册用户")) {info.setUserName(yonghuxinxiInfoService.findById(userId).getYonghuming());}
               // if (level.equals("用户")) {
//                    info.setUserName(yonghuxinxiInfoService.findById(userId).getYonghuming());
//                }

            }
        }
        return list;
    }
    public List<CommentInfo> findAllhsg(Long shujuid,String biao) {
        List<CommentInfo> list = commentInfoDao.findByShujuidhsg(shujuid,biao);
        if (!CollectionUtil.isEmpty(list)) {
            for (CommentInfo info : list) {
                Long userId = info.getUserId();
                String level = info.getLevel();
                if (level.equals("管理员")) {
                    info.setUserName(adminInfoService.findById(userId).getUsername());
                }
				if (level.equals("注册用户")) {info.setUserName(yonghuxinxiInfoService.findById(userId).getYonghuming());}
                //if (level.equals("用户")) {
//                    info.setUserName(yonghuxinxiInfoService.findById(userId).getYonghuming());
//                }

            }
        }
        return list;
    }
//
//    public PageInfo<CommentInfo> findPage(Integer pageNum, Integer pageSize, String name, HttpServletRequest request) {
//        PageHelper.startPage(pageNum, pageSize);
//        Account user = (Account)request.getSession().getAttribute("user");
//        if (user == null) {
//            throw new CustomException("1001", "用户未登录");
//        }
//        List<CommentInfo> all;
//        all = commentInfoDao.selectAll();
//        if (user.getLevel().equals("管理员")) {
//            all = commentInfoDao.selectAll();
//        } else {
//            all = commentInfoDao.findByContent(name, user.getId(), user.getLevel());
//        }
//        for (CommentInfo info : all) {
//            Long userId = info.getUserId();
//            String level = info.getLevel();
//            XueshengxinxiInfo xueshengxinxiInfo = xueshengxinxiInfoService.findById(info.getShujuid());
//            info.setGoodsName(xueshengxinxiInfo.getXuehao());
//				if (level.equals("管理员")) {
//					info.setUserName(adminInfoService.findById(userId).getUsername());
//				}
////				if (level == 2) {
////					info.setUserName(sellerInfoService.findById(userId).getName());
////				}
//
//                if (level.equals("学生")) {
//                    info.setUserName(xueshengxinxiInfoService.findById(userId).getXuehao());
//                }
//
//        }
//
//        return PageInfo.of(all);
//    }

}
