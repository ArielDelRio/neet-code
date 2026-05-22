# Valid Sudoku

**Dificultad:** Media

## Enunciado

Se te da un tablero de Sudoku de 9 x 9 celdas. Un tablero de Sudoku es válido si se cumplen las siguientes reglas:

- Cada fila debe contener los dígitos del 1 al 9 sin repeticiones.
- Cada columna debe contener los dígitos del 1 al 9 sin repeticiones.
- Cada una de las nueve subcajas de 3 x 3 de la cuadrícula debe contener los dígitos del 1 al 9 sin repeticiones.

Devuelve `true` si el tablero es válido, de lo contrario devuelve `false`.

**Nota:** El tablero no necesita estar completo ni ser resoluble para ser válido.

## Ejemplo 1

Input:

```
board = [
 ["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]
]
```

Output: `true`

## Ejemplo 2

Input:

```
board = [
 ["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","1",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]
]
```

Output: `false`

Explicación: Hay dos '1' en la subcaja superior izquierda de 3x3.

## Restricciones

- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` es un dígito del '1' al '9' o '.'
