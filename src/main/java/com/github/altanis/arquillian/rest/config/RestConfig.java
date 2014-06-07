package com.github.altanis.arquillian.rest.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(RestConfig.APPLICATION_PATH)
public class RestConfig extends Application {

    public static final String APPLICATION_PATH = "/rest";

}
