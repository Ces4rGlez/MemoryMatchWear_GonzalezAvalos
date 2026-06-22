package mx.utng.cfga.memorymatchwear.domain.usecase

import mx.utng.cfga.memorymatchwear.domain.repository.BestTimeRepository

class GetBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(): Long = repository.getBestTime()
}