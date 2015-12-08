package com.hnb.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MovieServiceImpl implements MovieService  {
	
	@Autowired
	MovieDAOImpl dao;

	@Override
	public int register(MovieVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(MovieVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String filmNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MovieVO searchByName(String filmName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieVO> getFilmNum() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
