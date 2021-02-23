package ru.geekbrains.service;

import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductRepr> findAll();

    Page<ProductRepr> findWithFilter(String productnameFilter, BigDecimal minPrice, BigDecimal maxPrice,
                                     Integer page, Integer size, String sortField);

    Optional<ProductRepr> findById(long id);

    void save(ProductRepr productRepr);

    void delete(long id);
}
