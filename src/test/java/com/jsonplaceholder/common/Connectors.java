package com.jsonplaceholder.common;

import io.restassured.RestAssured;
import com.jsonplaceholder.utils.PropertiesHandler;

public class Connectors {

    private static final PropertiesHandler props = PropertiesHandler.getInstance();
    private static final String URI = props.getProperty("serviceHost");

    public static void setServiceConnection(){
        setServicePort();
        setServiceHost();
        setServiceBasePath();
    }

    private static void setServicePort(){
        final String port = props.getProperty("servicePort");
        if (port == null)
            RestAssured.port = 443;
        else
            RestAssured.port = Integer.valueOf(port);
    }

    private static void setServiceHost(){
        final String url = props.getProperty("serviceHost");

        if (url == null)
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        else
            RestAssured.baseURI = url;
    }

    private static void setServiceBasePath(){
        final String path = props.getProperty("servicePath");

        if (path == null)
            RestAssured.basePath = "/";
        else
            RestAssured.basePath = path;
    }
}
