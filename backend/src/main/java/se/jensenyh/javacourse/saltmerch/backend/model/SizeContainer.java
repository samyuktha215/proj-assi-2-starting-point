package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SizeContainer
{
    // todo: needs fields: String size, int stock
    
    // todo: all fields should be public and annotated with @JsonProperty
    
    // todo: needs 2 constructors:
    //  1. empty constructor
    //  2. constructor with size and stock
    @JsonProperty public String size;
    @JsonProperty public int stock;

    public SizeContainer() {
    }

    public SizeContainer(String size, int stock) {
        this.size = size;
        this.stock = stock;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
