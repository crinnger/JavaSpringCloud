package br.com.crinnger.codeanywhere.experts.productcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@Document(indexName = "product")
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer amount;
}
