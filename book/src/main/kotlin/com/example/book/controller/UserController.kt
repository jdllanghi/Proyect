package com.example.book.controller

import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    // Get all users
    @GetMapping
    fun getAllUsers(): SuccessResponse {
        val users = userService.getAllUsers()
        return SuccessResponse(data = users)
    }

    // Create a new user
    @PostMapping
    fun create(@RequestBody @Valid userDto: UserDto): Any {
        return try {
            val user = userService.save(userDto)
            SuccessResponse(data = user)
        } catch (e: Exception) {
            ErrorResponse(message = "Error creating user", code = 500)
        }
    }

    // Get a user by ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Any {
        return try {
            val user = userService.getUserById(id)
            SuccessResponse(data = user)
        } catch (e: Exception) {
            ErrorResponse(message = "Error fetching user", code = 500)
        }
    }

    // Update a user
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid userDto: UserDto): Any {
        return try {
            val user = userService.updateUser(id, userDto)
            SuccessResponse(data = user)
        } catch (e: Exception) {
            ErrorResponse(message = "Error updating user", code = 500)
        }
    }

    // Delete a user
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Any {
        return try {
            userService.deleteUser(id)
            SuccessResponse(data = "User deleted successfully")
        } catch (e: Exception) {
            ErrorResponse(message = "Error deleting user", code = 500)
        }
    }

    // Get reading progress for a user
    @GetMapping("/{id}/progress")
    fun getUserProgress(@PathVariable id: Long): Any {
        return try {
            val progress = userService.getReadingProgressByUserId(id)
            SuccessResponse(data = progress)
        } catch (e: Exception) {
            ErrorResponse(message = "Error fetching reading progress", code = 500)
        }
    }
}
