package com.avios.cp.starter.rest.helper;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.avios.cp.starter.rest.dto.Header;
import com.avios.cp.starter.rest.dto.Message;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;

public class RestAPIWrapperHelper {

	public static <T> RestAPIWrapper<T> prepSuccessResponse(T data, Header header) {

		RestAPIWrapper<T> wrapper = new RestAPIWrapper<>();

		wrapper.setData(data);
		wrapper.setSuccess(true);
		wrapper.setHeader(header == null ? getDefaultHeader() : header);
		wrapper.setStatus(HttpStatus.OK);

		return wrapper;
	}

	public static List<Message> prepMessages(List<String> errorCodes) {

		List<Message> messages = new LinkedList<>();

		errorCodes.stream().forEach(errorCode -> {

			Message message = new Message(errorCode, null);
			messages.add(message);
		});

		return messages;
	}

	private static Header getDefaultHeader() {

		Header header = new Header();

		header.setCount(1);
		header.setPage(1);
		header.setTotalCount(1);

		return header;
	}
}