package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findUserByProductnameLike(String productname);

    @Query("select p from Product p " +
            "where (p.productname like :productname or :productname is null) and " +
            "      (p.price >= :minPrice or :minPrice is null) and " +
            "      (p.price <= :maxPrice or :maxPrice is null)")
    List<Product> findWithFilter(@Param("productname") String usernameFilter,
                                 @Param("minPrice") BigDecimal minPrice,
                                 @Param("maxPrice") BigDecimal maxPrice);

}
