package com.qrisma.ckeditor.controller;

import com.qrisma.ckeditor.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DeleteController {
  private final ContentService contentService;

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") String id) {
    contentService.delete(id);
    return "redirect:/list";
  }
}
