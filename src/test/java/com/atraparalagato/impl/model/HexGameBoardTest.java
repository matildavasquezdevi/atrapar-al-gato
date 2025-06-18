package com.atraparalagato.impl.model;

import com.atraparalagato.base.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HexGameBoardTest {

    private HexGameBoard board;

    @BeforeEach
    void setUp() {
        board = new HexGameBoard(2); // tablero pequeño para test
    }

    @Test
    void testIsPositionInBounds() {
        assertTrue(board.isPositionInBounds(new HexPosition(0, 0)));
        assertTrue(board.isPositionInBounds(new HexPosition(1, -1)));
        assertFalse(board.isPositionInBounds(new HexPosition(3, 0)));
        assertFalse(board.isPositionInBounds(new HexPosition(-3, 1)));
    }

    @Test
    void testExecuteAndIsBlocked() {
        Position pos = new HexPosition(1, -1);
        assertFalse(board.isBlocked(pos));
        board.executeMove(pos);
        assertTrue(board.isBlocked(pos));
    }

    @Test
    void testIsValidMove() {
        Position valid = new HexPosition(1, -1);
        Position invalid = new HexPosition(3, 0);
        board.executeMove(valid);

        assertTrue(board.isValidMove(new HexPosition(0, 0)));
        assertFalse(board.isValidMove(valid)); // ya bloqueada
        assertFalse(board.isValidMove(invalid)); // fuera del tablero
    }

    @Test
    void testGetAdjacentPositions() {
        Position center = new HexPosition(0, 0);
        List<Position> neighbors = board.getAdjacentPositions(center);

        assertEquals(6, neighbors.size()); // En tablero 2, el centro tiene todos los vecinos
        for (Position p : neighbors) {
            assertTrue(board.isPositionInBounds(p));
            assertFalse(board.isBlocked(p));
        }

        // bloqueamos uno y revisamos que desaparezca
        board.executeMove(neighbors.get(0));
        List<Position> updated = board.getAdjacentPositions(center);
        assertEquals(5, updated.size());
    }

    @Test
    void testGetPositionsWhere() {
        board.executeMove(new HexPosition(0, 0));
        board.executeMove(new HexPosition(1, -1));

        List<Position> freeCells = board.getPositionsWhere(p -> !board.isBlocked((Position) p));

        // debería excluir las dos posiciones bloqueadas
        assertTrue(freeCells.stream().noneMatch(p ->
            p.equals(new HexPosition(0, 0)) || p.equals(new HexPosition(1, -1))
        ));
}

    @Test
    void testInitializeBlockedPositions() {
        board.executeMove(new HexPosition(0, 0));
        Set<Position> cleared = board.initializeBlockedPositions();
        assertTrue(cleared.isEmpty());
        assertFalse(board.isBlocked(new HexPosition(0, 0)));
    }
}
