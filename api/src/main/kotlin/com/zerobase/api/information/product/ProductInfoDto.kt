package com.zerobase.api.information.product

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.Organization
import com.zerobase.domain.type.Product

class ProductInfoDto(
    val organizationCode: String,
    val productCode: String,
    val productMaximumInterest: Double,
    val productMinimumInterest: Double,
    val productName: String
) {
    companion object {
        fun fromEntity(productInfo: ProductInfo) =
            ProductInfoDto(
                productInfo.organization.code,
                productInfo.product.code,
                productInfo.productMaxInterest,
                productInfo.productMinInterest,
                productInfo.productName
            )
    }

    fun toEntity(): ProductInfo {
        return ProductInfo(
            Organization.valueOf(organizationCode),
            Product.valueOf(productCode),
            productName,
            productMaximumInterest,
            productMinimumInterest
        )
    }

    data class AddProductResponseDto(
        val responseCode: String,
        val responseMessage: String
    )

    data class GetProductResponseDto(
        val data: List<ProductInfoDto>
    )
}