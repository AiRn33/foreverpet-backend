package com.hello.foreverpet.controller;

import com.hello.foreverpet.domain.dto.request.NewProductRequest;
import com.hello.foreverpet.domain.dto.request.UpdateProductRequest;
import com.hello.foreverpet.domain.dto.response.ProductResponse;
import com.hello.foreverpet.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Product API",description = "상품관리 API 입니다")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @Operation(summary = "상품 등록",description = "상품을 등록합니다.")
    @PostMapping("/products")
    public ResponseEntity<Long> createProduct(@RequestBody @Valid NewProductRequest newProductRequest) {
        Long productId = productService.createProduct(newProductRequest);

        return ResponseEntity.ok(productId);
    }

    // 모든 상품 조회
    @Operation(summary = "모든 상품 조회",description = "id 순으로 모든 상품을 조회합니다.")
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> allProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "id로 상품 조회",description = "id 값으로 특정 상품을 찾습니다.")
    @GetMapping("/products/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @Operation(summary = "상품 수정",description = "id 로 원하는 상품을 선택하고 수정합니다.")
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
        productService.updateProduct(id,updateProductRequest);
    }

    @Operation(summary = "상품 삭제",description = "id 로 상품을 삭제합니다.")
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @Operation(summary = "상품 검색", description = "검색어를 포함하는 결과 반환")
    @GetMapping("/products/search")
    public List<ProductResponse> searchProduct(@RequestParam String search) {
        return productService.searchProduct(search);
    }

}
