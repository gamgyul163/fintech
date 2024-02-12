package com.zerobase.api.information.user

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/user")
@Api(description = "유저 정보 API")
class UserInformationController (
  private val userInformationService: UserInformationService
){

    @PostMapping("/information")
    @ApiOperation(value = "유저 정보 수신 API", notes = "유저 정보를 받는 API")
    fun addUserInformation(
        @RequestBody userInfoInputDto: UserInfoDto.UserInfoInputDto
    ) : ResponseEntity<UserInfoDto.UserResponseDto> {
        return ResponseEntity.ok(userInformationService.saveUserInfo(userInfoInputDto))
    }

    @GetMapping("/private-info/{userKey}")
    @ApiOperation(value = "유저 정보 조희 API", notes = "유저 정보를 조회하는 API")
    fun getUserInformation(
        @PathVariable userKey:String
    ) : ResponseEntity<UserInfoDto.UserResponseDto> {
        return ResponseEntity.ok(userInformationService.getUserInfo(userKey))
    }
}