package com.nasa.nasapicturestealer.controller;

import com.nasa.nasapicturestealer.dto.StealPictureRequestDto;
import com.nasa.nasapicturestealer.service.NasaPictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NasaPictureController {

  private NasaPictureService nasaPictureService;

  @PostMapping("/pictures/steal")
  public ResponseEntity<Void> stealPictures(@RequestBody StealPictureRequestDto request) {
    nasaPictureService.savePictures(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
