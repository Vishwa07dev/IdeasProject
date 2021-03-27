package com.upgrad.IdeasProject.dao.daoimpl;

import com.upgrad.IdeasProject.dao.IdeaDAO;
import com.upgrad.IdeasProject.entities.IdeaEntity;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;


@Repository
public class IdeaDAOImpl implements IdeaDAO {


  private static final Map<Long , IdeaEntity> IDEA_STORE = new ConcurrentHashMap<>();

  @Override
  public IdeaEntity save(IdeaEntity ideaEntity) {

    IDEA_STORE.put(ideaEntity.getId(), ideaEntity);
    return ideaEntity ;
  }

  @Override
  public IdeaEntity find(long id) {
    return IDEA_STORE.get(id);
  }

  @Override
  public List<IdeaEntity> findAll() {
    return IDEA_STORE.values().stream().collect(Collectors.toList());
  }

  @Override
  public IdeaEntity update(IdeaEntity ideaEntity) {
    IDEA_STORE.put(ideaEntity.getId(), ideaEntity);
    return ideaEntity ;
  }

  @Override
  public void delete(long id) {
    IDEA_STORE.remove(id);
  }
}
