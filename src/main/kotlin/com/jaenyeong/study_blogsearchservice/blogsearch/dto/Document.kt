package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

private const val DATETIME_PATTERN: String = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"

data class Document(
    val title: String,
    val contents: String,
    val url: String,
    val blogname: String,
    val thumbnail: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_PATTERN)
    val datetime: LocalDateTime?
)
