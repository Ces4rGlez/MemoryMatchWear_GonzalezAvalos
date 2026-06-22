package mx.utng.cfga.memorymatchwear.domain.usecase

import mx.utng.cfga.memorymatchwear.domain.repository.BestTimeRepository

class SaveBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(seconds: Long) = repository.saveBestTime(seconds)
}