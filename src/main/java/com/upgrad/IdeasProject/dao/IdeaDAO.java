package com.upgrad.IdeasProject.dao;

import com.upgrad.IdeasProject.entities.IdeaEntity;
import java.util.List;


/**
 *
 */
public interface IdeaDAO {

  /**
   *
   * @param ideaEntity
   */
  public IdeaEntity save(IdeaEntity ideaEntity);

  /**
   *
   * @param id
   * @return
   */
  public IdeaEntity find(long id);

  /**
   *
   * @return
   */
  public List<IdeaEntity> findAll();

  /**
   *
   * @param ideaEntity
   */
  public IdeaEntity update(IdeaEntity ideaEntity);

  /**
   *
   * @param id
   */
  public void delete(long id);





}
