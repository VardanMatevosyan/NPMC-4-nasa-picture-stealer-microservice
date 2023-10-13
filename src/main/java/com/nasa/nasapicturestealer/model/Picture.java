package com.nasa.nasapicturestealer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
  private byte[] content;
  private String url;
  private long contentLength;
}
