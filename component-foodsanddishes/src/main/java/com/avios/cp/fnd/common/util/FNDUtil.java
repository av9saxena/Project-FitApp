package com.avios.cp.fnd.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FNDUtil {

	@Autowired
	private ObjectMapper mapper;

	public <T> T convertPayload(Object object, Class<T> T) {

		T t = (T) mapper.convertValue(object, T);

		return t;
	}

	public String getCreatedTimeStamp() {

		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC"));

		return convertFormat(localDateTime);
	}

	private String convertFormat(LocalDateTime localDateTime) {

		DateTimeFormatter builder = DateTimeFormatter.ofPattern("dd-MM-yy'T'hh:mm:ss.sss");

		String convertedDate = builder.format(localDateTime);

		return convertedDate;
	}
}
