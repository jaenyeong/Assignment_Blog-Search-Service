package com.jaenyeong.study_blogsearchservice.blogsearch

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.NaverSearchParams
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.NaverSorting
import com.jaenyeong.study_blogsearchservice.blogsearch.searchengine.NaverBlogSearchEngine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@DisplayName("Naver 블로그 검색 API 테스트")
@ExtendWith(SpringExtension::class)
@SpringBootTest
class NaverBlogSearchEngineTest(
    @Autowired
    private val naverBlogSearchEngine: NaverBlogSearchEngine
) {
    @Test
    @DisplayName("Naver 블로그 검색 API 조회 테스트 성공")
    fun successWhenCallNaverBlogSearchAPITest() {
        // Arrange
        val searchParams = NaverSearchParams(query = "아이유", display = null, start = 1, sort = NaverSorting.of(null))

        // Act
        val blogListResponse = naverBlogSearchEngine.searchBlog(searchParams)

        // Assert
        println(blogListResponse)
    }
}
