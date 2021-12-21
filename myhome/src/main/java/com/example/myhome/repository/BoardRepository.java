package com.example.myhome.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhome.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	List<Board> findByTitle(String title);
	
	Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
