package br.com.crinnger.codeanywhere.experts.productcatalog.controller;

import br.com.crinnger.codeanywhere.experts.productcatalog.exception.ProductNotFoundException;
import br.com.crinnger.codeanywhere.experts.productcatalog.model.Product;
import br.com.crinnger.codeanywhere.experts.productcatalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping({"/{productId}"})
    public Product getById(@PathVariable("productId") Long id) throws ProductNotFoundException{
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
    }
}