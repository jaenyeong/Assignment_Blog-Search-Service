package com.jaenyeong.study_blogsearchservice.blogsearch.dto

data class BlogsDto(
    val meta: Meta,
    val documents: List<BlogDto>
) {
    companion object {
        fun of(blogs: KakaoBlogs): BlogsDto {
            return BlogsDto(
                meta = blogs.meta,
                documents = blogs.documents.map {
                    BlogDto.of(it)
                }
            )
        }
    }
}
