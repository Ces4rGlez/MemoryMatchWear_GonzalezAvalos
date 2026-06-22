import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import mx.utng.cfga.memorymatchwear.domain.model.GameState

@Composable
fun VictoryScreen(state: GameState, onRestart: () -> Unit) {
    Box(Modifier.fillMaxSize().background(Color(0xFF0A2A0A)), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("🏆 ¡Victoria!", style = MaterialTheme.typography.title3, color = Color(0xFFF9A825), fontWeight = FontWeight.Bold)
            Text("⏱ ${state.elapsedSeconds}s · 🎯 ${state.moves} mov", style = MaterialTheme.typography.body2, color = Color.White)
            Chip(onClick = onRestart, label = { Text("↺ Reiniciar") }, modifier = Modifier.fillMaxWidth(0.8f))
        }
    }
}