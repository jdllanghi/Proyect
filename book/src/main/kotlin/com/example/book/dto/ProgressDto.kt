package com.example.book.dto

import org.jetbrains.annotations.NotNull
import java.time.LocalDate

class ProgressDto {
    @NotNull(message = "User ID is required")
    var userId: Long? = null

    @NotNull(message = "Book Title is required")
    var bookTitle: String? = null

    @NotNull(message = "Progress Percentage is required")
    var progressPercentage: Int? = null

    @NotNull(message = "Start Date is required")
    var startDate: LocalDate? = null

    @NotNull(message = "End Date is required")
    var endDate: LocalDate? = null

    @NotNull(message = "Status is required")
    var status: String? = null
}
