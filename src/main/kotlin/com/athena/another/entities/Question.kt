package com.athena.another.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Entity
@Table(name = "questions")
class Question(
        @Id
        @GeneratedValue(generator = "question_generator")
        @SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
        private val id: Long? = null,

        @NotBlank
        @Size(min = 3, max = 100)
        private val title: String? = null,

        @Column(columnDefinition = "text")
        private val description: String? = null
)