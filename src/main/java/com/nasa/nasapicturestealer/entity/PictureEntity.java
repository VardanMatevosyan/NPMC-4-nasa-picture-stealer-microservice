package com.nasa.nasapicturestealer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Table(name = "picture")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"nasaId", "imgSrc"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PictureEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Integer id;

  @Column(name = "nasa_id")
  Integer nasaId;

  @Column(name = "img_src")
  String imgSrc;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "camera_id", referencedColumnName = "id")
  CameraEntity camera;

  @Column(name = "created_at")
  LocalDateTime createdAt;
}
