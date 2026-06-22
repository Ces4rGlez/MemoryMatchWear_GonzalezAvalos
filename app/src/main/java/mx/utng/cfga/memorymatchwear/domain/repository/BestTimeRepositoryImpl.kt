package mx.utng.cfga.memorymatchwear.domain.repository

import mx.utng.cfga.memorymatchwear.data.datasource.BestTimeDataSource
import mx.utng.cfga.memorymatchwear.domain.repository.BestTimeRepository

class BestTimeRepositoryImpl(private val ds: BestTimeDataSource) : BestTimeRepository {
    override suspend fun getBestTime() = ds.getBestTime()
    override suspend fun saveBestTime(s: Long) = ds.saveBestTime(s)
}