package ru.tsu.quizium;

import android.graphics.drawable.Drawable;

public class Quiz {

    private final String name;
    private final String description;
    private final String author;
    private final Drawable previewPicture;

    public Quiz(String name, String description, String author, Drawable picture) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.previewPicture = picture;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getAuthor(){
        return author;
    }

    public Drawable getPreviewPicture() { return previewPicture; }
}
