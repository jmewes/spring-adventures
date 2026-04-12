package com.experimental_software.spring_adventures.production;

import static org.springframework.http.HttpStatus.OK;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Product Inventory")
class ProductInventoryController {

  private final ProductInventoryRepository productInventoryRepository;

  @GetMapping(path = "/api/product-inventories")
  public ResponseEntity<PagedModel<ProductInventoryDTO>> getProductInventories(Pageable pageable) {

    Page<ProductInventory> page = productInventoryRepository.findAll(pageable);
    List<ProductInventoryDTO> content =
        page
            .map(
                i -> {
                  Product p = i.getProduct();
                  return new ProductInventoryDTO(
                      new ProductDTO(p.getProductId(), p.getName()),
                      new LocationDTO(i.getLocationId()),
                      i.getQuantity());
                })
            .stream()
            .toList();

    PagedModel.PageMetadata pageMetadata =
        new PagedModel.PageMetadata(page.getSize(), page.getNumber(), page.getTotalElements());

    return new ResponseEntity<>(PagedModel.of(content, pageMetadata), OK);
  }

  @GetMapping(path = "/api/product-inventories/top3")
  public ResponseEntity<List<ProductInventory>> getTop3ProductInventories(Pageable pageable) {
    List<ProductInventory> productInventories = productInventoryRepository.findTop3By(pageable);
    return ResponseEntity.ok(productInventories);
  }

  @DeleteMapping(path = "/api/product-inventories")
  public ResponseEntity<Void> deleteProductInventory(
      @RequestParam @NotNull Integer productId, @RequestParam @NotNull Integer locationId) {
    productInventoryRepository.deleteById(
        ProductInventory.ProductInventoryId.builder()
            .locationId(locationId)
            .product(Product.builder().productId(productId).build())
            .build());
    return ResponseEntity.ok().build();
  }
}
