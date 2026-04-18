package com.example.college.controller

import com.example.college.model.Student
import com.example.college.repository.StudentRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(val studentRepository: StudentRepository) {

    @GetMapping("/api/students")
    fun getStudents(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) hobby: String?
    ): List<Student> {
        return studentRepository.findByNameContainingIgnoreCaseAndHobbies_NameContainingIgnoreCase(
            name ?: "", hobby ?: ""
        )
    }

    @PostMapping("/post")
    fun addStudent(
        @RequestBody student: Student
    ): Int {
        return 1
    }

}