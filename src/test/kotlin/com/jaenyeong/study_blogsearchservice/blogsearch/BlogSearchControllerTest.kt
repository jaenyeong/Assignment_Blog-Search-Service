package com.jaenyeong.study_blogsearchservice.blogsearch

import com.fasterxml.jackson.databind.ObjectMapper
import com.jaenyeong.study_blogsearchservice.blogsearch.searchengine.KakaoBlogSearchEngine
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@DisplayName("블로그 검색 서비스에 Controller 레이어 테스트")
class BlogSearchControllerTest {
    private val mockKakaoSearchEngine: KakaoBlogSearchEngine = mockk()
    private val mockBlogSearchService: BlogSearchService = BlogSearchService(mockKakaoSearchEngine)
    private val objectMapper: ObjectMapper = mockk()
    private val mockBlogSearchController: BlogSearchController = BlogSearchController(blogSearchService = mockBlogSearchService)
    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(mockBlogSearchController).build()

    @Test
    fun test() {

    }
}
