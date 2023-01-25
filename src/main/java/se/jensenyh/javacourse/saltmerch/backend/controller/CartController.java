package se.jensenyh.javacourse.saltmerch.backend.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3010")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/carts/{id}")
    public ResponseEntity<List<CartItem>> getAllCartItems(@PathVariable("id") Integer id) {
        List<CartItem> cartItems = cartService.getALLItems();
        return ResponseEntity.ok(cartItems);
    }

    @PatchMapping("/carts/{id}")
    public Object addOrRemoveItem(@RequestParam("action") String action,
                                  @RequestBody CartItem item) {

        if ("add".equals(action)) {
            return cartService.addItem(item);
        } else if ("remove".equals(action)) {
            return cartService.removeItem(item);
        }
        return null;
    }

    @DeleteMapping("/carts/{id}")
    public Object deleteCartItems(@RequestParam("buyout") @Nullable String buyout) {
        if ("true".equals(buyout)) {
            cartService.deleteAllItems(false);
        } else cartService.deleteAllItems(true);
        return null;
    }

}
