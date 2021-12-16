package com.example.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhome.model.Board;
import com.example.myhome.repository.BoardRepository;

@RestController
@RequestMapping("/api")
class BoardApiController {

	
	@Autowired
  private BoardRepository repository;

  void BoardAPiController(BoardRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/board")
  List<Board> all(@RequestParam(required = false) String title) {
	  if(StringUtils.isEmpty(title)) {
		  return repository.findAll();
	  }else {
    return repository.findByTitle(title);
  }
  }
  // end::get-aggregate-root[]

  @PostMapping("/board")
  Board newEmployee(@RequestBody Board newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/board/{id}")
  Board one(@PathVariable Long id) {
    
    return repository.findById(id).orElseGet(null);
  }

  @PutMapping("/board/{bno}")
  Board replaceEmployee(@RequestBody   Board newEmployee, @PathVariable Long bno) {
    
    return repository.findById(bno)
      .map(employee -> {
        employee.setTitle(newEmployee.getTitle());
        employee.setContent(newEmployee.getContent());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setBno(bno);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/board/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}