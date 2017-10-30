package com.capgemini.coedevon.codingdojo.rockpaperscissorslizardspock


enum class Movement {

    ROCK {
        override fun getOtherPlayerMovementsToWin(): Array<Movement> = arrayOf(SCISSORS, Movement.LIZARD)
    },
    PAPER {
        override fun getOtherPlayerMovementsToWin(): Array<Movement> = arrayOf(Movement.SPOCK, Movement.ROCK)
    },
    SCISSORS {
        override fun getOtherPlayerMovementsToWin(): Array<Movement> = arrayOf(Movement.LIZARD, Movement.PAPER)
    },
    LIZARD {
        override fun getOtherPlayerMovementsToWin(): Array<Movement> = arrayOf(Movement.PAPER, Movement.SPOCK)
    },
    SPOCK {
        override fun getOtherPlayerMovementsToWin(): Array<Movement> = arrayOf(Movement.ROCK, Movement.SCISSORS)
    };

    abstract fun getOtherPlayerMovementsToWin(): Array<Movement>

    fun calculateResult(otherMovement: Movement): Int {
        if (this == otherMovement)
            return 0

        if (getOtherPlayerMovementsToWin().contains(otherMovement))
            return 1

        return 2
    }
}
