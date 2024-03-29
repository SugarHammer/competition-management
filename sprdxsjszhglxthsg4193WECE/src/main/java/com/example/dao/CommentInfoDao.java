package com.example.dao;

import com.example.entity.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentInfoDao extends Mapper<CommentInfo> {

    List<CommentInfo> findByContent(@Param("shoucangmingcheng") String shoucangmingcheng,
                                    @Param("userId") Long userId,
                                    @Param("level") String level);

    List<CommentInfo> findByGoodsIdAndUserId(@Param("shujuid") Long shujuid,
                                             @Param("userId") Long userId,
                                             @Param("level") String level);

    List<CommentInfo> findByShujuid(@Param("shujuid") Long shujuid);
    List<CommentInfo> findByShujuidhsg(@Param("shujuid") Long shujuid,@Param("biao") String biao);

    @Select("select count(id) from comment_info")
    Integer count();
}