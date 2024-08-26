    package com.tushenshop.repository;

    import com.tushenshop.model.Product;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;
    import org.springframework.data.repository.query.Param;
    import java.util.Optional;
    import java.util.List;

    @Repository
    public interface ProductRepository extends CrudRepository<Product, Integer> {

        // Optional method to find a Product by its ID
        Optional<Product> findById(long id);

        List<Product> findByCategoryId(@Param("categoryId") Integer categoryId);

        @Query("SELECT p FROM Product p WHERE (:search IS NULL OR p.productName LIKE %:search%) AND (:categoryId IS NULL OR p.category.id = :categoryId) ORDER BY " +
                "CASE WHEN :sort = 'PriceAsc' THEN p.price END ASC, " +
                "CASE WHEN :sort = 'PriceDesc' THEN p.price END DESC")
        List<Product> searchProducts(@Param("search") String search, @Param("categoryId") Integer categoryId, @Param("sort") String sort);

        @Query("SELECT p FROM Product p WHERE (:categoryId IS NULL OR p.category.id = :categoryId) ORDER BY " +
                "CASE WHEN :sort = 'PriceAsc' THEN p.price END ASC, " +
                "CASE WHEN :sort = 'PriceDesc' THEN p.price END DESC")
        List<Product> findByCategoryIdAndSort(@Param("categoryId") Integer categoryId, @Param("sort") String sort);

    }
