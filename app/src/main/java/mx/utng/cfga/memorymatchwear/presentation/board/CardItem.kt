package mx.utng.cfga.memorymatchwear.presentation.board
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import mx.utng.cfga.memorymatchwear.domain.model.Card

@Composable
fun CardItem(card: Card, onTap: () -> Unit, modifier: Modifier = Modifier) {
    val rotation by animateFloatAsState(
        targetValue = if (card.isFlipped || card.isMatched) 180f else 0f,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
        label = "cardFlip"
    )

    val isFrontVisible = rotation > 90f

    Box(
        modifier = modifier
            .size(46.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12f * density
            }
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (card.isMatched) Color(0xFF1B5E20)
                else if (isFrontVisible) Color(card.symbol.color)
                else Color(0xFF1A237E)
            )
            .clickable(enabled = !card.isMatched && !card.isFlipped) { onTap() },
        contentAlignment = Alignment.Center
    ) {
        if (isFrontVisible) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = card.symbol.emoji, fontSize = 16.sp, modifier = Modifier.graphicsLayer { rotationY = 180f })
                Text(text = card.symbol.label, fontSize = 6.sp, color = Color.White, modifier = Modifier.graphicsLayer { rotationY = 180f })
            }
        } else {
            Text("U", color = Color(0xFFF9A825), fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.graphicsLayer { rotationY = 180f })
        }
    }
}