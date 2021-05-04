package br.com.crinnger.codeanywhere.experts.javacodeanywhereproductcatalog.repository;

import br.com.crinnger.codeanywhere.experts.javacodeanywhereproductcatalog.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product,Long> {
}
