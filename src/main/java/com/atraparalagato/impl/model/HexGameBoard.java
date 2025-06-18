package com.atraparalagato.impl.model;

import com.atraparalagato.base.model.GameBoard;
import com.atraparalagato.base.model.Position;

import java.util.*;
import java.util.function.Predicate;

/**
 * Representa el tablero hexagonal del juego "Atrapar al Gato".
 * Administra las posiciones válidas, las celdas bloqueadas por el jugador
 * y calcula los vecinos de una celda hexagonal.
 */
public class HexGameBoard extends GameBoard {

    private final int size;
    private final Set<Position> blockedPositions;

    /* Constructor del tablero hexagonal.
    Llama al constructor de GameBoard (super) con el tamaño. */
    public HexGameBoard(int size) {
        super(size);
        this.size = size;
        this.blockedPositions = new HashSet<>();
    }

    /* Inicializa o reinicia las posiciones bloqueadas.
        Retorna el conjunto vacío actualizado, según lo que espera la clase base.
     */
    @Override
    public Set<Position> initializeBlockedPositions() {
        blockedPositions.clear();
        return blockedPositions;
    }

    /**
     * Verifica si una posición (q, r) está dentro del tablero hexagonal.
     * Un tablero de tamaño N incluye todas las posiciones donde:
     * |q| <= N, |r| <= N y |q + r| <= N
     */
    @Override
    public boolean isPositionInBounds(Position pos) {
        int q = ((HexPosition) pos).getQ();
        int r = ((HexPosition) pos).getR();
        int s = -q - r;

        return Math.abs(q) <= size && Math.abs(r) <= size && Math.abs(s) <= size;
    }

    /**
     * Verifica si una posición ya fue bloqueada por el jugador.
     * Las posiciones bloqueadas están almacenadas en un conjunto (Set).
     */
    @Override
    public boolean isBlocked(Position pos) {
        return blockedPositions.contains(pos);
    }

    /**
     * Retorna las 6 posiciones vecinas de una celda hexagonal.
     * Se descartan las posiciones que:
     *  - Están fuera del tablero
     *  - Están bloqueadas
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
     * Devuelve una lista de posiciones del tablero que cumplen una condición dada.
     * Usa un Predicate (sin genéricos) como en la clase base para evitar errores de erasure.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Position> getPositionsWhere(Predicate condition) {
        List<Position> result = new ArrayList<>();

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
     * Verifica si una posición puede ser bloqueada por el jugador.
     * Debe estar dentro del tablero y no estar ya bloqueada.
     */
    @Override
    public boolean isValidMove(Position pos) {
        return isPositionInBounds(pos) && !isBlocked(pos);
    }

    /**
     * Ejecuta un movimiento del jugador, bloqueando la celda indicada.
     * Si la jugada no es válida, lanza una excepción.
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
