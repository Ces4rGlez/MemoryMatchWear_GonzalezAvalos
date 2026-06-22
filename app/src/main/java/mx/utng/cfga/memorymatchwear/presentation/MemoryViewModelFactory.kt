package mx.utng.cfga.memorymatchwear.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.utng.cfga.memorymatchwear.data.datasource.BestTimeDataSource
import mx.utng.cfga.memorymatchwear.domain.repository.BestTimeRepositoryImpl
import mx.utng.cfga.memorymatchwear.domain.usecase.*
import mx.utng.cfga.memorymatchwear.presentation.board.MemoryViewModel

class MemoryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = BestTimeDataSource(context)
        val repository = BestTimeRepositoryImpl(dataSource)
        return MemoryViewModel(
            shuffleBoard = ShuffleBoardUseCase(),
            flipCard = FlipCardUseCase(),
            checkMatch = CheckMatchUseCase(),
            saveBestTime = SaveBestTimeUseCase(repository),
            getBestTime = GetBestTimeUseCase(repository)
        ) as T
    }
}