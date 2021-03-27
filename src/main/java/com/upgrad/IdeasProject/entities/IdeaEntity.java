package com.upgrad.IdeasProject.entities;

import java.util.Objects;


/**
 * I will store this entity in memory
 */

public class IdeaEntity {

  private long id ;
  private String ideaName ;
  private String authorName ;
  private String description ;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIdeaName() {
    return ideaName;
  }

  public void setIdeaName(String ideaName) {
    this.ideaName = ideaName;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "IdeaEntity{" + "id=" + id + ", ideaName='" + ideaName + '\'' + ", authorName='" + authorName + '\''
        + ", description='" + description + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdeaEntity that = (IdeaEntity) o;
    return id == that.id && Objects.equals(ideaName, that.ideaName) && Objects.equals(authorName, that.authorName)
        && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ideaName, authorName, description);
  }
}
