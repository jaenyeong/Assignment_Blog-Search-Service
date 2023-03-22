package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import org.jetbrains.annotations.NotNull

data class NaverSearchParams(
    @NotNull
    val query: String,
    val display: Int?,
    val start: Int?,
    val sort: NaverSorting
) {
    init {
        display?.let {
            require(it in 1 .. 100) {
                "display must be between 1 and 100"
            }
        }

        start?.let {
            require(it in 1..1000) {
                "start must be between 1 and 1_000"
            }
        }
    }
}
