package com.upgrad.IdeasProject.services.serviceimpl;

import com.upgrad.IdeasProject.dao.IdeaDAO;
import com.upgrad.IdeasProject.dao.daoimpl.IdeaDAOImpl;
import com.upgrad.IdeasProject.dto.IdeaDTO;
import com.upgrad.IdeasProject.exceptions.IdeaNotFoundException;
import com.upgrad.IdeasProject.services.IdeaService;
import com.upgrad.IdeasProject.util.POJOConvertor;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdeaServiceImplTestWithMockito {

  @Mock
  private IdeaDAOImpl ideaDAO;

  @InjectMocks
  private IdeaServiceImpl ideaService ;


  @BeforeEach
  public   void settingUpDataForTesting(){

    IdeaDTO ideaDTO1 = new IdeaDTO();
    ideaDTO1.setId(121);
    ideaDTO1.setAuthorName("Vishwa");
    ideaDTO1.setIdeaDescription("Cool Idea");
    ideaDTO1.setIdeaName("My first idea");

    Mockito.when(ideaDAO.save(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO1))).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO1));
    ideaService.saveIdea(ideaDTO1);

    IdeaDTO ideaDTO2 = new IdeaDTO();
    ideaDTO2.setId(122);
    ideaDTO2.setAuthorName("Vishwa2");
    ideaDTO2.setIdeaDescription("Cool Idea");
    ideaDTO2.setIdeaName("My first idea");
    Mockito.when(ideaDAO.save(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO2))).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO2));

    ideaService.saveIdea(ideaDTO2);

    IdeaDTO ideaDTO3 = new IdeaDTO();
    ideaDTO3.setId(123);
    ideaDTO3.setAuthorName("Vishwa3");
    ideaDTO3.setIdeaDescription("Cool Idea");
    ideaDTO3.setIdeaName("My first idea");
    Mockito.when(ideaDAO.save(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO3))).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO3));

    ideaService.saveIdea(ideaDTO3);

  }

  @Test
  public void testSaveIdea(){

    IdeaDTO ideaDTO = new IdeaDTO();
    ideaDTO.setId(12345);
    ideaDTO.setAuthorName("Vishwa");
    ideaDTO.setIdeaDescription("Cool Idea");
    ideaDTO.setIdeaName("My first idea");

    Mockito.when(ideaDAO.save(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO))).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTO));

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

    Mockito.when(ideaDAO.find(122)).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTOUpdated));
    Mockito.when(ideaDAO.update(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTOUpdated))).thenReturn(POJOConvertor.covertIdeaDTOtoIdeaEntity(ideaDTOUpdated));

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

}
