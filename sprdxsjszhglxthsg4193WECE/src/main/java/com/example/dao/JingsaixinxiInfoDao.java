package com.example.dao;

import com.example.entity.JingsaixinxiInfo;
import com.example.vo.JingsaixinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JingsaixinxiInfoDao extends Mapper<JingsaixinxiInfo> {
    List<JingsaixinxiInfoVo> findBySaishimingcheng(@Param("saishimingcheng") String saishimingcheng);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jingsaixinxi_info where saishimingcheng = #{saishimingcheng}")
    JingsaixinxiInfo selectBySaishimingcheng(String saishimingcheng);
	
	@Select("SELECT * FROM jingsaixinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
}
