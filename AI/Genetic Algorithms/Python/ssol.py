import numpy as np

sudoku_board = np.random.randint(1, 10, (9, 9))
unique_elements = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(sudoku_board)


def is_board_done(board):
    # check rows fitness score
    for row in board:
        if 0 in row:
            return False

    # check cols fitness score
    for col in board.T:
        if 0 in col:
            return False

    # get all of 9 the 3 x 3 cells
    # Hardcoded to select cells due to lack of time

    # 1st to 3rd col, 1st row to 3rd row
    cell_unit_1 = board[0:3, 0:3]
    cell_unit_1 = cell_unit_1.reshape(1, 9)

    # 4th col to 6th col, 1st row to 3rd row
    cell_unit_2 = board[0:3, 3:6]

    # 6th col to 9th col, 1st row to 3rd row
    cell_unit_3 = board[0:3, 6:9]

    # 1st to 3rd col, 4th row to 6th row
    cell_unit_4 = board[3:6, 0:3]

    # 4th col to 6th col, 4th row to 6th row
    cell_unit_5 = board[3:6, 3:6]

    # 6th col to 9th col, 4th row to 6th row
    cell_unit_6 = board[3:6, 6:9]

    # 1st to 3rd col, 6th row to 9th row
    cell_unit_7 = board[6:9, 0:3]

    # 4th col to 6th col, 6th row to 9th row
    cell_unit_8 = board[6:9, 3:6]

    # 6th col to 9th col, 7th row to 9th row
    cell_unit_9 = board[6:9, 6:9]

def check_cell(cell_unit):
    cell_unit = cell_unit.reshape(1,9)