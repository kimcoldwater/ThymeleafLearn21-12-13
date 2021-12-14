package com.example.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhome.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
