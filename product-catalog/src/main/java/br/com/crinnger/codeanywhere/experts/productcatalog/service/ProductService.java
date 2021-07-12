package br.com.crinnger.codeanywhere.experts.productcatalog.service;

import br.com.crinnger.codeanywhere.experts.productcatalog.exception.ProductNotFoundException;
import br.com.crinnger.codeanywhere.experts.productcatalog.model.Product;
import br.com.crinnger.codeanywhere.experts.productcatalog.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@NoArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException());
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        productRepository.findAll();
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
