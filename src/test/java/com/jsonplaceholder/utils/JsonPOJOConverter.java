package com.jsonplaceholder.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPOJOConverter {

    public static <T> String serializeToJson(T type) {
        try {
            return new ObjectMapper().writeValueAsString(type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
