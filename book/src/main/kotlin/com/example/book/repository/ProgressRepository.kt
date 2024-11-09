package com.example.book.repository

import com.example.book.entity.Progress
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProgressRepository : JpaRepository<Progress, Long> {
    // You can define custom queries here if needed
    fun findByUserId(userId: Long): List<Progress>  // Get all progress records for a specific user
    fun findByStatus(status: String): List<Progress>  // Find progress by status (e.g., 'completed', 'in_progress')
}
