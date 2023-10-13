package com.nasa.nasapicturestealer.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.nasa.nasapicturestealer.dto.StealPictureRequestDto;
import com.nasa.nasapicturestealer.entity.CameraEntity;
import com.nasa.nasapicturestealer.mapper.CameraEntityMapper;
import com.nasa.nasapicturestealer.model.Camera;
import com.nasa.nasapicturestealer.model.Photo;
import com.nasa.nasapicturestealer.model.PhotoWrapper;
import com.nasa.nasapicturestealer.repository.CameraEntityRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NasaPictureServiceImpl implements NasaPictureService {

  private final RestTemplate restTemplate;
  private final CameraEntityRepository cameraEntityRepository;
  private final CameraEntityMapper cameraEntityMapper;
  @Value("${nasa.client.url}")
  private String nasaClientUrl;
  @Value("${nasa.client.key}")
  private String key;

  @Override
  public void savePictures(StealPictureRequestDto request) {
    List<Photo> photos = getAllPhotos(request.getSol()).getPhotos();
    Map<Camera, List<Photo>> cameraToPhotosMap = covertToMap(photos);
    Set<CameraEntity> cameras = cameraEntityMapper.mapToEntities(cameraToPhotosMap);
    cameraEntityRepository.saveAll(cameras);
  }
  private Map<Camera, List<Photo>> covertToMap(List<Photo> photos) {

    // todo was before
//        return photos.stream()
//        .collect(Collectors.groupingBy(
//            Photo::getCamera,
//            Collectors.mapping(photo -> photo, Collectors.toList())));


    // todo after refactoring
            return photos.stream().collect(groupingBy(Photo::getCamera, toList()));
  }
  private PhotoWrapper getAllPhotos(Integer sol) {
    // todo was before 
//    return restTemplate.getForEntity(nasaClientUrl, PhotoWrapper.class, getHeaders(sol)).getBody();

    // todo after refactoring
    return restTemplate.getForObject(nasaClientUrl, PhotoWrapper.class, getHeaders(sol));
  }
  private Map<String, Object> getHeaders(Integer sol) {
    return Map.of("sol", sol, "api_key", key);
  }
}
