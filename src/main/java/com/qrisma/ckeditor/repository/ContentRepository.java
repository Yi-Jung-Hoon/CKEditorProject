package com.qrisma.ckeditor.repository;

import com.qrisma.ckeditor.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
  ContentEntity findById(int id);
}
