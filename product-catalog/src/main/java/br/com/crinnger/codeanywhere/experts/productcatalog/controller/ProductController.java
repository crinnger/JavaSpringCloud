package br.com.crinnger.codeanywhere.experts.productcatalog.controller;

import br.com.crinnger.codeanywhere.experts.productcatalog.exception.ProductNotFoundException;
import br.com.crinnger.codeanywhere.experts.productcatalog.model.Product;
import br.com.crinnger.codeanywhere.experts.productcatalog.repository.ProductRepository;
import br.com.crinnger.codeanywhere.experts.productcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){

        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping({"/{productId}"})
    public ResponseEntity<Product> getById(@PathVariable("productId") Long id) throws ProductNotFoundException{
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping({"/"})
    public ResponseEntity<List<Product>> findAll() throws ProductNotFoundException{
        return ResponseEntity.ok(productService.findAll());
    }
}
