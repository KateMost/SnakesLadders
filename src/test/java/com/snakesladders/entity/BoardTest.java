package com.snakesladders.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void shouldAddTokenToTheNewSquareAndRemoveFromPrevious() {
        Board board = new Board(10);
        Token token = Token.Companion.startToken("test", board);

        board.setToken(4, token);

        assertEquals(0, board.getBoardSpace().get(1).size());
        assertEquals(1, board.getBoardSpace().get(4).size());
    }

    @Test
    public void shouldAddTokenToLastSquareWhenNumberExceedsSize() {
        Board board = new Board(10);
        Token token = Token.Companion.startToken("test", board);

        board.setToken(11, token);

        assertEquals(1, board.getBoardSpace().get(10).size());
    }

}
