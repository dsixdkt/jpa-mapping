package com.decathlon.gifting.jpamapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartEntity> createCart() {
        for (long i = 10; i < 20; i++) {
            CartEntity cart = new CartEntity();
            cart.setName("Test_###_" + i);
            cartService.persist(cart);
        }
        return cartService.listAll();
    }

    @PutMapping
    public List<CartEntity> putCart() {
        for (long i = 10; i < 20; i++) {
            CartEntity cart = new CartEntity();
            cart.setId(i);
            cart.setName("Test_###_" + i);
            cartService.persist(cart);
        }
        return cartService.listAll();
    }

    @DeleteMapping
    public void emptyCart() {
        cartService.clear();
    }
}
