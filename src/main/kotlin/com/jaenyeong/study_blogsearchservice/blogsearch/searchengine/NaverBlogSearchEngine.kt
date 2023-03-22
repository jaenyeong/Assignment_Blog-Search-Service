package com.jaenyeong.study_blogsearchservice.blogsearch.searchengine

import com.jaenyeong.study_blogsearchservice.blogsearch.dto.NaverBlogs
import com.jaenyeong.study_blogsearchservice.blogsearch.dto.NaverSearchParams
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping

private const val NAVER_SEARCH_URI: String = "https://openapi.naver.com"
private const val SEARCH_PATH: String = "v1/search/blog.json"
private const val CLIENT_ID: String = "w2gveQnPm1UqfOfveYDy"
private const val CLIENT_SECRET: String = "vYoaV2OD_K"

@FeignClient(name = "naverEngine", url = NAVER_SEARCH_URI)
interface NaverBlogSearchEngine {
    @GetMapping(value = [SEARCH_PATH], headers = ["X-Naver-Client-Id=$CLIENT_ID", "X-Naver-Client-Secret=$CLIENT_SECRET"])
    fun searchBlog(@SpringQueryMap params: NaverSearchParams): NaverBlogs
}
