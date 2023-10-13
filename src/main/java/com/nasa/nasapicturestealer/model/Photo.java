package com.nasa.nasapicturestealer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Photo {

  Integer id;

  Camera camera;

  @JsonProperty("img_src")
  String imgSrc;

}
