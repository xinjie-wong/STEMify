package com.example.stemify.ui.moduleA;

import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.parceler.Parcel;

@Parcel
public class Material {
    String title;
    String type; // Can either be "VideoLesson", "Practice" or "Quiz"
    int points;

    public Material() {
        this.title = "";
        this.type = "";
        this.points = 0;
    }

    public Material(String title) {
        this.title = title;
        this.type = "";
        this.points = 0;
    }

    public Material(String title, String type, int points) {
        this.title = title;
        this.type = type;
        this.points = points;
    }

    public VideoLesson createFromMaterial(String type, Material material){

        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getMasteryPoints(){
        // Work on the backend logic later
        return "Points";
    }
}
