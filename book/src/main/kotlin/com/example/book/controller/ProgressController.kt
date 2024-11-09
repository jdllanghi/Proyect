package com.example.book.controller

import com.example.book.dto.ProgressDto
import com.example.book.response.ErrorResponse
import com.example.book.response.SuccessResponse
import com.example.book.service.ProgressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/progress")
class ProgressController {

    @Autowired
    lateinit var progressService: ProgressService

    // Get all progress entries
    @GetMapping
    fun getAllProgress(): SuccessResponse {
        val progressList = progressService.getAllProgress()
        return SuccessResponse(data = progressList)
    }

    // Get progress for a specific user
    @GetMapping("/user/{userId}")
    fun getUserProgress(@PathVariable userId: Long): Any {
        return try {
            val progress = progressService.getProgressByUserId(userId)
            SuccessResponse(data = progress)
        } catch (e: Exception) {
            // Returning a 500 error response if something goes wrong
            ErrorResponse(message = "Error fetching progress for user", code = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }

    // Create a new progress record
    @PostMapping
    fun create(@RequestBody @Valid progressDto: ProgressDto): Any {
        return try {
            val progress = progressService.save(progressDto)
            SuccessResponse(data = progress)
        } catch (e: Exception) {
            // Returning a 500 error response if something goes wrong
            ErrorResponse(message = "Error creating progress", code = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }

    // Update progress for a specific user
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid progressDto: ProgressDto): Any {
        return try {
            val progress = progressService.updateProgress(id, progressDto)
            SuccessResponse(data = progress)
        } catch (e: Exception) {
            // Returning a 500 error response if something goes wrong
            ErrorResponse(message = "Error updating progress", code = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }

    // Delete a progress record
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Any {
        return try {
            progressService.deleteProgress(id)
            SuccessResponse(data = "Progress deleted successfully")
        } catch (e: Exception) {
            // Returning a 500 error response if something goes wrong
            ErrorResponse(message = "Error deleting progress", code = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }
}
