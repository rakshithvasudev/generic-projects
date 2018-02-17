# using numpy for easy array operations
from collections import Counter

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
        unique_numbers_set = set(np.arange(1, self.board_size + 1))

        # check rows
        for row in self.board:



    def array_fitness_score(self,arr):
        """
        This function returns the fitness score for
        a given array.
        :param arr: The array whose fitness score needs to be evaluated.
        :return: fitness score of the current array under consideration.
        """
        current_fitness = 0
        penality_scores = 0

        # reshape to 1 X 9 to get a uniform representation
        reshaped_array = arr.reshape(1,self.board_size)

        # a map of number of elements in the reshaped array
        # example: {1:2,2:0,3:1,.......9:1}
        count_values = Counter(reshaped_array)

        # penalize if not uniquely present & even missing
        # 2 forms of penality:
        # 1) Extra elements(elements that are larger than 1 in count)
        # 2) Required element not present at all (elements whose count is 0)
        for element in count_values.keys():
           if count_values[element] is not 1 and not 0:
               # anything larger than 1, is penalized
               penality_scores += count_values[element]-1




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
