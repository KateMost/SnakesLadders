package com.snakesladders

import com.snakesladders.entity.Board
import com.snakesladders.entity.Die
import com.snakesladders.entity.Token

class Game(val board: Board, val die: Die) {

    var playingTokens: List<Token> = emptyList()

    constructor(board: Board, die: Die, playerId: List<String>) : this(board, die) {
        playingTokens = playerId
            .map { Token.startToken(it, board) }
    }

    fun play() {
        while (true) {
            playingTokens.forEach {
                it.moveToken(die.roll())
                println("Player: ${it.id} is currenty on square ${it.currentSquare}")//sure this would be replaced by a more equisite border renderer
            }
        }
    }

}

fun main() {
    val board = Board(100)
    val die = Die()
    val players = listOf("John", "Kate", "Ann")

    val game = Game(board, die, players)
    game.play()
}