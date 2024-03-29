package com.example.dao;

import com.example.entity.BankuaiInfo;
import com.example.vo.BankuaiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface BankuaiInfoDao extends Mapper<BankuaiInfo> {
    List<BankuaiInfoVo> findByBankuaimingcheng(@Param("bankuaimingcheng") String bankuaimingcheng);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from bankuai_info where bankuaimingcheng = #{bankuaimingcheng}")
    BankuaiInfo selectByBankuaimingcheng(String bankuaimingcheng);
	
	
	
	
	
	
    
	
	

}
