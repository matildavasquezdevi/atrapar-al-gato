# Proyecto Final: Atrapar al Gato 🐱

## Configuración del Proyecto

### Propiedad de Configuración
En `application.properties` puedes cambiar entre implementaciones:

```properties
# true = usar implementaciones de ejemplo (example package)
# false = usar implementaciones de estudiantes (impl package)
game.use-example-implementation=true
```

## Estructura del Proyecto

### Paquetes Base (NO MODIFICAR)
Los estudiantes **NO DEBEN** modificar las clases en el paquete `com.atraparalagato.base.*`:

```
src/main/java/com/atraparalagato/base/
├── model/
│   ├── Position.java           # Clase base para posiciones
│   ├── GameBoard.java          # Clase base para tableros
│   └── GameState.java          # Clase base para estado del juego
├── strategy/
│   └── CatMovementStrategy.java # Estrategia base para movimiento del gato
├── repository/
│   └── DataRepository.java     # Repositorio base para persistencia
└── service/
    └── GameService.java        # Servicio base del juego
```

### Paquetes de Ejemplo (ESTUDIAR)
Los estudiantes **DEBEN ESTUDIAR** las implementaciones de ejemplo en `com.atraparalagato.example.*`:

```
src/main/java/com/atraparalagato/example/
├── model/
│   ├── ExampleGameState.java   # ✅ Implementación básica de GameState
│   └── ExampleGameBoard.java   # ✅ Implementación básica de GameBoard
├── strategy/
│   └── SimpleCatMovement.java  # ✅ Estrategia simple (poco inteligente)
├── repository/
│   └── InMemoryGameRepository.java # ✅ Repositorio en memoria
└── service/
    └── ExampleGameService.java # ✅ Servicio básico del juego
```

### Paquetes de Implementación (COMPLETAR)
Los estudiantes **DEBEN** completar las implementaciones en `com.atraparalagato.impl.*`:

```
src/main/java/com/atraparalagato/impl/
├── model/
│   ├── HexPosition.java        # ✅ Implementación completa (ejemplo)
│   ├── HexGameBoard.java       # ⚠️ COMPLETAR métodos TODO
│   └── HexGameState.java       # ⚠️ COMPLETAR métodos TODO (NUEVO)
├── strategy/
│   ├── AStarCatMovement.java   # ⚠️ COMPLETAR métodos TODO
│   └── BFSCatMovement.java     # ⚠️ COMPLETAR métodos TODO (NUEVO)
├── repository/
│   └── H2GameRepository.java   # ⚠️ COMPLETAR métodos TODO (NUEVO)
└── service/
    └── HexGameService.java     # ⚠️ COMPLETAR métodos TODO (NUEVO)
```

### Controlador y Frontend
```
src/main/java/com/atraparalagato/controller/
└── GameController.java         # ✅ Controlador que alterna implementaciones

src/main/resources/static/
├── index.html                  # ✅ Frontend completo
├── styles.css                  # ✅ Estilos mejorados
└── game.js                     # ✅ Lógica del frontend
```

## Cómo Usar las Implementaciones de Ejemplo

### 1. Activar Implementaciones de Ejemplo
```properties
# En application.properties
game.use-example-implementation=true
```

### 2. Estudiar las Implementaciones
Las clases de ejemplo están **INTENCIONALMENTE SIMPLIFICADAS** para fines educativos:

#### ExampleGameState
- Implementación básica de estado del juego
- Lógica simple para determinar victoria/derrota
- Sistema de puntuación básico
- Serialización simple con Map

#### ExampleGameBoard
- Tablero hexagonal con HashSet para posiciones bloqueadas
- Métodos básicos de validación y movimiento
- Generación de posiciones adyacentes
- Estadísticas del tablero

#### SimpleCatMovement
- Estrategia **POCO INTELIGENTE** del gato
- 70% movimiento hacia el borde, 30% aleatorio
- BFS básico para pathfinding
- Sin optimizaciones avanzadas

#### InMemoryGameRepository
- Almacenamiento en memoria con ConcurrentHashMap
- Operaciones CRUD básicas
- Consultas funcionales simples
- Sin transacciones reales

#### ExampleGameService
- Orquestación básica de componentes
- Manejo simple de eventos
- Validaciones básicas
- Logging con emojis para debugging

### 3. Cambiar a Implementaciones de Estudiantes
```properties
# En application.properties
game.use-example-implementation=false
```

**NOTA**: Al cambiar a `false`, el juego mostrará mensajes de error hasta que los estudiantes completen sus implementaciones.

## Tareas por Completar

### 1. Modularización (25% de la nota)

#### Estudiar y Mejorar HexGameBoard.java
```java
// TODO: Implementar métodos marcados basándose en ExampleGameBoard
- isPositionInBounds()
- isValidMove()
- executeMove()
- getPositionsWhere()
- getAdjacentPositions()
- isBlocked()
```

