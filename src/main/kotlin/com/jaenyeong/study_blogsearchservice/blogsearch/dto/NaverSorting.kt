package com.jaenyeong.study_blogsearchservice.blogsearch.dto

enum class NaverSorting(private val sortType: String) {
    SIM("sim"),
    DATE("date");

    override fun toString(): String {
        return sortType
    }

    companion object {
        fun of(givenSortType: String?): NaverSorting {
            val findSortingType = givenSortType?.let {
                values().find { it.sortType.lowercase() == givenSortType.lowercase() }
            }

            return findSortingType ?: SIM
        }
    }
}
