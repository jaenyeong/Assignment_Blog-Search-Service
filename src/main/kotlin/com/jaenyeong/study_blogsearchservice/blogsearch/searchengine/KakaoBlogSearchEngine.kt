package com.jaenyeong.study_blogsearchservice.blogsearch.searchengine

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoBlogResponse
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.KakaoSearchParams
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping

private const val KAKAO_SEARCH_URI: String = "https://dapi.kakao.com"
private const val SEARCH_PATH: String = "v2/search/blog"
private const val AUTHORIZATION_HEADER: String = "Authorization=KakaoAK 6ebacf72b3cf39e318b993518915dbc7"

@FeignClient(name = "kakaoEngine", url = KAKAO_SEARCH_URI)
interface KakaoBlogSearchEngine {
    @GetMapping(value = [SEARCH_PATH], headers = [AUTHORIZATION_HEADER])
    fun searchBlog(@SpringQueryMap params: KakaoSearchParams): KakaoBlogResponse
}
