package mx.utng.cfga.memorymatchwear.domain.usecase

import mx.utng.cfga.memorymatchwear.domain.model.Card
import mx.utng.cfga.memorymatchwear.domain.model.CardSymbol

class ShuffleBoardUseCase {
    operator fun invoke(): List<Card> =
        CardSymbol.values()
            .flatMap { symbol -> listOf(symbol, symbol) }
            .shuffled()
            .mapIndexed { index, symbol -> Card(id = index, symbol = symbol) }
}