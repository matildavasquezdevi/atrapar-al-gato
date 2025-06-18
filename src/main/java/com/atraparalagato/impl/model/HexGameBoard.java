package com.atraparalagato.impl.model;

import com.atraparalagato.base.model.GameBoard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Implementación esqueleto de GameBoard para tableros hexagonales.
 * 
 * Los estudiantes deben completar los métodos marcados con TODO.
 * 
 * Conceptos a implementar:
 * - Modularización: Separación de lógica de tablero hexagonal
 * - OOP: Herencia y polimorfismo
 * - Programación Funcional: Uso de Predicate y streams
 */
public class HexGameBoard extends GameBoard<HexPosition> {
    
    public HexGameBoard(int size) {
        super(size);
    }
    
    @Override
    protected Set<HexPosition> initializeBlockedPositions() {
        // TODO: Los estudiantes deben decidir qué estructura de datos usar
        // Opciones: HashSet, TreeSet, LinkedHashSet, etc.
        // Considerar rendimiento vs orden vs duplicados
        return new HashSet<>();
    }
    
    @Override
    protected boolean isPositionInBounds(HexPosition position) {
        // TODO: Implementar validación de límites para tablero hexagonal
        // Pista: Usar coordenadas axiales q, r, s
        // Condición: |q| <= size && |r| <= size && |s| <= size
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    @Override
    protected boolean isValidMove(HexPosition position) {
        // TODO: Combinar validación de límites y estado actual
        // Debe verificar:
        // 1. Que la posición esté dentro de los límites
        // 2. Que la posición no esté ya bloqueada
        // 3. Cualquier regla adicional del juego
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    @Override
    protected void executeMove(HexPosition position) {
        // TODO: Actualizar el estado interno del tablero
        // Agregar la posición a las posiciones bloqueadas
        // Considerar si necesita validación adicional
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    @Override
    public List<HexPosition> getPositionsWhere(Predicate<HexPosition> condition) {
        // TODO: Implementar usando programación funcional
        // Generar todas las posiciones posibles del tablero
        // Filtrar usando el Predicate
        // Retornar como List
        // 
        // Ejemplo de uso de streams:
        // return getAllPossiblePositions().stream()
        //     .filter(condition)
        //     .collect(Collectors.toList());
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    @Override
    public List<HexPosition> getAdjacentPositions(HexPosition position) {
        // TODO: Obtener las 6 posiciones adyacentes en un tablero hexagonal
        // Direcciones hexagonales: (+1,0), (+1,-1), (0,-1), (-1,0), (-1,+1), (0,+1)
        // Filtrar las que estén dentro de los límites del tablero
        // 
        // Pista: Crear array de direcciones y usar streams para mapear
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    @Override
    public boolean isBlocked(HexPosition position) {
        // TODO: Verificar si una posición está en el conjunto de bloqueadas
        // Método simple de consulta
        throw new UnsupportedOperationException("Los estudiantes deben implementar este método");
    }
    
    // Método auxiliar que los estudiantes pueden implementar
    private List<HexPosition> getAllPossiblePositions() {
        // TODO: Generar todas las posiciones válidas del tablero
        // Usar doble loop para q y r, calcular s = -q - r
        // Filtrar posiciones que estén dentro de los límites
        throw new UnsupportedOperationException("Método auxiliar para implementar");
    }
    
    // Hook method override - ejemplo de extensibilidad
    @Override
    protected void onMoveExecuted(HexPosition position) {
        // TODO: Los estudiantes pueden agregar lógica adicional aquí
        // Ejemplos: logging, notificaciones, validaciones post-movimiento
        super.onMoveExecuted(position);
    }
} 