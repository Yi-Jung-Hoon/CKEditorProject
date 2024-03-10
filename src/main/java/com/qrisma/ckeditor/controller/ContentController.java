package com.qrisma.ckeditor.controller;

import com.qrisma.ckeditor.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ContentController {
  private final ContentService contentService;
  @GetMapping("/content/{id}")
  public String contentPage(@PathVariable("id") String id, Model model) {
    model.addAttribute("Content", contentService.selectOneContent(id));
    return "content";
  }
}