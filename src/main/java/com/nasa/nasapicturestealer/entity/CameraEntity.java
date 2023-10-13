package com.nasa.nasapicturestealer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table(name = "camera")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"nasaId", "name"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CameraEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Integer id;

  @Column(name = "nasa_id")
  Integer nasaId;

  @Column(name = "name")
  String name;

  @Column(name = "created_at")
  LocalDateTime createdAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "camera", cascade = CascadeType.ALL)
  Set<PictureEntity> pictures = new HashSet<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNasaId() {
    return nasaId;
  }

  public void setNasaId(Integer nasaId) {
    this.nasaId = nasaId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Set<PictureEntity> getPictures() {
    return pictures;
  }
  public void setPictures(Set<PictureEntity> pictures) {
    this.pictures = pictures;
  }

  public void addPicture(PictureEntity picture) {
    getPictures().add(picture);
  }
  public void addAllPicture(Set<PictureEntity> pictures) {
    getPictures().addAll(pictures);
  }
}
