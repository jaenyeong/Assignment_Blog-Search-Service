package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

data class NaverBlogs(
    @DateTimeFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z")
    val lastBuildDate: Date?,
    val total: Int?,
    val start: Int?,
    val display: Int?,
    @JsonProperty("items")
    val items: List<NaverItem>?,
)
