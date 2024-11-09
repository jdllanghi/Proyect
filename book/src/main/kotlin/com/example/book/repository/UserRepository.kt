package com.example.book.repository

import com.example.book.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    // You can define custom queries here if needed
    fun findByEmail(email: String): User?
}
