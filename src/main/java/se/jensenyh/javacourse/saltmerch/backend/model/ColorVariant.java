package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorVariant
{
    // todo: needs fields: String colorName, List of String images, List of SizeContainer sizes
    
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 2 constructors:
    //  1. empty constructor: this one needs to initialize images and sizes as new ArrayList<>()
    //  2. constructor with colorName, sizes, and images
    @JsonProperty public String colorName;
    @JsonProperty public List<String> images;
    @JsonProperty public List<SizeContainer> sizes;

    public ColorVariant() {
    }

    public ColorVariant(String colorName, List<String> images, List<SizeContainer> sizes) {
        this.colorName = colorName;
        this.images = images;
        this.sizes = sizes;
    }

    // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }
}
