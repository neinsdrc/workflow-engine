package org.radrso.plugins.requests.entity;

import java.io.Serializable;

/**
 * Created by raomengnan on 16-12-9.
 */
public enum MethodEnum implements Serializable {
    GET("Get"),
    POST("Post"),
    PUT("Put"),
    DELETE("Delete");

    String methodName;

    MethodEnum(String name) {
        this.methodName = name;
    }

    public String value() {
        return this.methodName;
    }
}
