//股东
package com.pair7z.echartapi.entity;

public class Shareholder {
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "Shareholder{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public Shareholder(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
