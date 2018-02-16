# using numpy for easy array operations
import numpy as np


class SudokuBoard:
    def __init__(self):
        self.board = None
        self.board_size = 9
        self.generate_board()

    def generate_board(self):
        # generate a board having numbers from 1 to 9 whose
        # dimension is 9 x 9
        self.board = np.random.random_integers(1, self.board_size,
                                               (self.board_size, self.board_size))

    def fitness_val(self):
        fitness_score = 0
        unique_set = set(np.arange(1, self.board_size + 1))


    def get_board(self):
        return self.board


class Population:
    def __init__(self):
        self.population = []

    def sort_population(self):
        sorted(self.population)


if __name__ == '__main__':
    board = SudokuBoard()
    print(board.get_board())
