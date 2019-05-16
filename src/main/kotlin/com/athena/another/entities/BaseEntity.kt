//package com.athena.another.entities
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties
//import org.springframework.data.annotation.CreatedDate
//import org.springframework.data.annotation.LastModifiedDate
//import org.springframework.data.jpa.domain.support.AuditingEntityListener
//import javax.persistence.*
//import java.io.Serializable
//import java.util.Date
//
//@EntityListeners(AuditingEntityListener::class)
//@JsonIgnoreProperties(value = ["createdAt", "updatedAt"], allowGetters = true)
//@MappedSuperclass
//abstract class BaseEntity(
//        @Temporal(TemporalType.TIMESTAMP)
//        @Column(name = "created_at", nullable = true, insertable = false, updatable = false)
//        @CreatedDate
//        private val createdAt: Date? = null,
//
//        @Temporal(TemporalType.TIMESTAMP)
//        @Column(name = "updated_at", nullable = true)
//        @LastModifiedDate
//        private val updatedAt: Date? = null
//) : Serializable