package com.upgrad.IdeasProject.services.serviceimpl;

import com.sun.media.jfxmediaimpl.HostUtils;
import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.exceptions.IdeaNotFoundException;
import com.upgrad.IdeasProject.services.IdeaService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdeaServiceImplTestWithoutMockito {

  @Autowired
  private IdeaService ideaService;


  @Test
  public void myFirstTest(){
    System.out.println("Hello Testing");

    Assertions.assertNotNull(ideaService);
  }

  @BeforeEach
  public   void settingUpDataForTesting(){
    IdeaDTO ideaDTO1 = new IdeaDTO();
    ideaDTO1.setId(121);
    ideaDTO1.setAuthorName("Vishwa");
    ideaDTO1.setIdeaDescription("Cool Idea");
    ideaDTO1.setIdeaName("My first idea");

    System.out.println(ideaService);
    ideaService.saveIdea(ideaDTO1);

    IdeaDTO ideaDTO2 = new IdeaDTO();
    ideaDTO2.setId(122);
    ideaDTO2.setAuthorName("Vishwa2");
    ideaDTO2.setIdeaDescription("Cool Idea");
    ideaDTO2.setIdeaName("My first idea");

    ideaService.saveIdea(ideaDTO2);

    IdeaDTO ideaDTO3 = new IdeaDTO();
    ideaDTO3.setId(123);
    ideaDTO3.setAuthorName("Vishwa3");
    ideaDTO3.setIdeaDescription("Cool Idea");
    ideaDTO3.setIdeaName("My first idea");

    ideaService.saveIdea(ideaDTO3);

  }

  @Test
  public void testSaveIdea(){

    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setId(12345);
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setIdeaDescription("Cool Idea");
    ideaDTO.setIdeaName("My first idea");


    IdeaDTO ideaDTOSaved = ideaService.saveIdea(ideaDTO);

    Assertions.assertNotNull(ideaDTOSaved);
    Assertions.assertEquals(12345, ideaDTOSaved.getId());
    Assertions.assertEquals("Vishwa", ideaDTOSaved.getAuthorName());
    Assertions.assertNotNull(ideaDTOSaved.getIdeaDescription());
    Assertions.assertNotNull(ideaDTOSaved.getIdeaName());


  }
  @Test
  public void testUpdateIdea() throws IdeaNotFoundException {

    IdeaDTO ideaDTOUpdated = new IdeaDTO();
    ideaDTOUpdated.setId(122);
    ideaDTOUpdated.setAuthorName("Vishwa2");
    ideaDTOUpdated.setIdeaDescription("Cool Idea : UPDATED");
    ideaDTOUpdated.setIdeaName("My first idea");

    IdeaDTO updatedIdea = ideaService.updateIdea(ideaDTOUpdated);

    System.out.println(updatedIdea);

    Assertions.assertNotNull(updatedIdea);
    Assertions.assertTrue(updatedIdea.getIdeaDescription().contains("UPDATED"));

  }

  @Test
  public void testGetAllIdeas(){

    List<IdeaDTO> ideaDTOs = ideaService.getAllIdeas();
    Assertions.assertNotNull(ideaDTOs);
    Assertions.assertEquals(3, ideaDTOs.size());

  }

  @Test
  public void testGetIdeaBasedOnId() throws IdeaNotFoundException {

    IdeaDTO  ideaDTO = ideaService.getIdea(123);
    Assertions.assertNotNull(ideaDTO);
    Assertions.assertEquals(123, ideaDTO.getId());

  }

  public void testDeleteIdea(long id){

  }


}
