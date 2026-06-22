package mx.utng.cfga.memorymatchwear.domain.usecase

import mx.utng.cfga.memorymatchwear.domain.model.GameState
import mx.utng.cfga.memorymatchwear.domain.model.GamePhase

class FlipCardUseCase {
    operator fun invoke(state: GameState, cardIndex: Int): GameState {
        val card = state.board[cardIndex]
        if (card.isFlipped || card.isMatched) return state
        if (state.secondSelected != null) return state

        val newBoard = state.board.mapIndexed { i, c ->
            if (i == cardIndex) c.copy(isFlipped = true) else c
        }

        return if (state.firstSelected == null) {
            state.copy(board = newBoard, firstSelected = cardIndex, phase = GamePhase.WAITING_SECOND)
        } else {
            state.copy(board = newBoard, secondSelected = cardIndex, phase = GamePhase.CHECKING, moves = state.moves + 1)
        }
    }
}