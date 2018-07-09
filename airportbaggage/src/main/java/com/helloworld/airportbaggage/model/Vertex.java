package com.helloworld.airportbaggage.model;
public class Vertex {
    private String name;

    public Vertex(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vertex && ((Vertex) obj).getName().equals(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

}