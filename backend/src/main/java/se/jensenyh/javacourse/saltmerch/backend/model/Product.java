package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable
{
    // todo: needs fields: int id, String category, String title, String description, String previewImage, and List of ColorVariant colorVariants
    
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 3 constructors:
    //  1. empty constructor: this one only initializes colorVariants to new ArrayList<>()
    //  2. constructor with id, category, title, description, and previewImage: this one initializes colorVariants to new ArrayList<>()
    //  3. constructor with id, category, title, description, colorVariants
    @JsonProperty public int id;
    @JsonProperty public String category;
    @JsonProperty public String title;
    @JsonProperty public String description;
    @JsonProperty public String previewImage;
    @JsonProperty public List<ColorVariant> colorVariants;

    public Product() {
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String category, String title, String description, String previewImage) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.previewImage = previewImage;
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String category, String title, String description, List<ColorVariant> colorVariants) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.colorVariants = colorVariants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public List<ColorVariant> getColorVariants() {
        return colorVariants;
    }

    public void setColorVariants(List<ColorVariant> colorVariants) {
        this.colorVariants = colorVariants;
    }
}
