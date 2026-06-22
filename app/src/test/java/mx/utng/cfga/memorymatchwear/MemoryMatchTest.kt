package mx.utng.cfga.memorymatchwear

import org.junit.Assert.*
import org.junit.Test
import mx.utng.cfga.memorymatchwear.domain.model.*
import mx.utng.cfga.memorymatchwear.domain.usecase.*

class MemoryMatchTest {
    private val shuffle = ShuffleBoardUseCase()
    private val flip = FlipCardUseCase()
    private val check = CheckMatchUseCase()

    @Test
    fun `board has 12 cards`() {
        assertEquals(12, shuffle().size)
    }

    @Test
    fun `board has exactly 2 of each symbol`() {
        val board = shuffle()
        CardSymbol.values().forEach { symbol ->
            assertEquals(2, board.count { it.symbol == symbol })
        }
    }

    @Test
    fun `flip sets card isFlipped to true`() {
        val board = shuffle()
        val state = GameState(board = board, phase = GamePhase.SELECTING_FIRST)
        val next = flip(state, 0)
        assertTrue(next.board[0].isFlipped)
    }
}