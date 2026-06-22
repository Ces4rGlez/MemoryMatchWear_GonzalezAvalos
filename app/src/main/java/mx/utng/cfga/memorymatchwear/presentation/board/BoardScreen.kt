package mx.utng.cfga.memorymatchwear.presentation.board

import VictoryScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.*
import kotlinx.coroutines.delay
import mx.utng.cfga.memorymatchwear.domain.model.GamePhase
import mx.utng.cfga.memorymatchwear.presentation.board.GameEffect

@Composable
fun BoardScreen(viewModel: MemoryViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    val haptic = LocalHapticFeedback.current

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                GameEffect.HapticMatch, GameEffect.HapticMiss -> haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                GameEffect.HapticVictory -> repeat(3) {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    delay(150L)
                }
            }
        }
    }

    if (state.phase == GamePhase.WON) {
        VictoryScreen(state = state, onRestart = viewModel::startNewGame)
        return
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF0A0A1E))) {
        Text(
            text = "${state.elapsedSeconds}s · ${state.moves} mov",
            style = MaterialTheme.typography.caption1,
            color = Color.White,
            modifier = Modifier.alignment(Alignment.TopCenter).padding(top = 12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(top = 32.dp, start = 12.dp, end = 12.dp, bottom = 12.dp).align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(state.board) { index, card ->
                CardItem(card = card, onTap = { viewModel.onCardTapped(index) })
            }
        }
    }
}