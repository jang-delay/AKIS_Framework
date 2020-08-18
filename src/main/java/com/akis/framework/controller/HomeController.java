package com.akis.framework.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akis.framework.service.TestService;
import com.akis.framework.vo.TestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private TestService testService;

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}


	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		LOGGER.info("DB 조회 진입");
		
		List<TestVO> result = testService.listAll();
		if(result.size() > 0) {
			model.addAttribute("result", "성공");
		}else {
			model.addAttribute("result", "실패");
		} 
		for(int i=0; i<result.size(); i++){
			LOGGER.debug("sno : " + result.get(i).getSno());
			LOGGER.debug("name : " + result.get(i).getName());
			LOGGER.debug("det : " + result.get(i).getDet());
        }      

		return "testResult";
	}

}
