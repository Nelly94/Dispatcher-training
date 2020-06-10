package com.app.dao;

import com.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.description like %:description%")
    public List<Product> findByThisDescription(@Param("description") String description);

    public List<Product> findByPriceBetween(int price1, int price2);
}
