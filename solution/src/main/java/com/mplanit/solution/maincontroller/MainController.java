package com.mplanit.solution.maincontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mplanit.solution.serviceimpl.MainServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

	@Autowired
	MainServiceImpl mainService;

	@GetMapping(value = "/")
	public String main(Model model) throws Exception {
		log.info(">>> MainController main start >>>");

		List<Map<String, Object>> result = mainService.test();
		log.info("test => {}", result);

		return "page/index";
	}
}
