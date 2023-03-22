package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class BlogDto(
    val title: String,
    val contents: String,
    val url: String,
    val blogname: String,
    val thumbnail: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
    val datetime: LocalDateTime?
) {
    companion object {
        fun of(document: KakaoDocument): BlogDto {
            return BlogDto(
                title = document.title,
                contents = document.contents,
                url = document.url,
                blogname = document.blogname,
                thumbnail = document.thumbnail,
                datetime = document.datetime
            )
        }
    }
}
