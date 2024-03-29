package com.example.dao;

import com.example.entity.YonghuxinxiInfo;
//import com.example.vo.XueshengxinxiInfoVo;
import com.example.vo.YonghuxinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface YonghuxinxiInfoDao extends Mapper<YonghuxinxiInfo> {
    List<YonghuxinxiInfoVo> findByXingming(@Param("xingming") String xingming);
    //list23N
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    YonghuxinxiInfoVo findByYonghuming(String yonghuming);
    Integer count();

    @Select("select * from yonghuxinxi_info where yonghuming = #{yonghuming}")
    YonghuxinxiInfo selectByYonghuming(String yonghuming);
}
