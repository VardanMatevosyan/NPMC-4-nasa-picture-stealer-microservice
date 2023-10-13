package com.nasa.nasapicturestealer.mapper;

import static java.util.stream.Collectors.toSet;

import com.nasa.nasapicturestealer.entity.CameraEntity;
import com.nasa.nasapicturestealer.entity.PictureEntity;
import com.nasa.nasapicturestealer.model.Camera;
import com.nasa.nasapicturestealer.model.Photo;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    imports = {LocalDateTime.class},
    uses = {PictureEntityMapper.class})
public abstract class CameraEntityMapper {

  @Autowired
  PictureEntityMapper pictureEntityMapper;

  @Mapping(target = "nasaId", source = "camera.id")
  @Mapping(target = "name", source = "camera.name")
  @Mapping(target = "pictures", source = "photos", qualifiedByName = "mapPictureEntities")
  @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
  @Mapping(target = "id", ignore = true)
  abstract CameraEntity toEntity(Camera camera, List<Photo> photos);

  public Set<CameraEntity> mapToEntities(Map<Camera, List<Photo>> cameraToPhotosMap) {
    // todo was before
//    Set<CameraEntity> cameraEntities = new HashSet<>();
//    cameraToPhotosMap.forEach((key, value) -> {
//      CameraEntity cameraEntity = toEntity(key);
//      cameraEntity.addAllPicture(mapPictureEntities(value, cameraEntity));
//      cameraEntities.add(cameraEntity);
//    });
//    return cameraEntities;

    // todo after refactoring
    return cameraToPhotosMap.entrySet()
        .stream()
        .map(entry -> toEntity(entry.getKey(), entry.getValue()))
        .collect(toSet());

  }

  @Named(value = "mapPictureEntities")
  protected Set<PictureEntity> mapPictureEntities(List<Photo> photos) {
    return pictureEntityMapper.toEntities(photos);
  }

  @AfterMapping
  protected void mapPictureEntities(@MappingTarget  CameraEntity cameraEntity) {
    cameraEntity.getPictures().forEach(picture -> picture.setCamera(cameraEntity));
  }

}
