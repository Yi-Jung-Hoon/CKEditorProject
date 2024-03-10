package com.qrisma.ckeditor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class FileUploadController {
  // 파일이 저장될 경로
  @Value("${upload.dir}")
  private String UPLOAD_DIR;

  @PostMapping("/upload")
  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    try {
      // 업로드된 파일의 원래 파일명
      String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

      // 파일명 중복을 방지하기 위해 UUID를 이용하여 새로운 파일명 생성
      String newFileName = UUID.randomUUID().toString() + "_" + originalFileName;

      // 업로드된 이미지 파일을 가져옵니다.
      File savedFile = new File(UPLOAD_DIR + newFileName);
      file.transferTo(savedFile);

      // 저장할 경로 생성
//      Path paths = Paths.get(UPLOAD_DIR);
//      Path filePath = paths.resolve(newFileName);

      // 파일 저장
//      Files.copy(file.getInputStream(), filePath);

      return ResponseEntity.ok("File uploaded successfully!");
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("Error uploading file");
    }
  }
}
