package com.jaenyeong.study_blogsearchservice.blogsearch.dto

enum class KakaoSorting(val sortType: String) {
    ACCURACY("accuracy"),
    RECENCY("recency");

    override fun toString(): String {
        return sortType
    }

    companion object {
        fun of(givenSortType: String?): KakaoSorting {
            val findSortingType = givenSortType?.let {
                values().find { it.sortType.lowercase() == givenSortType.lowercase() }
            }

            return findSortingType ?: ACCURACY
        }
    }
}
