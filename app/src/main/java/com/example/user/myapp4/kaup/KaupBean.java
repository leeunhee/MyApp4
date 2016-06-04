package com.example.user.myapp4.kaup;

/**
 * Created by USER on 2016-06-04.
 */
public class KaupBean { // 읽고 씨는 제약만하였음
    private String result, name;
    private double weight, height;

    // Alt + Insert > Getter Setter 선택
    public String getResult() { // get->read only
        return result;
    }

    public void setResult(String result) { // set -> Write
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
