package com.upgrad.IdeasProject.services.serviceimpl;

import com.upgrad.IdeasProject.dao.IdeaDAO;
import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.entities.IdeaEntity;
import com.upgrad.IdeasProject.exceptions.IdeaNotFoundException;
import com.upgrad.IdeasProject.services.IdeaService;
import com.upgrad.IdeasProject.util.POJOConvertor;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IdeaServiceImpl implements IdeaService {

  @Autowired
  private IdeaDAO ideaDAO ;

  @Override
  public IdeaDTO saveIdea(IdeaDTO ideaDTO) {

    //Convert IdeaDTO to IdeaEntity
    return POJOConvertor.covertIdeaEntitytoIdeaDTO(ideaDAO.save(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO)));
  }

  @Override
  public IdeaDTO updateIdea(IdeaDTO ideaDTO) throws IdeaNotFoundException {

    IdeaEntity ideaEntity = ideaDAO.find(ideaDTO.getId());

    if(ideaEntity ==null){
      throw new IdeaNotFoundException("Idea details for idea id : ["+ ideaDTO.getId()+ "] is not found");
    }
    return POJOConvertor.covertIdeaEntitytoIdeaDTO(ideaDAO.update(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO)));

  }

  @Override
  public List<IdeaDTO> getAllIdeas() {
    return ideaDAO.findAll().stream().
        map(ideaEntity ->POJOConvertor.covertIdeaEntitytoIdeaDTO(ideaEntity))
        .collect(
        Collectors.toList());
  }

  @Override
  public IdeaDTO getIdea(long id) throws IdeaNotFoundException {

    IdeaEntity ideaEntity = ideaDAO.find(id);

    if(ideaEntity ==null){
      throw new IdeaNotFoundException("Idea details for idea id : ["+ id+ "] is not found");
    }
    return POJOConvertor.covertIdeaEntitytoIdeaDTO(ideaDAO.find(id));
  }

  @Override
  public void deleteIdea(long id) {
    ideaDAO.delete(id);
  }
}
