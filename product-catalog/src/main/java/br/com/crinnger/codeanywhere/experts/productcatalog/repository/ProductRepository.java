package br.com.crinnger.codeanywhere.experts.productcatalog.repository;

import br.com.crinnger.codeanywhere.experts.productcatalog.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product,Long> {
}
