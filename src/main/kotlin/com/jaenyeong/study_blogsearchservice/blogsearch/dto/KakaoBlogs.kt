package com.jaenyeong.study_blogsearchservice.blogsearch.dto

data class KakaoBlogs(
    val meta: Meta,
    val documents: List<KakaoDocument>
)
