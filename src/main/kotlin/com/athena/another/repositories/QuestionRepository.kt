package com.athena.another.repositories

import com.athena.another.entities.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface QuestionRepository : JpaRepository<Question, Long>