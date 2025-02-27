package com.test.spring.entity;

import java.util.Map;
import java.util.Set;

public class User {
    private  Long id;

    private Map<String, String> maps;
    private Set<String> sets;

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
