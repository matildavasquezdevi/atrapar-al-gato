package com.atraparalagato.impl.model;

import com.atraparalagato.base.model.GameBoard;
import com.atraparalagato.base.model.Position;

import java.util.*;
import java.util.function.Predicate;

/**
 * Representa el tablero hexagonal del juego "Atrapar al Gato".
 */
public class HexGameBoard extends GameBoard {

    private Set<Position> blockedPositions;

    /**
     * Constructor que llama al constructor de GameBoard con el tamaño.
     */
    public HexGameBoard(int size) {
        super(size);
        // No inicialices blockedPositions aquí: se inicializa en initializeBlockedPositions()
    }

    /**
     * Inicializa o reinicia el conjunto de posiciones bloqueadas.
     * Este método es invocado automáticamente por GameBoard.
     */
    @Override
    public Set<Position> initializeBlockedPositions() {
        if (blockedPositions == null) {
            blockedPositions = new HashSet<>();
        } else {
            blockedPositions.clear();
        }
        return blockedPositions;
    }

    /**
     * Verifica si una posición (q, r) está dentro de los límites del tablero hexagonal.
     */
    @Override
    public boolean isPositionInBounds(Position pos) {
        int q = ((HexPosition) pos).getQ();
        int r = ((HexPosition) pos).getR();
        int s = -q - r;
        int size = getSize();

        return Math.abs(q) <= size && Math.abs(r) <= size && Math.abs(s) <= size;
    }

    /**
     * Verifica si una posición está bloqueada.
     */
    @Override
    public boolean isBlocked(Position pos) {
        return blockedPositions.contains(pos);
    }

    /**
     * Retorna las posiciones vecinas que están en el tablero y no están bloqueadas.
     */
    @Override
    public List<Position> getAdjacentPositions(Position pos) {
        int[][] directions = {
            {1, 0}, {0, 1}, {-1, 1},
            {-1, 0}, {0, -1}, {1, -1}
        };

        List<Position> neighbors = new ArrayList<>();
        int q = ((HexPosition) pos).getQ();
        int r = ((HexPosition) pos).getR();

        for (int[] dir : directions) {
            int newQ = q + dir[0];
            int newR = r + dir[1];
            Position neighbor = new HexPosition(newQ, newR);

            if (isPositionInBounds(neighbor) && !isBlocked(neighbor)) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    /**
     * Retorna todas las posiciones del tablero que cumplen una condición dada.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Position> getPositionsWhere(Predicate condition) {
        List<Position> result = new ArrayList<>();
        int size = getSize();

        for (int q = -size; q <= size; q++) {
            for (int r = -size; r <= size; r++) {
                Position pos = new HexPosition(q, r);
                if (isPositionInBounds(pos) && condition.test(pos)) {
                    result.add(pos);
                }
            }
        }

        return result;
    }

    /**
     * Verifica si una posición se puede bloquear (está en el tablero y no está ocupada).
     */
    @Override
    public boolean isValidMove(Position pos) {
        return isPositionInBounds(pos) && !isBlocked(pos);
    }

    /**
     * Bloquea una celda válida. Si no es válida, lanza una excepción.
     */
    @Override
    public void executeMove(Position pos) {
        if (isValidMove(pos)) {
            blockedPositions.add(pos);
        } else {
            throw new IllegalArgumentException("Movimiento inválido: posición fuera de rango o ya bloqueada.");
        }
    }
}
