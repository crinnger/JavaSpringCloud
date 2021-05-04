package br.com.crinnger.codeanywhere.cart.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long productId;
    private Integer amount;
}
