package com.jaenyeong.study_blogsearchservice.blogsearch

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.BlogsDto
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoDocument
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoBlogs
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSearchParams
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.Meta
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSorting
import com.jaenyeong.study_blogsearchservice.blogsearch.searchengine.KakaoBlogSearchEngine
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

@DisplayName("블로그 검색 서비스에 Service 레이어 테스트")
class BlogSearchServiceTest {
    private val kakaoBlogs: KakaoBlogs = KakaoBlogs(
        meta = Meta(
            totalCount = 484993,
            pageableCount = 800,
            isEnd = false
        ),
        documents = listOf(
            KakaoDocument(
                title = "<b>카카오</b><b>뱅크</b> 소상공인 개인 사업자 대출 금리와 신청방법",
                contents = "오늘 소개해드릴 내용은 ☑️ <b>카카오</b><b>뱅크</b> 계좌개설 방법입니다. 대부분 알고 계시겠지만 많은 분들이 <b>카카오</b><b>뱅크</b>를 이용하는 가장 큰 이유는 기계에서 사용하든 모바일에서 사용하든 수수료가 없기 때문입니다. 저도 이런 이유로 사용하고 있습니다",
                url = "http://soso.hbhbs.co.kr/20",
                blogname = "나이스한오늘",
                thumbnail = "https://search4.kakaocdn.net/argon/130x130_85_c/35TbQ1arv6h",
                datetime = LocalDateTime.of(2023, 2, 21, 16, 2, 18)
            ),
            KakaoDocument(
                title = "토스 모임통장, <b>카카오</b><b>뱅크</b> 모임통장 비교! 커플 데이트통장으로 추천!",
                contents = "사용하기에 경제적입니다. 남은 돈은 따로 모아둬서 여행갈때나 크게 돈나갈 일이있을 때 쓰기도 하고 그냥 이월해서 사용하기도 합니다.",
                url = "http://boribee.tistory.com/162",
                blogname = "지구에 머무르다.",
                thumbnail = "https://search3.kakaocdn.net/argon/130x130_85_c/3ZQOpcaJGyo",
                datetime = LocalDateTime.of(2023, 3, 19, 8, 38, 9)
            ),
        )
    )

    private val expectedBlogsDto = BlogsDto.of(kakaoBlogs)

    private val mockKakaoSearchEngine: KakaoBlogSearchEngine = mockk()
    private val blogSearchService: BlogSearchService = BlogSearchService(mockKakaoSearchEngine)

    @Test
    @DisplayName("카카오 블로그 검색 서비스 클래스의 `searchBlog` 함수 호출 시 KakaoSearchEngine의 `searchBlog` 함수 호출 성공")
    fun shouldReturnMockKakaoBlogResponseWithMockKakaoSearchEngine() {
        // Arrange
        val searchParams = KakaoSearchParams(query = "카카오뱅크", sort = KakaoSorting.of(null), page = null, size = null)

        every {
            mockKakaoSearchEngine.searchBlog(searchParams)
        } returns kakaoBlogs

        // Act
        val blogResponse = blogSearchService.searchBlog(query = "카카오뱅크", sort = null, page = null, size = null)

        // Assert
        val responseMeta = blogResponse.meta
        val expectedMeta = expectedBlogsDto.meta

        assertThat(responseMeta.totalCount).isEqualTo(expectedMeta.totalCount)
        assertThat(responseMeta.pageableCount).isEqualTo(expectedMeta.pageableCount)
        assertThat(responseMeta.isEnd).isEqualTo(expectedMeta.isEnd)

        val firstResponseBlog = blogResponse.documents[0]
        val firstExpectedBlog = kakaoBlogs.documents[0]

        assertThat(firstResponseBlog.title).isEqualTo(firstExpectedBlog.title)
        assertThat(firstResponseBlog.contents).isEqualTo(firstExpectedBlog.contents)
        assertThat(firstResponseBlog.url).isEqualTo(firstExpectedBlog.url)
        assertThat(firstResponseBlog.blogname).isEqualTo(firstExpectedBlog.blogname)
        assertThat(firstResponseBlog.thumbnail).isEqualTo(firstExpectedBlog.thumbnail)
    }
}
