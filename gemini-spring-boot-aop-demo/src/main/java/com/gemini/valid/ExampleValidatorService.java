package com.gemini.valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 示例
 * 
 *
 */
@Validated
@Service
public class ExampleValidatorService {

	private static final Logger logger = LoggerFactory.getLogger(ExampleValidatorService.class);

	public String show(@NotNull(message = "不能为空") @Min(value = 18, message = "最小18") String age) {
		logger.info("age = {}", age);
		return age;
	}

}

