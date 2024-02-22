package com.nasa.nasapicturestealer.mapper;

import com.nasa.nasapicturestealer.entity.CameraEntity;
import com.nasa.nasapicturestealer.model.Camera;
import com.nasa.nasapicturestealer.model.Photo;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T17:36:18+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.9 (Private Build)"
)
@Component
public class CameraEntityMapperImpl extends CameraEntityMapper {

    @Override
    CameraEntity toEntity(Camera camera, List<Photo> photos) {
        if ( camera == null && photos == null ) {
            return null;
        }

        CameraEntity cameraEntity = new CameraEntity();

        if ( camera != null ) {
            cameraEntity.setNasaId( camera.getId() );
            cameraEntity.setName( camera.getName() );
        }
        if ( photos != null ) {
            cameraEntity.setPictures( mapPictureEntities( photos ) );
        }
        cameraEntity.setCreatedAt( LocalDateTime.now() );

        mapPictureEntities( cameraEntity );

        return cameraEntity;
    }
}
