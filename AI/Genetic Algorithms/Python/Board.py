# using numpy for easy array operations
import numpy as np


class SudokuBoard:
    def __init__(self):
        self.board_size = 9
        self.generate_board()

    def fitness_val(self):
        return 100

    def generate_board(self):
        # generate a board having numbers from 1 to 9 whose
        # dimension is 9 x 9
        board = np.random.random_integers(1, 9, (9, 9))
        print(board)
