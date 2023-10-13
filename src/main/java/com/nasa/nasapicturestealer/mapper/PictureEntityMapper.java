package com.nasa.nasapicturestealer.mapper;

import com.nasa.nasapicturestealer.entity.PictureEntity;
import com.nasa.nasapicturestealer.model.Photo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.context.annotation.RequestScope;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    imports = {LocalDateTime.class})
@RequestScope
public interface PictureEntityMapper {

  Set<PictureEntity> toEntities(List<Photo> photos);

  @Mapping(target = "nasaId", source = "id")
  @Mapping(target = "imgSrc", source = "imgSrc")
  @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "camera", ignore = true)
  PictureEntity toPictureEntity(Photo photo);


}
