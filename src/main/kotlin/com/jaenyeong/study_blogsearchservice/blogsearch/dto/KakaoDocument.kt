package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class KakaoDocument(
    val title: String,
    val contents: String,
    val url: String,
    val blogname: String,
    val thumbnail: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    val datetime: LocalDateTime?
)
