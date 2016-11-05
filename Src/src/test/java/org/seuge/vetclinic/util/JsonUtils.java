package org.seuge.vetclinic.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Application configuration property names constants
 *
 * @author Eugene
 * @since 1.0
 */
public final class JsonUtils {

    private JsonUtils() {
    }

    public static String serializeToString(Object object) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.writeValueAsString(object);
    }

    public static <ObjectType> ObjectType deserializeFromString(String string, Class<ObjectType> clazz)
            throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(string, clazz);
    }
}
