package com.athena.another.controllers

import com.athena.another.entities.Question
import com.athena.another.repositories.QuestionRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*
import javax.validation.Valid;

@RestController
class QuestionController(
        private val questionRepository: QuestionRepository
) {

    @GetMapping(path = ["/questions"])
    fun getQuestions(pageable: Pageable): Page<Question> {
        return questionRepository.findAll(pageable);
    }


    @PostMapping(path = ["/questions"])
    fun createQuestion(@Valid @RequestBody question: Question): Question {
        return questionRepository.save(question);
    }

//    @PutMapping("/questions/{questionId}")
//    fun updateQuestion(@PathVariable questionId: Long, @Valid @RequestBody questionRequest: Question): Question {
//        val retrievedQuestion = questionRepository.findById(questionId)
//        return
//               retrievedQuestion.map { question ->
//                    question
//                    {
//                        question.setTitle(questionRequest.getTitle());
//                        question.setDescription(questionRequest.getDescription());
//                        return questionRepository.save(question);
//                    }
//                }
//    }


    @DeleteMapping(path = ["/questions/{questionId}"])
    fun deleteQuestion(@PathVariable questionId: Long): Optional<ResponseEntity<String>>? {
        return questionRepository.findById(questionId)
                .map { questionRepository.delete(it) }.map { ResponseEntity.ok().body("Deleted question successfully") }
    }
}