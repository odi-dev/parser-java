package com.odi.parser.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {

    }

    public static String toJsonString(Object pojo) throws IOException {
        return mapper.writeValueAsString(pojo);
    }

    public static JsonNode toJsonNode(String content) throws IOException {
        return mapper.readTree(content);
    }

    public static <T> T toValue(TreeNode n, Class<T> type) throws JsonProcessingException {
        return mapper.treeToValue(n, type);
    }

    public static <T> T toObject(String json, Class<T> type) throws IOException {
        return mapper.readValue(json, type);
    }
}
