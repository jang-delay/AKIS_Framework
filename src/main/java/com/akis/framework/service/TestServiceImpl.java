package com.akis.framework.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.akis.framework.controller.HomeController;
import com.akis.framework.vo.TestVO;

@Service
public class TestServiceImpl implements TestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private TestDao testDao;
	
	@Override
	public List<TestVO> listAll() throws Exception {
		LOGGER.info("DB 조회 진입 - TestServiceImpl");
		return testDao.listAll();
	}


}
