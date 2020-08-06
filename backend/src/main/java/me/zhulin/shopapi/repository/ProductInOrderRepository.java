package me.zhulin.shopapi.repository;

import me.zhulin.shopapi.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
