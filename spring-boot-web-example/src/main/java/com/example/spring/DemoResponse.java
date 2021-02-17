package com.example.spring;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoResponse {

    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private final String name;

    @JsonCreator
    public DemoResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
