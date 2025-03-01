package com.droidknights.app2023.feature.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.droidknights.app2023.core.model.Sponsor
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SponsorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val fakeUiState: MutableState<SponsorsUiState> =
        mutableStateOf(SponsorsUiState(sponsors))

    @Before
    fun setup() {
        composeTestRule.setContent {
            SponsorCard(fakeUiState.value)
        }
    }

    @Test
    fun 등급별_스폰서_수가_노출된다() {
        // then
        composeTestRule
            .onNodeWithText("플래티넘 1곳, 골드 1곳이\n후원해주셨습니다.")
            .assertExists()
    }

    companion object {
        private val sponsors =
            listOf(
                Sponsor(
                    name = "Sponsor1",
                    homepage = "https://www.instagram.com/droid_knights",
                    grade = Sponsor.Grade.GOLD,
                    imageUrl = "https://avatars.githubusercontent.com/u/25101514",
                ),
                Sponsor(
                    name = "Sponsor2",
                    homepage = "https://www.instagram.com/droid_knights",
                    grade = Sponsor.Grade.PLATINUM,
                    imageUrl = "https://avatars.githubusercontent.com/u/25101514",
                ),
            )
    }
}
