package se.jensenyh.javacourse.saltmerch.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.ColorVariant;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3010")
public class ProductController
{
@Autowired
    ProductService productService;
/*@GetMapping("/products")
public  ResponseEntity<List<Product>> getProducts(){
    List<Product>productList =productService.getProducts();
    return ResponseEntity.ok(productList);
}*/
@GetMapping("/{var}")
public Object getCategories(@PathVariable("var") String var){
    switch (var){
        case "hats":
        case "jackets":
        case "tshirts":
        case "bags":
            return productService.getProductsOfCategory(var);
        default:
            try{
                int i= Integer.parseInt(var);
                return  productService.getEntireProduct(i);
            }catch(Exception e){
                System.out.println("given string instead of integer");
                return ResponseEntity.badRequest().body("your id is string so please give integer");
            }

    }
}

@PostMapping("/{var}")
public Object addingProducts(@PathVariable("var") String var,@RequestBody Product product){
    switch(var){
        case "hats":
        case "jackets":
        case "tshirts":
        case "bags":
            return productService.addProductAndProps(product,var);
        default:
            try{
                int i= Integer.parseInt(var);
                return  productService.getEntireProduct(i);
            }catch(Exception e){
                System.out.println("given string instead of integer");
                return ResponseEntity.badRequest().body("your id is string so please give integer");
            }


    }

}

@DeleteMapping("/{id}")
public ResponseEntity<Integer> deleteProduct(@PathVariable("id") Integer id)
    {
        if (productService.deleteProduct(id) >= 0)
            return ResponseEntity.ok().build();
        return ResponseEntity.internalServerError().build();
    }
@PutMapping("/{id}")
public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
    int res = productService.updateProduct(id, product);
    switch (res) {
        case 0:
            return ResponseEntity.badRequest().body("No product with that product id is present");
        case 1:
            return ResponseEntity.internalServerError().body("Server error, probably");
        default:
            return ResponseEntity.status(200).body("The product is updated");
    }
}
@PutMapping("/{id}/variants/stock")
public ResponseEntity<Integer> restockSize(HttpServletRequest request){
     String size=request.getParameter("size");
     String color=request.getParameter("color");
     Integer quantity=request.getContentLength();
   return new ResponseEntity<>(HttpStatus.OK);
}
@PostMapping("/{id}/variants")
public ResponseEntity<ColorVariant> addVariant(HttpServletRequest req,@RequestBody ColorVariant reqBody) {
    return new ResponseEntity<>(reqBody,HttpStatus.valueOf(201));
}
@DeleteMapping("/{productId}/variants")
public ResponseEntity<Integer> deleteVariant(HttpServletRequest request){
    String color=request.getParameter("color");
    return new ResponseEntity<>(HttpStatus.OK);
}
}





