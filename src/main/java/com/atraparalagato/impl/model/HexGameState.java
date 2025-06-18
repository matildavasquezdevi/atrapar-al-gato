package com.atraparalagato.impl.model;

import com.atraparalagato.base.model.GameState;

import java.util.Map;

/**
 * Implementación esqueleto de GameState para tableros hexagonales.
 * 
 * Los estudiantes deben completar los métodos marcados con TODO.
 * 
 * Conceptos a implementar:
 * - Estado del juego más sofisticado que ExampleGameState
 * - Sistema de puntuación avanzado
 * - Lógica de victoria/derrota más compleja
 * - Serialización eficiente
 * - Manejo de eventos y callbacks
 */
public class HexGameState extends GameState<HexPosition> {
    
    private HexPosition catPosition;
    private HexGameBoard gameBoard;
    private final int boardSize;
    
    // TODO: Los estudiantes pueden agregar más campos según necesiten
    // Ejemplos: tiempo de juego, dificultad, power-ups, etc.
    
    public HexGameState(String gameId, int boardSize) {
        super(gameId);
        this.boardSize = boardSize;
        // TODO: Inicializar el tablero y posición inicial del gato
        // Pista: Usar HexGameBoard y posicionar el gato en el centro
        throw new UnsupportedOperationException("Los estudiantes deben implementar el constructor");
    }
    
    @Override
    protected boolean canExecuteMove(HexPosition position) {
        // TODO: Implementar validación de movimientos más sofisticada
        // Considerar:
        // 1. Validación básica del tablero
        // 2. Reglas específicas del juego
        // 3. Estado actual del juego
        // 4. Posibles restricciones adicionales
        throw new UnsupportedOperationException("Los estudiantes deben implementar canExecuteMove");
    }
    
    @Override
    protected boolean performMove(HexPosition position) {
        // TODO: Ejecutar el movimiento en el tablero
        // Debe actualizar el estado del tablero y verificar consecuencias
        // Retornar true si el movimiento fue exitoso
        throw new UnsupportedOperationException("Los estudiantes deben implementar performMove");
    }
    
    @Override
    protected void updateGameStatus() {
        // TODO: Implementar lógica de determinación de estado del juego
        // Debe verificar:
        // 1. Si el gato llegó al borde (PLAYER_LOST)
        // 2. Si el gato está atrapado (PLAYER_WON)
        // 3. Si hay empate o condiciones especiales
        // 4. Actualizar el estado usando setStatus()
        throw new UnsupportedOperationException("Los estudiantes deben implementar updateGameStatus");
    }
    
    @Override
    public HexPosition getCatPosition() {
        // TODO: Retornar la posición actual del gato
        throw new UnsupportedOperationException("Los estudiantes deben implementar getCatPosition");
    }
    
    @Override
    public void setCatPosition(HexPosition position) {
        // TODO: Establecer la nueva posición del gato
        // IMPORTANTE: Debe llamar a updateGameStatus() después de mover el gato
        // para verificar si el juego terminó
        throw new UnsupportedOperationException("Los estudiantes deben implementar setCatPosition");
    }
    
    @Override
    public boolean isGameFinished() {
        // TODO: Verificar si el juego ha terminado
        // Puede basarse en getStatus() o implementar lógica adicional
        throw new UnsupportedOperationException("Los estudiantes deben implementar isGameFinished");
    }
    
    @Override
    public boolean hasPlayerWon() {
        // TODO: Verificar si el jugador ganó
        // Determinar las condiciones específicas de victoria
        throw new UnsupportedOperationException("Los estudiantes deben implementar hasPlayerWon");
    }
    
    @Override
    public int calculateScore() {
        // TODO: Implementar sistema de puntuación más sofisticado que ExampleGameState
        // Considerar factores como:
        // 1. Número de movimientos (menos es mejor)
        // 2. Tiempo transcurrido
        // 3. Tamaño del tablero (más difícil = más puntos)
        // 4. Bonificaciones especiales
        // 5. Penalizaciones por movimientos inválidos
        throw new UnsupportedOperationException("Los estudiantes deben implementar calculateScore");
    }
    
    @Override
    public Object getSerializableState() {
        // TODO: Crear representación serializable del estado
        // Debe incluir toda la información necesaria para restaurar el juego
        // Considerar usar Map, JSON, o clase personalizada
        // Incluir: gameId, catPosition, blockedCells, status, moveCount, etc.
        throw new UnsupportedOperationException("Los estudiantes deben implementar getSerializableState");
    }
    
    @Override
    public void restoreFromSerializable(Object serializedState) {
        // TODO: Restaurar el estado desde una representación serializada
        // Debe ser compatible con getSerializableState()
        // Manejar errores y validar la integridad de los datos
        throw new UnsupportedOperationException("Los estudiantes deben implementar restoreFromSerializable");
    }
    
    // Métodos auxiliares que los estudiantes pueden implementar
    
    /**
     * TODO: Verificar si el gato está en el borde del tablero.
     * Los estudiantes deben definir qué constituye "el borde".
     */
    private boolean isCatAtBorder() {
        throw new UnsupportedOperationException("Método auxiliar para implementar");
    }
    
    /**
     * TODO: Verificar si el gato está completamente atrapado.
     * Debe verificar si todas las posiciones adyacentes están bloqueadas.
     */
    private boolean isCatTrapped() {
        throw new UnsupportedOperationException("Método auxiliar para implementar");
    }
    
    /**
     * TODO: Calcular estadísticas avanzadas del juego.
     * Puede incluir métricas como eficiencia, estrategia, etc.
     */
    public Map<String, Object> getAdvancedStatistics() {
        throw new UnsupportedOperationException("Método adicional para implementar");
    }
    
    // Getters adicionales que pueden ser útiles
    
    public HexGameBoard getGameBoard() {
        return gameBoard;
    }
    
    public int getBoardSize() {
        return boardSize;
    }
    
    // TODO: Los estudiantes pueden agregar más métodos según necesiten
    // Ejemplos: getDifficulty(), getTimeElapsed(), getPowerUps(), etc.
} 