package com.reborn.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Reborn。 on 2017/5/28.
 */
public class Cart {
    private Map<String,CartItem> map = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                '}';
    }

    public double getTotal()
    {
        BigDecimal sum = new BigDecimal("0");
        for(CartItem cartItem:map.values())
        {
            BigDecimal sub = new BigDecimal(cartItem.getSubtotal()+"");
            sum = sum.add(sub);
        }
        return sum.doubleValue();
    }

    public void add(CartItem cartItem)
    {
        if(map.containsKey(cartItem.getBook().getBid()))
        {
            CartItem _cartItem = map.get(cartItem.getBook().getBid());
            cartItem.setQuantity(_cartItem.getQuantity()+cartItem.getQuantity());
            map.put(cartItem.getBook().getBid(),cartItem);
        }else
        {
            map.put(cartItem.getBook().getBid(),cartItem);
        }
    }

    public void delete(String bid)
    {
        map.remove(bid);
    }

    public void clear()
    {
        map.clear();
    }

    public Collection<CartItem> getCartItems()
    {
        return map.values();
    }
}
