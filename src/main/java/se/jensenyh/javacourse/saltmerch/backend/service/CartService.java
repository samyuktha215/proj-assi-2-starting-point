package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService
{
    @Autowired
    CartRepository db;
    public List<CartItem> getALLItems(){
        return db.selectAllItems();
    }
    public Integer addItem(CartItem item){
        return db.insertOrIncrementItem(item);
    }
    public Integer removeItem(CartItem item){
        return db.deleteOrDecrementItem(item);
    }
    public void deleteAllItems(boolean restock){
        db.deleteAllItems(restock);
    }

}
