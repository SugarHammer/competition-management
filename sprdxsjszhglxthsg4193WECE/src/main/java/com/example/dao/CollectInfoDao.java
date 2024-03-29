package com.example.dao;

import com.example.entity.CollectInfo;
import com.example.vo.CollectInfoVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CollectInfoDao extends Mapper<CollectInfo> {

    //添加收藏
    void addCollectInfo(CollectInfo collectInfo);

    //删除收藏
    void deleteCollectInfo(@Param("id") Long id);

    //根据用户id查询收藏展示
    List<CollectInfo> findCollectInfoByUserId(@Param("userId") Long userId, @Param("level") String level);
    List<CollectInfoVo> findByuseridlevel(@Param("userId") Long userId, @Param("level") String level,@Param("name") String name);
    //根据用户id查询收藏总数
    Integer findCountByUserId(@Param("userId") Long userId, @Param("level") String level);

    //根据名字查询收藏是否已经添加
    CollectInfo findByShoucangmingcheng(@Param("shoucangmingcheng") String shoucangmingcheng);

}