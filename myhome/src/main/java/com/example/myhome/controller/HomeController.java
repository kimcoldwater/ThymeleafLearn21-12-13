package com.example.myhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "index";
	}
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String list(Model model,@PageableDefault(size=2) Pageable pageable) throws Exception{
		Page<Board> boardList = boardRepository.findAll(pageable);
		int startPage = Math.max(1, boardList.getPageable().getPageNumber()-4);
		int endPage = Math.min(boardList.getTotalPages(), boardList.getPageable().getPageNumber() + 4);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boardTotal",boardList.getTotalElements());
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	@PostMapping("/board/form")
	public String saveBoard(Board board) {
	boardRepository.save(board);
	return "redirect:/board/list";
	}
}
