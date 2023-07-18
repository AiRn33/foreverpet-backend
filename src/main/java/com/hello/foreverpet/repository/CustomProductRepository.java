package com.hello.foreverpet.repository;

import com.hello.foreverpet.domain.entity.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomProductRepository {
    List<Product> findProductBySearch(String search);
}
