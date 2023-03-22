package com.jaenyeong.study_blogsearchservice.blogsearch

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSearchParams
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.Sorting
import com.jaenyeong.study_blogsearchservice.blogsearch.searchengine.KakaoBlogSearchEngine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@DisplayName("Kakao 블로그 검색 API 테스트")
@ExtendWith(SpringExtension::class)
@SpringBootTest
class KakaoBlogSearchEngineTest(
    @Autowired
    private val kakaoBlogSearchEngine: KakaoBlogSearchEngine
) {
    @Disabled
    @Test
    @DisplayName("카카오 블로그 검색 API 조회 테스트 성공")
    fun successWhenCallKakaoBlogSearchAPITest() {
        // Arrange
        val searchParams = KakaoSearchParams(query = "카카오뱅크", sort = Sorting.of(null), page = null, size = null)

        // Act
        val blogListResponse = kakaoBlogSearchEngine.searchBlog(searchParams)

        // Assert
        assertThat(blogListResponse.meta.pageableCount).isGreaterThan(1)
        assertThat(blogListResponse.meta.totalCount).isGreaterThan(1)
        assertThat(blogListResponse.meta.pageableCount).isNotNull

        val firstBlog = blogListResponse.documents[0]
        assertThat(firstBlog.title).isNotNull
        assertThat(firstBlog.contents).isNotNull
        assertThat(firstBlog.url).isNotNull
        assertThat(firstBlog.blogname).isNotNull
    }
}
