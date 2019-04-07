package com.example.calculatebmi;

public class Arthemetic {


    float height,weight;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Arthemetic(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float getBIM(){
        float convertMeter=height/100;
        float bim=weight/(convertMeter*convertMeter);
        return bim;
    }


}
