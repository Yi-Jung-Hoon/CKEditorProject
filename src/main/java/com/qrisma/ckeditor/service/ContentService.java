package com.qrisma.ckeditor.service;

import com.qrisma.ckeditor.dto.SaveDto;
import com.qrisma.ckeditor.entity.ContentEntity;
import com.qrisma.ckeditor.repository.ContentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
  private final ContentRepository contentRepository;

  public void save(SaveDto saveDto) {
    ContentEntity content = ContentEntity.builder()
            .title(saveDto.getTitle())
            .content(saveDto.getContent())
            .build();

    contentRepository.save(content);
  }

  public List<ContentEntity> selectContent() {
    return contentRepository.findAll();
  }

  public ContentEntity selectOneContent(String id) {
    return contentRepository.findById(Integer.parseInt(id));
  }

  public void delete(String id) {
    contentRepository.deleteById(Integer.parseInt(id));
  }

  public void update(SaveDto saveDto, String id) {
    ContentEntity content = ContentEntity.builder()
            .id(Integer.parseInt(id))
            .title(saveDto.getTitle())
            .content(saveDto.getContent())
            .build();
    contentRepository.save(content);
  }
}
