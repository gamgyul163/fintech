package com.zerobase.domain.repository

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface ProductInfoRepository : JpaRepository<ProductInfo, Long> {
    fun findByOrganization(organization: Organization): List<ProductInfo>
}