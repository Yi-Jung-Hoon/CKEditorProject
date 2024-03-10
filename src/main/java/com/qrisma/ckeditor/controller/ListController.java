package com.qrisma.ckeditor.controller;

import com.qrisma.ckeditor.entity.ContentEntity;
import com.qrisma.ckeditor.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ListController {
  private final ContentService contentService;
  @GetMapping("/list")
  public String listPage(Model model) {
    model.addAttribute("ContentList", contentService.selectContent());
    return "list";
  }
}
