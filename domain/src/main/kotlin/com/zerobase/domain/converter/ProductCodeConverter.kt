package com.zerobase.domain.converter

import com.zerobase.domain.type.Product
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class ProductCodeConverter : AttributeConverter<Product, String> {
    override fun convertToDatabaseColumn(attribute: Product?): String? {
        return attribute?.code
    }


    override fun convertToEntityAttribute(dbData: String): Product {
        return Product.valueOf(dbData)
    }
}