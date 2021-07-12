package br.com.crinnger.codeanywhere.experts.productcatalog;

import br.com.crinnger.codeanywhere.experts.productcatalog.controller.ProductController;
import br.com.crinnger.codeanywhere.experts.productcatalog.model.Product;
import br.com.crinnger.codeanywhere.experts.productcatalog.repository.ProductRepository;
import br.com.crinnger.codeanywhere.experts.productcatalog.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ProductController.class)
@OverrideAutoConfiguration(enabled=true)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @TestConfiguration
    static class ServiceImplTestContextConfiguration {
        @Bean
        public ProductService usuarioService() {
            return new ProductService();
        }
    }

    @Autowired
    ProductService service;

    @MockBean
    ProductRepository productRepository;

    private final String host = "/product";

    private Product productExpect = new Product(1L,"teste",1);

    @Test
    public void testGetById() throws Exception{
        given(productRepository.findById(any())).willReturn(Optional.of(productExpect));
        String json=this.objectMapper.writeValueAsString(productExpect);
        this.mockMvc.perform(MockMvcRequestBuilders.get(host.concat("/{product}"), "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

    @Test
    public void testFindAll() throws Exception{
        given(productRepository.findAll()).willReturn(Collections.singletonList(productExpect));
        String json=this.objectMapper.writeValueAsString(Collections.singletonList(productExpect));
        this.mockMvc.perform(MockMvcRequestBuilders.get(host.concat("/"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

    @Test
    public void testCreate() throws Exception {

        given(productRepository.save(any(Product.class))).willReturn(productExpect);

        String json=this.objectMapper.writeValueAsString(productExpect);

        this.mockMvc.perform(MockMvcRequestBuilders.post(host)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }
}
