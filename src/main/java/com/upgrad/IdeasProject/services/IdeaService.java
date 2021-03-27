package com.upgrad.IdeasProject.services;

import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.exceptions.IdeaNotFoundException;
import java.util.List;


/**
 * Contract for the service layer
 */
public interface IdeaService {

  public IdeaDTO saveIdea(IdeaDTO ideaDTO);

  public IdeaDTO updateIdea(IdeaDTO ideaDTO) throws IdeaNotFoundException;

  public List<IdeaDTO> getAllIdeas();

  public IdeaDTO getIdea(long id) throws IdeaNotFoundException;

  public void deleteIdea(long id);

}
