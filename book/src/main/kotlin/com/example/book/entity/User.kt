package com.example.book.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user")  // Table name as "user"
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null  // Auto-generated ID

    @Column(name = "name")
    var name: String? = null  // User's name

    @Column(name = "email", unique = true)
    var email: String? = null  // User's email (unique)

    @Column(name = "registration_date", nullable = false, updatable = false)
    var registrationDate: LocalDateTime? = null  // Registration timestamp

    @Column(name = "user_type", nullable = false)
    var userType: String? = null  // User type, e.g., 'free', 'premium'

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    val progressList: List<Progress> = listOf()  // One-to-many relationship with Progress
}

class Progress {

    val userId: Long?
}
