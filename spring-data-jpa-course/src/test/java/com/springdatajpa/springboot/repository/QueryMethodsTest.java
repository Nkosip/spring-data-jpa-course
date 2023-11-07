package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product);
    }
    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product);
    }
    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = productRepository.findByNameOrDescription("product 2","product 2 description");
        products.forEach(System.out::println);

    }
    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product 2","product 2 description");
        products.forEach(System.out::println);
    }
    @Test
    void findDistinctByNameMethod() {

        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product);

    }
    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> product = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        product.forEach((p) -> {
            System.out.println(p);
        });

    }
    @Test
    void findByPriceLessThanMethod() {

        List<Product> product = productRepository.findByPriceLessThan(new BigDecimal(200));
        product.forEach((p) -> {
            System.out.println(p);
        });

    }
    @Test
    void findByNameContainingMethod() {

        List<Product> products = productRepository.findByNameContaining("product 1");
        products.forEach((p) -> {
            System.out.println(p);
        });

    }
    @Test
    void findByNameLikeMethod() {

        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach((p) -> {
            System.out.println(p);
        });

    }
    @Test
    void findByPriceBetweenMethod() {

        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        products.forEach((p) -> {
            System.out.println(p);
        });

    }
    @Test
    void findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.of(2023,9,16,16,8,0);
        LocalDateTime endDate = LocalDateTime.of(2023,9,16,16,58,20);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate,endDate);
        products.forEach((p) -> {
            System.out.println(p);
        });

    }
//    @Test
//    void findByNameInMethod() {
//
//        List<Product> products = productRepository.findbyNameIn(List.of("product 1","product 1","product 3"));
//        products.forEach((p) -> {
//            System.out.println(p);
//        });
//    }

}
