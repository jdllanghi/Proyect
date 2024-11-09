package com.example.book.mapper

import com.example.book.dto.ProgressDto
import com.example.book.entity.Progress
import org.springframework.stereotype.Component

@Component
object ProgressMapper {

    // Convert ProgressDto to Progress entity
    fun toEntity(progressDto: ProgressDto): Progress {
        val progress = Progress()

        // Set the User reference using the userId from ProgressDto
        progress.user = User().apply { id = progressDto.userId }  // Only set the user ID

        progress.bookTitle = progressDto.bookTitle
        progress.progressPercentage = progressDto.progressPercentage
        progress.startDate = progressDto.startDate
        progress.endDate = progressDto.endDate
        progress.status = progressDto.status

        return progress
    }

    // Convert Progress entity to ProgressDto
    fun toDto(progress: Progress): ProgressDto {
        val progressDto = ProgressDto()

        // Get userId from the Progress entity's user reference
        progressDto.userId = progress.user?.id  // Extract userId from the user object
        progressDto.bookTitle = progress.bookTitle
        progressDto.progressPercentage = progress.progressPercentage
        progressDto.startDate = progress.startDate
        progressDto.endDate = progress.endDate
        progressDto.status = progress.status

        return progressDto
    }
}