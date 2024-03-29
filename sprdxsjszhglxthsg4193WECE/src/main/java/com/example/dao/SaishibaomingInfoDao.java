package com.example.dao;

import com.example.entity.SaishibaomingInfo;
import com.example.vo.SaishibaomingInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface SaishibaomingInfoDao extends Mapper<SaishibaomingInfo> {
    List<SaishibaomingInfoVo> findBySaishimingcheng(@Param("saishimingcheng") String saishimingcheng);
	List<SaishibaomingInfoVo> findBySaishimingchenglist2(@Param("saishimingcheng") String saishimingcheng,@Param("yonghuming") String yonghuming);
        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from saishibaoming_info where yonghuming = #{yonghuming}")
    SaishibaomingInfo selectByYonghuming(String yonghuming);
	
	@Select("SELECT * FROM saishibaoming_info order by id")
    List<Map<String, Object>> daochuexcel();
}
