package com.zerobase.domain.domain

import com.zerobase.domain.converter.OrganizationCodeConverter
import com.zerobase.domain.converter.ProductCodeConverter
import com.zerobase.domain.type.Organization
import com.zerobase.domain.type.Product
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_INFO")
class ProductInfo(
    @Convert(converter = OrganizationCodeConverter::class)
    @Column(name = "org_cd")
    val organization: Organization,

    @Convert(converter = ProductCodeConverter::class)
    @Column(name = "prd_cd")
    val product: Product,

    @Column(name = "prd_nm")
    val productName: String,

    @Column(name = "prod_min_intr")
    val productMinInterest: Double,

    @Column(name = "prod_max_intr")
    val productMaxInterest: Double
)  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}