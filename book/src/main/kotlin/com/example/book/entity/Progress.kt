package com.example.book.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "progress")
data class Progress(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null,  // Reference to the User entity

    var bookTitle: String? = null,
    var progressPercentage: Int? = null,
    var startDate: LocalDate? = null,
    var endDate: LocalDate? = null,
    var status: String? = null
)
