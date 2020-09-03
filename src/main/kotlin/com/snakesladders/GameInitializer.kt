package com.snakesladders

import com.snakesladders.entity.Token
import com.snakesladders.entity.Board
import java.lang.IllegalArgumentException

class GameInitializer(val board: Board) {

    var playingTokens: List<Token> = emptyList()

    constructor(board: Board, playerId: List<String>) : this(board) {
        playingTokens = playerId
            .map { Token.startToken(it, board) }
    }

    fun moveToken(playerId: String, diceNumber: Int) {
        val token: Token = playingTokens //ideally I would use a hash mapping instead of filtering
            .find { it.id == playerId }
            ?: throw IllegalArgumentException("No player with id $playerId is on the board")
        token.moveToken(diceNumber)
    }

}