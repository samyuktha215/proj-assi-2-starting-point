package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.ColorVariant;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.model.SizeContainer;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository db;

    public List<Product> getProducts(){
        return db.selectAll();
    }
    public List<Product> getProducts(String category){
        return db.selectAll(category);
    }
    public List<Product> getProductsOfCategory(String category){
       return db.selectAllOfCategory(category);
    }
    public Product addProductAndProps(Product prod, String category){
        return db.insertProductAndProps(prod,category);
    }
    public int updateProduct(int id,Product prod){
        return db.updateProductMeta(id, prod);
    }
    public int deleteProduct(int id){
        if(id>0)
        { return db.deleteProduct(id);
        }
        return -2;
    }
    public Product getEntireProduct(int productId){
        return db.getEntireProduct(productId);
    }
    public List<SizeContainer> getVariantSizes(int variantId){
        return db.getVariantSizes(variantId);
    }
    public ColorVariant addVariant(int productId, ColorVariant colorVariant){return db.addVariant(productId,colorVariant);
    }
    public int deleteVariant(int productId, String color){
        return db.deleteVariant(productId,color);
    }
    public int restockSize(int productId,String size,String color,int qty){return db.restockSize(productId,size,color,qty);
    }

}
