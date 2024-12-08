

package com.versionx.valetease.utils.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.versionx.valetease.presentation.screen.base.State
import com.versionx.valetease.presentation.screen.base.BaseViewModel

/**
 * Collects values from this ViewModel's state and represents its latest value via State.
 * Every time there would be new value posted into the state the returned State will be
 * updated causing recomposition of every State.value usage.
 */
@Composable
fun <S : State, VM : BaseViewModel<S>> VM.collectState() = state.collectAsState()
