package mx.utng.cfga.memorymatchwear.domain.usecase

import mx.utng.cfga.memorymatchwear.domain.model.GameState

class CheckMatchUseCase {
    operator fun invoke(state: GameState): MatchResult {
        val first = state.firstSelected ?: return MatchResult.PENDING
        val second = state.secondSelected ?: return MatchResult.PENDING

        return if (state.board[first].symbol == state.board[second].symbol) MatchResult.HIT
        else MatchResult.MISS
    }
}

enum class MatchResult { HIT, MISS, PENDING }