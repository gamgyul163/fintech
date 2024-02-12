package com.zerobase.api.information.product


import com.zerobase.api.information.InformationResponseCode.SUCCESS
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.type.Organization
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ProductInformationServiceImpl (
    private val productInfoRepository:ProductInfoRepository,
) : ProductInformationService {

    override fun getProductInfoList(organization: Organization): ProductInfoDto.GetProductResponseDto {
        val productInfoList: List<ProductInfo> = productInfoRepository.findByOrganization(organization)
        val productInfoDtoList = productInfoList.map {e ->
            ProductInfoDto.fromEntity(e)}.toList()
        return ProductInfoDto.GetProductResponseDto(productInfoDtoList)
    }

    override fun saveProductInfo(productInfoDto: ProductInfoDto): ProductInfoDto.AddProductResponseDto {
    productInfoRepository.save(productInfoDto.toEntity())
        return ProductInfoDto.AddProductResponseDto(SUCCESS.responseCode, SUCCESS.responseMessage)
    }

}