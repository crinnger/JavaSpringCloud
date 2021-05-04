package br.com.crinnger.codeanywhere.experts.productcatalog.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class ProductNotFoundException extends Exception {
}
