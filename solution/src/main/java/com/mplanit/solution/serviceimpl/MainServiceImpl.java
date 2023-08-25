package com.mplanit.solution.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mplanit.solution.mapper.MainMapper;
import com.mplanit.solution.service.MainService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainMapper mainMapper;
	
	@Override
	public List<Map<String, Object>> test() throws Exception {

		return mainMapper.test();
	}


//	@Override
//	public void test() throws Exception {
//		log.info(">>> MainServiceImpl deleteAll start >>>");
//	}

}
