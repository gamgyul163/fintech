package com.zerobase.api.information.user


class UserInfoDto {
    data class UserInfoInputDto(
        val userName: String,
        val userIncomeAmount: Long,
        val userRegistrationNumber: String
    )

    class UserResponseDto(
        val data: Map<String, String>,
        val responseCode: String,
        val responseMessage: String
    )
}