#### Completar HexGameState.java (NUEVO)
```java
// Esqueleto creado: impl/model/HexGameState.java
// Basarse en ExampleGameState pero mejorar:
// - Lógica más sofisticada de victoria/derrota
// - Sistema de puntuación más complejo
// - Mejor manejo de serialización
// TODO: Implementar todos los métodos marcados con UnsupportedOperationException
- Constructor completo
- canExecuteMove()
- performMove()
- updateGameStatus()
- getCatPosition() / setCatPosition()
- isGameFinished() / hasPlayerWon()
- calculateScore()
- getSerializableState() / restoreFromSerializable()
```

### 2. Programación Orientada a Objetos (25% de la nota)

#### Mejorar AStarCatMovement.java
```java
// TODO: Implementar algoritmo A* INTELIGENTE
// Basarse en SimpleCatMovement pero mejorar:
// - Heurística más sofisticada
// - Pathfinding optimizado
// - Estrategia más inteligente
- getPossibleMoves()
- selectBestMove()
- getHeuristicFunction()
- getGoalPredicate()
- hasPathToGoal()
- getFullPath()
```

#### Completar BFSCatMovement.java (NUEVO)
```java
// Esqueleto creado: impl/strategy/BFSCatMovement.java
// Implementar algoritmo BFS completo:
// - Exploración exhaustiva por niveles
// - Garantía de camino más corto
// - Uso de colas para BFS
// TODO: Implementar todos los métodos marcados
- getPossibleMoves()
- selectBestMove()
- hasPathToGoal()
- getFullPath()
- Métodos auxiliares de BFS
```

#### Crear más estrategias de movimiento (OPCIONAL)
```java
// Sugerencias adicionales:
- DFSCatMovement.java (Depth-First Search)
- GreedyCatMovement.java (Algoritmo codicioso)
- MinimaxCatMovement.java (Minimax con poda alfa-beta)
```

### 3. Programación Funcional (25% de la nota)

#### Completar H2GameRepository.java (NUEVO)
```java
// Esqueleto creado: impl/repository/H2GameRepository.java
// Implementar repositorio con base de datos H2:
// - Conexión a H2 usando configuración de Spring
// - Operaciones CRUD con SQL
// - Manejo de transacciones
// - Consultas funcionales con Predicate y Function
// TODO: Implementar todos los métodos marcados
- save() / findById() / findAll()
- findWhere() / findAndTransform()
- executeInTransaction()
- Métodos auxiliares de serialización
```

#### Usar funciones de orden superior
- `Function<T, R>` para transformaciones
- `Predicate<T>` para filtros
- `Consumer<T>` para callbacks
- `Supplier<T>` para factories
- `Optional<T>` para valores opcionales

#### Ejemplos requeridos (mejorar los de ejemplo):
```java
// En GameBoard
public List<T> getPositionsWhere(Predicate<T> condition);

// En CatMovementStrategy
protected Function<T, Double> getHeuristicFunction(T target);
protected Predicate<T> getGoalPredicate();

// En DataRepository
public List<T> findWhere(Predicate<T> condition);
public <R> List<R> findAndTransform(Predicate<T> condition, Function<T, R> transformer);
```

### 4. Calidad y Buenas Prácticas (25% de la nota)

#### Completar HexGameService.java (NUEVO)
```java
// Esqueleto creado: impl/service/HexGameService.java
// Implementar servicio completo que extiende GameService:
// - Orquestación de todos los componentes
// - Lógica de negocio avanzada
// - Manejo de eventos y callbacks
// - Integración con repositorio y estrategias
// TODO: Implementar todos los métodos marcados
- Constructor con dependencias
- initializeGame()
- isValidMove() / getSuggestedMove()
- getTargetPosition() / getGameStatistics()
- Métodos adicionales avanzados
```

#### Escribir tests
```java
// Ejemplo en: test/java/com/atraparalagato/impl/model/
- HexPositionTest.java ✅ (ejemplo completo)
- HexGameBoardTest.java ❌ (crear)
- HexGameStateTest.java ❌ (crear para nueva clase)
- BFSCatMovementTest.java ❌ (crear para nueva estrategia)
- H2GameRepositoryTest.java ❌ (crear para nuevo repositorio)
- HexGameServiceTest.java ❌ (crear para nuevo servicio)
```

## Criterios de Evaluación

### Modularización (25%)
- ✅ Separación clara de responsabilidades
- ✅ Uso correcto de paquetes
- ✅ Implementación completa de interfaces base
- ✅ Código bien organizado y estructurado
- ✅ **Mejoras significativas sobre las implementaciones de ejemplo**

### OOP (25%)
- ✅ Herencia correcta de clases base
- ✅ Polimorfismo en estrategias y repositorios
- ✅ Encapsulación adecuada
- ✅ Uso de patrones de diseño
- ✅ **Estrategias más inteligentes que SimpleCatMovement**

### Programación Funcional (25%)
- ✅ Uso extensivo de Function, Predicate, Consumer, Supplier
- ✅ Streams y operaciones funcionales
- ✅ Inmutabilidad donde sea apropiado
- ✅ Composición de funciones
- ✅ **Uso más sofisticado que en las implementaciones de ejemplo**

