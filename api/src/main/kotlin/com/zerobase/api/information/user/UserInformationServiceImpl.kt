package com.zerobase.api.information.user

import com.zerobase.api.encrypt.EncryptComponent
import com.zerobase.api.information.InformationResponseCode.SUCCESS
import com.zerobase.api.information.user.UserInfoDto.UserResponseDto
import com.zerobase.api.loan.GenerateKey
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInformationServiceImpl(
    private val userInfoRepository: UserInfoRepository,
    private val generateKey: GenerateKey,
    private val encryptComponent: EncryptComponent,

    ) : UserInformationService {
    override fun saveUserInfo(userInfoInputDto: UserInfoDto.UserInfoInputDto): UserResponseDto {
        val userKey = generateKey.generateUserKey()
        userInfoRepository.save(
            UserInfo(
                encryptComponent.encryptString(userKey),
                encryptComponent.encryptString(userInfoInputDto.userRegistrationNumber),
                userInfoInputDto.userName,
                userInfoInputDto.userIncomeAmount
            )
        )
        var data: LinkedHashMap<String, String> = LinkedHashMap()
        data.put("userKey:", userKey);
        return UserResponseDto(data, SUCCESS.responseCode, SUCCESS.responseMessage)
    }

    override fun getUserInfo(userKey: String): UserResponseDto {
        val encryptedUserKey = encryptComponent.encryptString(userKey)
        val userInfo:UserInfo = userInfoRepository.findByUserKey(encryptedUserKey)
        val decryptedUserRegistrationNumber = encryptComponent.decryptString(userInfo.userRegistrationNumber)
        var data: LinkedHashMap<String, String> = LinkedHashMap()
        data.put("userKey:", userKey);
        data.put("userRegistrationNumber:", decryptedUserRegistrationNumber);
        return UserResponseDto(data,SUCCESS.responseCode, SUCCESS.responseMessage)
    }

}