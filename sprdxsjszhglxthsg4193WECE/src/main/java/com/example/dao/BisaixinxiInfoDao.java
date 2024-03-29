package com.example.dao;

import com.example.entity.BisaixinxiInfo;
import com.example.vo.BisaixinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface BisaixinxiInfoDao extends Mapper<BisaixinxiInfo> {
    List<BisaixinxiInfoVo> findBySaishimingcheng(@Param("saishimingcheng") String saishimingcheng);
	List<BisaixinxiInfoVo> findBySaishimingchenglist3(@Param("saishimingcheng") String saishimingcheng,@Param("yonghuming") String yonghuming); 
        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from bisaixinxi_info where tianjiaren = #{tianjiaren}")
    BisaixinxiInfo selectByTianjiaren(String tianjiaren);

	@Select("SELECT * FROM bisaixinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
}
