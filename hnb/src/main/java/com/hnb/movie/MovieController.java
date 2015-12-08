package com.hnb.movie;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;

	@RequestMapping("/Movie")
	public String home(){
		logger.info("AdminController-home() 진입");
		return "movie/Movie";
	}
	@RequestMapping("/movie_info")
	public String movieInfo(Model model){
		logger.info("AdminController-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList", list);
		logger.info("영화 리스트 조회결과 : {}", list);
		return "movie/movie_info";
	}
	@RequestMapping("/movie_name/{movieName}")
	public String movieName(
			@PathVariable ("movieName")String name, Model model){
		logger.info("AdminController-movieName() 진입");
		logger.info("영화 아이디 : {}", name);
		movie = service.searchByName(name);
		logger.info("영화제목 : {}", movie.getFilmName());
		model.addAttribute("movie", movie);
		return "movie/movie_name";
	} 
	@RequestMapping("/movie_Cut")
	public String movieCut(String filmNumber, Model model){
		logger.info("AdminController-movieCut() 진입");
		logger.info("영화 스틸컷 : {}", filmNumber);
		movie = service.searchByName(filmNumber);
		String cut = movie.getCut();
		String[]arr = cut.split("/");
		for (int i = 0; i < arr.length; i++) {
			logger.info(arr[i]);
		}
		model.addAttribute("arr", arr);
		return "movie/movie_Cut";
	}
	@RequestMapping("/movie_Tra")
	public String movieTra(String filmNumber, Model model){
		logger.info("AdminController-movieTra() 진입");
		logger.info("영화 트레일러 : {}", filmNumber);
		movie = service.searchByName(filmNumber);
		String tra = movie.getTrailer();
		logger.info("get 트레일러 : {}", tra);
		String[]arrt = tra.split("/");
		for (int i = 0; i < arrt.length; i++) {
			logger.info(arrt[i]);
		}
		model.addAttribute("arrt", arrt);
		return "movie/movie_Tra";
	}
	@RequestMapping("/movie_Basic")
	public String movieBasic(String filmNumber, Model model){
		logger.info("AdminController-movieBasic() 진입");
		logger.info("movieBasic의 film넘버 : {}", filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("movieBasic컷의영화제목 : {} ", movie.getFilmName());
		model.addAttribute("movie", movie);
		return "movie/movie_Basic";
	}
	@RequestMapping("/movie_Chart")
	public String movieChart(String filmNumber, Model model){
		logger.info("AdminController-movieChart() 진입");
		
		return "movie/movie_Chart";
	}
}
