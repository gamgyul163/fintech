package com.zerobase.api.information.user

import org.springframework.http.ResponseEntity

interface UserInformationService {
    fun saveUserInfo(userInfoInputDto: UserInfoDto.UserInfoInputDto): UserInfoDto.UserResponseDto

    fun getUserInfo(userKey: String): UserInfoDto.UserResponseDto
}