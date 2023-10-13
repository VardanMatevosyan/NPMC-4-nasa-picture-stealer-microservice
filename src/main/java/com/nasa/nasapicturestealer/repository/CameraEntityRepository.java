package com.nasa.nasapicturestealer.repository;

import com.nasa.nasapicturestealer.entity.CameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraEntityRepository extends JpaRepository<CameraEntity, Integer> {

}
