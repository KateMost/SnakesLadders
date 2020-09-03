package com.snakesladders

import com.snakesladders.entity.Board
import com.snakesladders.entity.Die
import com.snakesladders.entity.Token
import java.util.concurrent.TimeUnit

class Game(val board: Board, val die: Die) {

    var playingTokens: List<Token> = emptyList()

    constructor(board: Board, die: Die, playerId: List<String>) : this(board, die) {
        playingTokens = playerId
            .map { Token.startToken(it, board) }
    }

    fun play() {
        while (true) {
            playingTokens.forEach {
                val winner = board.getFinisher()
                if (winner != null) {
                    print("Aaaand we've got a WINNER: $winner, congrats!!!")
                    return
                }
                it.moveToken(die.roll())
                TimeUnit.MILLISECONDS.sleep(200)
                println("Player: ${it.id} is currenty on square ${it.currentSquare}")//sure this would be replaced by a more exquisite border renderer
            }
            println("Next round=================================")
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