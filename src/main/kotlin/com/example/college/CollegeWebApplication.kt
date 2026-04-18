package com.example.college

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CollegeWebApplication

fun main(args: Array<String>) {
	runApplication<CollegeWebApplication>(*args)
}
