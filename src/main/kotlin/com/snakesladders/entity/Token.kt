package com.snakesladders.entity

class Token(val id: String, var currentSquare: Int, val board: Board) {

    companion object {
        fun startToken(playerId: String, board: Board): Token {
            return Token(playerId, 1, board)
        }
    }

    fun moveToken(dieNumber: Int) {
        val square = board.setToken(currentSquare + dieNumber, this)
        currentSquare = square
    }

}