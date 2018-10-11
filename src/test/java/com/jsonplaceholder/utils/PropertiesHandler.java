package com.jsonplaceholder.utils;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Stream;

public class PropertiesHandler {

    private static PropertiesHandler instance;
    @Getter
    private final Properties properties;
    private String[] resources = {"remote-config.properties"};

    private PropertiesHandler() {
        properties = new Properties();
        ClassLoader cl = getClass().getClassLoader();
        Stream.of(resources).forEach(r -> {
            try (InputStreamReader is = new InputStreamReader(cl.getResourceAsStream(r), "UTF-8")) {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static PropertiesHandler getInstance() {
        if (instance == null) instance = new PropertiesHandler();
        return instance;
    }

    public String getProperty(String propertyName) {
        return instance.getProperties().getProperty(propertyName);
    }

    public Integer getIntProperty(String propertyName) {
        return Integer.valueOf(instance.getProperties().getProperty(propertyName));
    }
}