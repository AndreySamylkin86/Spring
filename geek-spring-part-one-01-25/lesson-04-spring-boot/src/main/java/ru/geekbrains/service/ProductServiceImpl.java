package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.ProductSpecification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductRepr> findAll() {
        return productRepository.findAll().stream()
                .map(ProductRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductRepr> findWithFilter(String productnameFilter, BigDecimal minPrice, BigDecimal maxPrice,
                                            Integer page, Integer size, String sortField) {
        Specification<Product> spec = Specification.where(null);
        if (productnameFilter != null && !productnameFilter.isBlank()) {
            spec = spec.and(ProductSpecification.productnameLike(productnameFilter));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.minPrice(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.maxPrice(maxPrice));
        }
        if (sortField != null && !sortField.isBlank()) {
            return productRepository.findAll(spec, PageRequest.of(page, size, Sort.by(sortField)))
                    .map(ProductRepr::new);
        }
        return productRepository.findAll(spec, PageRequest.of(page, size))
                .map(ProductRepr::new);
    }

    @Transactional
    @Override
    public Optional<ProductRepr> findById(long id) {
       return productRepository.findById(id)
                .map(ProductRepr::new);
    }

    @Transactional
    @Override
    public void save(ProductRepr productRepr) {
        Product productToSave = new Product(productRepr);
        productRepository.save(productToSave);
        if (productRepr.getId() == null) {
            productRepr.setId(productToSave.getId());
        }
    }

    @Transactional
    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
