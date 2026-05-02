package com.experimental_software.spring_adventures.production;

import com.experimental_software.spring_adventures.production.entities.ProductInventory;
import com.experimental_software.spring_adventures.production.entities.ProductInventory.ProductInventoryId;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
interface ProductInventoryRepository extends JpaRepository<ProductInventory, ProductInventoryId> {

  @EntityGraph(value = "ProductInventory.product")
  List<ProductInventory> findTop3By(Pageable pageable);
}
