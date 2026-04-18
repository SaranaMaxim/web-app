package com.example.college.repository

import com.example.college.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findByNameContainingIgnoreCaseAndHobbies_NameContainingIgnoreCase(
        name: String?,
        hobbyName: String?
    ): List<Student>


}