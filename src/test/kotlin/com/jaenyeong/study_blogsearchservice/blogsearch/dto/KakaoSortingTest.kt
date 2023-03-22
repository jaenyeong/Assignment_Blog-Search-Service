package com.jaenyeong.study_blogsearchservice.blogsearch.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import java.util.stream.Stream

class KakaoSortingTest {
    @ParameterizedTest
    @MethodSource("correctSortingTypes")
    @DisplayName("유효한 정렬 방식 문자열이 주어졌을 때 블로그 결과 정렬 방식 타입 가져오기 성공")
    fun successReturnMatchingSortingTypeTest(givenSortType: String, expectedKakaoSortingType: KakaoSorting) {
        // Arrange
        // Act
        val kakaoSortingType = KakaoSorting.of(givenSortType)

        // Assert
        assertThat(kakaoSortingType).isEqualTo(expectedKakaoSortingType)
        assertThat(kakaoSortingType.toString()).isEqualTo(expectedKakaoSortingType.toString())
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이 주어졌을 때 accuracy 타입 반환")
    fun returnAccuracyTypeWhenNullOrEmptyStringTest(nullOrEmptySortingType: String?) {
        // Arrange
        // Act
        val kakaoSortingType = KakaoSorting.of(nullOrEmptySortingType)

        // Assert
        assertThat(kakaoSortingType).isEqualTo(KakaoSorting.ACCURACY)
        assertThat(kakaoSortingType.toString()).isEqualTo(KakaoSorting.ACCURACY.toString())
    }

    companion object {
        @JvmStatic
        fun correctSortingTypes(): Stream<Arguments> =
            Stream.of(
                Arguments.of("accuracy", KakaoSorting.ACCURACY),
                Arguments.of("recency", KakaoSorting.RECENCY),
            )
    }
}
