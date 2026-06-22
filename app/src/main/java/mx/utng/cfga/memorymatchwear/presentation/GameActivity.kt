package mx.utng.cfga.memorymatchwear.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.utng.cfga.memorymatchwear.presentation.board.BoardScreen
import mx.utng.cfga.memorymatchwear.presentation.board.MemoryViewModel
import mx.utng.cfga.memorymatchwear.presentation.theme.MemoryMatchWearTheme

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: MemoryViewModel = viewModel(
                factory = MemoryViewModelFactory(applicationContext)
            )
            MemoryMatchWearTheme {
                BoardScreen(viewModel = vm)
            }
        }
    }
}