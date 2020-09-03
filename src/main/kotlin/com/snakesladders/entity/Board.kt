package com.snakesladders.entity

class Board constructor(val size: Int) {

    var boardSpace: MutableMap<Int, MutableList<String>> = (1..size)
        .associateWith { mutableListOf<String>() }
        .toMutableMap()

    fun setToken(squareNumber: Int, token: Token): Int {
        boardSpace[token.currentSquare]?.remove(token.id)
        val square = if (squareNumber > size) size else squareNumber
        boardSpace[square]?.add(token.id)
        return square
    }

    fun getFinisher(): String? {
        val lastSquarePlayers = boardSpace.values.last()
        return if (lastSquarePlayers.isNotEmpty()) lastSquarePlayers.first() else null
    }

}