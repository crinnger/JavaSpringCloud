package br.com.crinnger.codeanywhere.cart.shoppingcart.controller;

import br.com.crinnger.codeanywhere.cart.shoppingcart.model.Cart;
import br.com.crinnger.codeanywhere.cart.shoppingcart.model.Item;
import br.com.crinnger.codeanywhere.cart.shoppingcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartRepository cartRepository;

    @PostMapping({"/{cartId}"})
    public Cart addItm(@PathVariable("cartId") Long id, @RequestBody Item item){
        Optional<Cart> cartSaved=cartRepository.findById(id);
        Cart cart;
        if(cartSaved.isEmpty()){
            cart=new Cart();
            cart.setId(id);
        } else {
            cart=cartSaved.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping({"/{cartId}"})
    public Optional<Cart> findById(@PathVariable("cartId") Long id){
        return cartRepository.findById(id);
    }
    @DeleteMapping({"/{cartId}"})
    public void clearCart(@PathVariable("cartId") Long id){
        cartRepository.deleteById(id);
    }
}
