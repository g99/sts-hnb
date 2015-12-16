package com.hnb.article;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ArticleMapper;
@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public int write(ArticleVO article) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.write(article);
	}
	@Override
	public List<ArticleVO> getList(Command command) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectAll(command);
	}
	@Override
	public List<ArticleVO> searchByKeyword(Command command) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectSomeBy(command);
	}
	@Override
	public ArticleVO selectById(int rcdNo) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectById(rcdNo);
	}
	@Override
	public int count() {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.count();
	}
	@Override
	public int countByKeyword(Command command) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.countByKeyword(command);
	}
	@Override
	public int update(ArticleVO article) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.update(article);
	}
	@Override
	public int delete(int rcdNo) {
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.delete(rcdNo);
	}
}
