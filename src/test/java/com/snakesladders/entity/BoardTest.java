package com.snakesladders.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void shouldReturnPlayerOnTheLastSquare() {
        Board board = new Board(10);

        Token token = Token.Companion.startToken("test", board);
        token.moveToken(9);
        String finisher = board.getFinisher();

        assertEquals("test", finisher);
    }

    @Test
    public void shouldReturnNullWhenNoPlayerIsOnTheLastSquare() {
        Board board = new Board(10);

        Token token = Token.Companion.startToken("test", board);
        token.moveToken(7);
        String finisher = board.getFinisher();

        assertNull(finisher);
    }

}
