package com.jaenyeong.study_blogsearchservice.blogsearch

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.BlogsDto
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSearchParams
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSorting
import com.jaenyeong.study_blogsearchservice.blogsearch.searchengine.KakaoBlogSearchEngine

import org.springframework.stereotype.Service

@Service
class BlogSearchService(
    private val kakaoBlogSearchEngine: KakaoBlogSearchEngine
) {
    fun searchBlog(query: String, sort: String?, page: Int?, size: Int?): BlogsDto {
        val kakaoSearchParams = KakaoSearchParams(
            query = query,
            sort = KakaoSorting.of(sort),
            page = page,
            size = size
        )

        return BlogsDto.of(kakaoBlogSearchEngine.searchBlog(kakaoSearchParams))
    }
}
