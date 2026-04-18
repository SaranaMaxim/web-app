package com.example.college.model

import jakarta.persistence.*

@Entity
@Table(name = "students")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val surname: String,
    val age: Int,

    @ManyToMany
    @JoinTable(
        name = "student_hobbies",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "hobby_id")]
    )
    val hobbies: Set<Hobby> = emptySet()
)

@Entity
@Table(name = "hobbies")
class Hobby(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
)