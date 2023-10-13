package com.nasa.nasapicturestealer.service;

import com.nasa.nasapicturestealer.dto.StealPictureRequestDto;

public interface NasaPictureService {
  void savePictures(StealPictureRequestDto request);

}
