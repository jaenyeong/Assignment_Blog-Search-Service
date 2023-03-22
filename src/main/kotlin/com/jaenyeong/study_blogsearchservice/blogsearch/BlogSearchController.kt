package com.jaenyeong.study_blogsearchservice.blogsearch

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.BlogsDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/blogs")
class BlogSearchController(
    private val blogSearchService: BlogSearchService
) {
    @GetMapping("/search")
    fun searchBlog(
        @RequestParam query: String,
        @RequestParam(required = false) sort: String?,
        @RequestParam(required = false) page: Int?,
        @RequestParam(required = false) size: Int?
    ): ResponseEntity<BlogsDto> {
        val response = blogSearchService.searchBlog(query = query, sort = sort, page = page, size = size)

        return ResponseEntity.ok(response)
    }
}
