package com.athena.another.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDeleteAction
import org.hibernate.annotations.OnDelete
import javax.persistence.*


@Entity(name = "answers")
@Table(name = "answers")
class Answer(
        @Id
        @GeneratedValue(generator = "answer_generator")
        @SequenceGenerator(name = "answer_generator", sequenceName = "answer_sequence", initialValue = 1000)
        private val id: Long? = null,

        @Column(columnDefinition = "text")
        private val text: String? = null
) {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private val question: Question? = null
}