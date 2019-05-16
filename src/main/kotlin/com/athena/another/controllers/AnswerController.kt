package com.athena.another.controllers

import com.athena.another.entities.Answer
import com.athena.another.repositories.AnswerRepository
import com.athena.another.repositories.QuestionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class AnswerController(
        private val answerRepository: AnswerRepository,
        private val questionRepository: QuestionRepository
) {

    @GetMapping(path = ["/questions/{questionId}/answers"])
    fun getAnswersByQuestionId(@PathVariable questionId: Long): List<Answer> {
        return answerRepository.findByQuestionId(questionId);
    }

//    @PostMapping(path = ["/questions/{questionId}/answers"])
//    fun addAnswer(@PathVariable questionId: Long, @Valid @RequestBody answer: Answer): Answer {
//        return questionRepository.findById(questionId)
//                .map { answer.setQuestion(it) }.map { answerRepository.save(answer) }
//    }

//    @PutMapping(path = ["/questions/{questionId}/answers/{answerId}"])
//    fun updateAnswer(@PathVariable questionId: Long,
//                     @PathVariable answerId: Long,
//                     @Valid @RequestBody answerRequest: Answer
//    ): Answer {
//        if (!questionRepository.existsById(questionId)) {
//            return Answer(text = "Question not found with id " + questionId)
//        }
//
//        return answerRepository.findById(answerId)
//                .map { answer ->
//                    {
//                        answer.setText(answerRequest.getText());
//                        return answerRepository.save(answer);
//                    }
//                }
//    }

    @DeleteMapping(path = ["/questions/{questionId}/answers/{answerId}"])
    fun deleteAnswer(@PathVariable questionId: Long,
                     @PathVariable answerId: Long): ResponseEntity<String> {
        if (!questionRepository.existsById(questionId)) {
            return ResponseEntity("Question not found with id " + questionId, HttpStatus.NOT_FOUND)
        }

        answerRepository.findById(answerId).ifPresent { answerRepository.delete(it) }
        return ResponseEntity("Answer deleted ", HttpStatus.OK)
    }

}