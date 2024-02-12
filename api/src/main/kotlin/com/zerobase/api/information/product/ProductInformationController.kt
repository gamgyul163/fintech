package com.zerobase.api.information.product

import com.zerobase.domain.type.Organization
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/v1/product")
@Api(description = "상품 정보 API")
class ProductInformationController (
    private val productInformationService: ProductInformationService
){
    @GetMapping("/{organization}")
    @ApiOperation(value = "상품 정보 조회 API", notes = "상품 정보를 조회하는 API")
    fun getProductsInformation(
        @PathVariable organization: Organization
    ): ResponseEntity<ProductInfoDto.GetProductResponseDto> {
        return ResponseEntity.ok(productInformationService.getProductInfoList(organization))
    }

    @PostMapping("/information")
    @ApiOperation(value = "상품 정보 수신 API", notes = "금융사로부터 상품 정보를 받는 API")
    fun addProductInformation(
        @RequestBody productInfoDto: ProductInfoDto
    ): ResponseEntity<ProductInfoDto.AddProductResponseDto> {
        return ResponseEntity.ok(productInformationService.saveProductInfo(productInfoDto))
    }

}