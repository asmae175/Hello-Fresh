package me.ensah.shopapi.repository;

import me.ensah.shopapi.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
