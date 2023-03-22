package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class NaverItem(
    val title: String?,
    val link: String?,
    val description: String?,
    @JsonProperty("bloggername")
    val bloggerName: String?,
    @JsonProperty("bloggerlink")
    val bloggerLink: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    val postdate: LocalDate?
)
