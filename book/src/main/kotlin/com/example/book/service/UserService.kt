package com.example.book.service

import com.example.book.dto.UserDto
import com.example.book.mapper.UserMapper
import com.example.book.repository.ProgressRepository
import com.example.book.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var progressRepository: ProgressRepository

    @Autowired
    lateinit var userMapper: UserMapper

    // Get all users
    fun getAllUsers(): List<UserDto> {
        val users = userRepository.findAll()
        return users.map { userMapper.toDto(it) }  // Mapping entity to DTO
    }

    // Create a new user
    fun save(userDto: UserDto): UserDto {
        val user = userMapper.toEntity(userDto)  // Mapping DTO to entity
        val savedUser = userRepository.save(user)
        return userMapper.toDto(savedUser)  // Mapping back to DTO
    }

    // Get a user by ID
    fun getUserById(id: Long): UserDto {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
        return userMapper.toDto(user)  // Mapping entity to DTO
    }

    // Update a user completely
    fun updateUser(id: Long, userDto: UserDto): UserDto {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
        user.name = userDto.name
        user.email = userDto.email
        user.registrationDate = userDto.registrationDate
        user.userType = userDto.userType
        val updatedUser = userRepository.save(user)
        return userMapper.toDto(updatedUser)
    }

    // Update a user partially (only the name in this case)
    fun updateUserName(id: Long, userDto: UserDto): UserDto {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
        user.name = userDto.name  // Only update the name
        val updatedUser = userRepository.save(user)
        return userMapper.toDto(updatedUser)
    }

    // Delete a user
    fun deleteUser(id: Long) {
        val user = userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("User not found with id $id") }
        userRepository.delete(user)
    }

    // Get all reading progress for a specific user
    fun getReadingProgressByUserId(userId: Long): List<ProgressDto> {
        val progressList = progressRepository.findByUserId(userId)
        return progressList.map { progressMapper.toDto(it) }  // Map each Progress entity to DTO
    }
}
