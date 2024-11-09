package com.example.book.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserDto {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name cannot be blank")
    var name: String? = null

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email cannot be blank")
    var email: String? = null

    @NotNull(message = "Registration Date is required")
    var registrationDate: LocalDate? = null

    @NotNull(message = "User Type is required")
    @NotBlank(message = "User Type cannot be blank")
    var userType: String? = null
}
