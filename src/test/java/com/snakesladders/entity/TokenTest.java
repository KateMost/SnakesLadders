package com.snakesladders.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    @Test
    public void shouldPlaceTokenOnStart() {
        Token token = Token.Companion.startToken("testId", new Board(10));

        assertEquals(1, token.getCurrentSquare());
    }

    @Test
    public void shouldMoveToken() {
        Board board = new Board(10);
        Token token = new Token("test", 1, board);

        token.moveToken(3);

        assertEquals(4, token.getCurrentSquare());
    }

    @Test
    public void shouldMoveTokenSeveralTimes() {
        Board board = new Board(10);
        Token token = new Token("test", 1, board);

        token.moveToken(3);
        token.moveToken(4);

        assertEquals(8, token.getCurrentSquare());
    }

}
