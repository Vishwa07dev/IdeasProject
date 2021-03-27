package com.upgrad.IdeasProject.controller;

import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.exceptions.IdeaNotFoundException;
import com.upgrad.IdeasProject.services.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ideas")
public class IdeaServiceController {

  @Autowired
  private IdeaService ideaService ;

  @PostMapping
  public ResponseEntity<Object> createIdea(@RequestBody IdeaDTO ideaDTO){
    System.out.println("POST method is called");
    ideaService.saveIdea(ideaDTO);
    return new ResponseEntity<>(ideaDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> getAllIdeas(){
    System.out.println("GET All method is called");
    return new ResponseEntity<>(ideaService.getAllIdeas(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getIdea(@PathVariable("id") Long id) throws IdeaNotFoundException {
     return new ResponseEntity<>(ideaService.getIdea(id),HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity updateIdea(@PathVariable("id") Long id , @RequestBody IdeaDTO ideaDTO)
      throws IdeaNotFoundException {
    ideaService.updateIdea(ideaDTO);
    return new ResponseEntity(ideaDTO, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteIdea(@PathVariable("id") Long id){
    ideaService.deleteIdea(id);
    return new ResponseEntity(null, HttpStatus.OK);
  }


}