### Calidad (25%)
- ✅ Tests unitarios completos
- ✅ Documentación clara
- ✅ Manejo de errores
- ✅ Rendimiento y eficiencia
- ✅ **Implementaciones más robustas que las de ejemplo**

## Funcionalidades del Frontend

### Juego Funcional ✅
- Tablero hexagonal interactivo
- Movimiento del gato con IA (simple o avanzada según configuración)
- Sistema de puntuaciones
- Interfaz moderna y responsiva

### Mejoras Implementadas ✅
- **Separación visual**: Hexágonos con espaciado mejorado
- **Popup corregido**: Se cierra correctamente y permite reiniciar
- **Efectos visuales**: Sombras, gradientes y animaciones
- **Sistema de puntuaciones**: Múltiples vistas de scores
- **Alternancia de implementaciones**: Configurable via properties

## Cómo Empezar

### 1. Estudiar las implementaciones de ejemplo
```bash
# Revisar las clases de ejemplo
src/main/java/com/atraparalagato/example/
```

### 2. Probar el juego con implementaciones de ejemplo
```bash
# Asegurar que game.use-example-implementation=true
mvn spring-boot:run
# Abrir: http://localhost:8080
```

### 3. Completar HexGameBoard basándose en ExampleGameBoard
```bash
# Implementar métodos TODO
src/main/java/com/atraparalagato/impl/model/HexGameBoard.java
```

### 4. Crear implementaciones más sofisticadas
```bash
# Seguir la estructura de paquetes pero mejorar las implementaciones
src/main/java/com/atraparalagato/impl/
```

### 5. Cambiar a implementaciones de estudiantes
```bash
# Cambiar game.use-example-implementation=false
# Probar que todo funciona correctamente
```

## Recursos de Apoyo

### Patrones de Diseño Implementados
- **Strategy Pattern**: CatMovementStrategy (ver SimpleCatMovement)
- **Template Method**: GameBoard, GameState, GameService
- **Repository Pattern**: DataRepository (ver InMemoryGameRepository)
- **Factory Method**: En GameService
- **Observer Pattern**: Callbacks en GameState

### Conceptos de Programación Funcional
- **Higher-Order Functions**: Funciones que reciben/retornan funciones
- **Pure Functions**: Sin efectos secundarios
- **Immutability**: Objetos inmutables
- **Function Composition**: Combinar funciones simples

### Testing
```java
// Ejemplo de test funcional
@Test
void testPositionFiltering() {
    List<HexPosition> positions = board.getPositionsWhere(
        pos -> pos.distanceTo(center) <= 2
    );
    assertThat(positions).hasSize(expectedCount);
}
```

## Diferencias entre Implementaciones

### Implementaciones de Ejemplo (example)
- ✅ **Básicas y funcionales**
- ✅ **Fáciles de entender**
- ✅ **Bien documentadas**
- ✅ **Lógica de fin de juego corregida**
- ❌ **Intencionalmente simples**
- ❌ **Gato poco inteligente**
- ❌ **Sin optimizaciones**

### Implementaciones de Estudiantes (impl)
- ⚠️ **Esqueletos con TODOs creados**
- ⚠️ **Clases base implementadas**
- ❌ **Requieren implementación completa**
- ✅ **Deben ser sofisticadas y optimizadas**
- ✅ **Gato más inteligente requerido**
- ✅ **Mejor rendimiento esperado**
- ✅ **Funcionalidades avanzadas**
- ✅ **Patrones de diseño complejos**
- ✅ **Tests completos requeridos**

### Estado Actual del Proyecto
- ✅ **Juego funcional con implementaciones de ejemplo**
- ✅ **Lógica de fin de juego corregida** (gato atrapado/escapado)
- ✅ **Frontend completamente funcional**
- ✅ **Esqueletos creados para estudiantes**:
  - `HexGameState.java` - Estado del juego avanzado
  - `BFSCatMovement.java` - Estrategia BFS
  - `H2GameRepository.java` - Repositorio con base de datos
  - `HexGameService.java` - Servicio completo
- ✅ **TODOs detallados en cada clase**
- ✅ **Documentación completa actualizada**

## Entrega

### Archivos Requeridos
1. **Implementaciones completas** en `impl/` que **superen** las de `example/`
2. **Tests unitarios** en `test/`
3. **Documentación** de decisiones de diseño
4. **README** con instrucciones de ejecución
5. **Comparación** entre implementaciones de ejemplo y propias

### Criterios de Aceptación
- ✅ Compilación sin errores
- ✅ Tests pasan exitosamente
- ✅ Juego funciona en el navegador con ambas configuraciones
- ✅ Código bien documentado
- ✅ Uso correcto de todos los paradigmas
- ✅ **Implementaciones significativamente mejores que las de ejemplo**

¡Buena suerte con el proyecto! 🚀

**NOTA IMPORTANTE**: Las implementaciones de ejemplo están diseñadas para ser **básicas y educativas**. Se espera que los estudiantes las **superen significativamente** en sofisticación, inteligencia y calidad. 