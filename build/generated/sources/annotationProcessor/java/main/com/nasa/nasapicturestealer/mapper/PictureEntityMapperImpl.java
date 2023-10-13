package com.nasa.nasapicturestealer.mapper;

import com.nasa.nasapicturestealer.entity.PictureEntity;
import com.nasa.nasapicturestealer.model.Photo;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-13T23:23:15+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.8.1 (Private Build)"
)
@Component
public class PictureEntityMapperImpl implements PictureEntityMapper {

    @Override
    public Set<PictureEntity> toEntities(List<Photo> photos) {
        if ( photos == null ) {
            return null;
        }

        Set<PictureEntity> set = new HashSet<PictureEntity>( Math.max( (int) ( photos.size() / .75f ) + 1, 16 ) );
        for ( Photo photo : photos ) {
            set.add( toPictureEntity( photo ) );
        }

        return set;
    }

    @Override
    public PictureEntity toPictureEntity(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        PictureEntity pictureEntity = new PictureEntity();

        pictureEntity.setNasaId( photo.getId() );
        pictureEntity.setImgSrc( photo.getImgSrc() );

        pictureEntity.setCreatedAt( LocalDateTime.now() );

        return pictureEntity;
    }
}
