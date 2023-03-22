package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import org.jetbrains.annotations.NotNull

data class KakaoSearchParams(
    @NotNull
    val query: String,
    val sort: Sorting,
    val page: Int?,
    val size: Int?
) {
    init {
        page?.let {
            assertValueRange(it, "page")
        }
        size?.let {
            assertValueRange(it, "size")
        }
    }

    private fun assertValueRange(value: Int, target: String) {
        require(value in 1..50) {
            "$target must be between 1 and 50"
        }
    }
}
