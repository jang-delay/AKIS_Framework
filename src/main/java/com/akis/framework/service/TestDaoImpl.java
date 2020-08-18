package com.akis.framework.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.akis.framework.vo.TestVO;

@Repository
public class TestDaoImpl implements TestDao {
	private static final String NAMESPACE = "com.akis.framework.mapper.TestMapper";
	private final SqlSession sqlSession;
	
	@Inject
	public TestDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<TestVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}
}
