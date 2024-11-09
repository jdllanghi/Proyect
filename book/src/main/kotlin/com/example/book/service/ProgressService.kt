package com.example.book.service

import com.example.book.dto.ProgressDto
import com.example.book.mapper.ProgressMapper
import com.example.book.repository.ProgressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProgressService {

    @Autowired
    lateinit var progressRepository: ProgressRepository

    @Autowired
    lateinit var progressMapper: ProgressMapper

    // Get all progress records
    fun getAllProgress(): List<ProgressDto> {
        val progressList = progressRepository.findAll()
        return progressList.map { progressMapper.toDto(it) }
    }

    // Get progress by status
    fun getProgressByStatus(status: String): List<ProgressDto> {
        val progressList = progressRepository.findByStatus(status)
        return progressList.map { progressMapper.toDto(it) }
    }
}
