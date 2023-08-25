package com.mplanit.solution.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {
	
	public List<Map<String, Object>> test() throws Exception;
}
