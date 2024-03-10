package com.qrisma.ckeditor.controller;

import com.qrisma.ckeditor.dto.SaveDto;
import com.qrisma.ckeditor.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SaveController {
  private final ContentService contentService;
  @PostMapping("/save")
  public String saveLogic(SaveDto saveDto) {
    contentService.save(saveDto);
    return "redirect:/";
  }
  @PostMapping("/save/{id}")
  public String updateLogic(SaveDto saveDto, @PathVariable("id") String id) {
    contentService.update(saveDto, id);
    return "redirect:/content/"+id;
  }
}
