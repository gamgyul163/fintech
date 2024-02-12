package com.zerobase.domain.converter

import com.zerobase.domain.type.Organization
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class OrganizationCodeConverter : AttributeConverter<Organization, String> {
    override fun convertToDatabaseColumn(attribute: Organization?): String? {
        return attribute?.code
    }

    override fun convertToEntityAttribute(dbData: String): Organization {
        return Organization.valueOf(dbData)
    }

}