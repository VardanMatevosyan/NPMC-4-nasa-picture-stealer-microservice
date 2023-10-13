package com.nasa.nasapicturestealer;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import com.nasa.nasapicturestealer.entity.CameraEntity;
import com.nasa.nasapicturestealer.model.Camera;
import com.nasa.nasapicturestealer.model.Photo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NasaPictureStealerApplicationTests {

	@Test
	void contextLoads() {
	}

}
