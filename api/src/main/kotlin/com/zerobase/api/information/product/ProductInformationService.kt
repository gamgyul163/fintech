package com.zerobase.api.information.product

import com.zerobase.domain.type.Organization

interface ProductInformationService {

    fun getProductInfoList(organization: Organization): ProductInfoDto.GetProductResponseDto
    fun saveProductInfo(productInfoDto: ProductInfoDto): ProductInfoDto.AddProductResponseDto
}