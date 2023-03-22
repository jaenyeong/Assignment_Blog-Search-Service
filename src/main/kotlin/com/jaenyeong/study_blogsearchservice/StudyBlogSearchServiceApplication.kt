package com.jaenyeong.study_blogsearchservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class StudyBlogSearchServiceApplication

fun main(args: Array<String>) {
    runApplication<StudyBlogSearchServiceApplication>(*args)
}
