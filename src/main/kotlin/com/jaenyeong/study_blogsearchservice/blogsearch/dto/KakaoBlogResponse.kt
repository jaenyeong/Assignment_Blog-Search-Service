package com.jaenyeong.study_blogsearchservice.blogsearch.dto

data class KakaoBlogResponse(
    val meta: Meta,
    val documents: List<Document>
)
