package org.wfp.fittest.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class JsonObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -5674082390513628965L;

	public JsonObjectMapper() {
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		setDateFormat(new ISO8601DateFormat());
	}
}