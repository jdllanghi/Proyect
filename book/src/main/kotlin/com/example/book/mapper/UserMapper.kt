package com.example.book.mapper

import com.example.book.dto.UserDto
import com.example.book.entity.User
import org.springframework.stereotype.Component

@Component
object UserMapper {

    // Convert UserDto to User entity
    fun toEntity(userDto: UserDto): User {
        val user = User()
        user.name = userDto.name
        user.email = userDto.email
        user.registrationDate = userDto.registrationDate
        user.userType = userDto.userType
        return user
    }

    // Convert User entity to UserDto
    fun toDto(user: User): UserDto {
        val userDto = UserDto()
        userDto.name = user.name
        userDto.email = user.email
        userDto.registrationDate = user.registrationDate
        userDto.userType = user.userType
        return userDto
    }
}