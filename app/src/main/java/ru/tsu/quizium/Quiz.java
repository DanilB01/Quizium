package ru.tsu.quizium;

import android.graphics.drawable.Drawable;

public class Quiz {

    private final String name;
    private final String description;
    private final String author;
    private final int pictureResource;
    private final String categoryName;

    public Quiz(String name, String description, String author, int picture, String categoryName) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.pictureResource = picture;
        this.categoryName = categoryName;
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

    public int getPreviewPicture(){
        return pictureResource;
    }

    public String getCategoryName(){
        return categoryName;
    }
}
