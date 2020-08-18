package com.akis.framework.service;

import java.util.List;

import com.akis.framework.vo.TestVO;

public interface TestService {
	List<TestVO> listAll() throws Exception;
}
