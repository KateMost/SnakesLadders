package com.snakesladders.entity

class Die {

    fun roll(): Int {
        return (1..6).random()
    }

}