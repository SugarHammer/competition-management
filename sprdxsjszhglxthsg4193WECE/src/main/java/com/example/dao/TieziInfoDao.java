package com.example.dao;

import com.example.entity.CommentInfo;
import com.example.entity.TieziInfo;
import com.example.vo.TieziInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface TieziInfoDao extends Mapper<TieziInfo> {
    List<TieziInfoVo> findByBiaoti(@Param("biaoti") String biaoti);
    List<TieziInfoVo> findByBiaotibbs(@Param("biaoti") String biaoti,@Param("bk") String bk);
	List<TieziInfoVo> findByBiaotilist2(@Param("biaoti") String biaoti,@Param("faburen") String faburen);
        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
    Integer counthts(@Param("fid") Long fid);
	@Select("select * from tiezi_info where faburen = #{faburen}")
    TieziInfo selectByFaburen(String faburen);

    @Select("select * from tiezi_info where ID = #{ID}")
    TieziInfo selectByID(String ID);

	@Select("SELECT distinct(suozaibankuai) as aa,count(id) as bb FROM tiezi_info group by suozaibankuai order by id")
List<Map<String, Object>> tiezi_tj_suozaibankuai();

    List<TieziInfo> huitie(@Param("shujuid") Long shujuid);

}
