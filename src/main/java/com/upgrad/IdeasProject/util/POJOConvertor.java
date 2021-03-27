package com.upgrad.IdeasProject.util;

import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.entities.IdeaEntity;


public class POJOConvertor {

  public static IdeaEntity covertIdeaDTOtoIdeaEntity(IdeaDTO ideaDTO){
    IdeaEntity ideaEntity = new IdeaEntity();

    ideaEntity.setId(ideaDTO.getId());
    ideaEntity.setAuthorName(ideaDTO.getAuthorName());
    ideaEntity.setDescription(ideaDTO.getIdeaDescription());
    ideaEntity.setIdeaName(ideaDTO.getIdeaName());

    return ideaEntity;
  }


  public static IdeaDTO covertIdeaEntitytoIdeaDTO(IdeaEntity ideaEntity){
    IdeaDTO ideaDTO = new IdeaDTO();

    ideaDTO.setId(ideaEntity.getId());
    ideaDTO.setAuthorName(ideaEntity.getAuthorName());
    ideaDTO.setIdeaDescription(ideaEntity.getDescription());
    ideaDTO.setIdeaName(ideaEntity.getIdeaName());

    return ideaDTO;
  }

}
