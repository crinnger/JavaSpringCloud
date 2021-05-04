package br.com.crinnger.codeanywhere.cart.shoppingcart.repository;

import br.com.crinnger.codeanywhere.cart.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {
}
