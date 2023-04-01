package com.lunux2008.url.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lunux2008.url.domain.Counter;

@Mapper
public interface CounterMapper {
	Counter selectByCounterMd5(String md5);
	Counter selectByCounterCode(String code);
	long insertCounter(@Param("counter") Counter counter);
	void updateCounter(@Param("counter") Counter counter);
}