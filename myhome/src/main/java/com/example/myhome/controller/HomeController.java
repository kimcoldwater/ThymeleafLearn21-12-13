package com.example.myhome.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myhome.model.Board;
import com.example.myhome.repository.BoardRepository;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping
	public String index() throws Exception {
		logger.info("홈컨트롤러 들어옴");
		return "index";
	}
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<Board> boardList = boardRepository.findAll();

		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	@PostMapping("/board/form")
	public String saveBoard(Board board) {
	boardRepository.save(board);
	return "redirect:/board/list";
	}
}
