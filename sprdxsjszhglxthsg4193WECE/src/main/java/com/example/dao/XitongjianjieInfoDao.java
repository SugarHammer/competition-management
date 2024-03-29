package com.example.dao;

import com.example.entity.XitongjianjieInfo;
import com.example.vo.XitongjianjieInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface XitongjianjieInfoDao extends Mapper<XitongjianjieInfo> {
    List<XitongjianjieInfoVo> findByLeibie(@Param("leibie") String leibie);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from xitongjianjie_info where leibie = #{leibie}")
    XitongjianjieInfo selectByLeibie(String leibie);
	
	
	
	
	
	
    
	
	

}
