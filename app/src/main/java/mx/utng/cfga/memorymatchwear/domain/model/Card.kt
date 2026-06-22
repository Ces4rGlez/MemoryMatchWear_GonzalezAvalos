package mx.utng.cfga.memorymatchwear.domain.model

data class Card(
    val id: Int,
    val symbol: CardSymbol,
    val isFlipped: Boolean = false,
    val isMatched: Boolean = false
)