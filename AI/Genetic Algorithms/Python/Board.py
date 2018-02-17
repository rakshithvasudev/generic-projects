# using numpy for easy array operations
from collections import Counter

import numpy as np

BOARD_SIZE = 9


class SudokuBoard:
    def __init__(self):
        self.board = None
        self.generate_board()
        self.unique_numbers_set = set(np.arange(1, BOARD_SIZE + 1))

    def generate_board(self):
        # generate a board having numbers from 1 to 9 whose
        # dimension is 9 x 9
        self.board = np.random.random_integers(1, BOARD_SIZE,
                                               (BOARD_SIZE, BOARD_SIZE))

    # def fitness_val(self):
    #     fitness_score = 0
    #
    #
    #     # check rows
    #     for row in self.board:



    def array_fitness_score(self, arr):
        """
        This function returns the fitness score for
        a given array.
        :param arr: The array whose fitness score needs to be evaluated.
        :return: fitness score of the current array under consideration.
        """

        perfect_score = BOARD_SIZE
        penalty_scores = 0

        # reshape to 1 X 9 to get a uniform representation
        reshaped_array = arr.reshape(1, BOARD_SIZE)

        # convert to a regular list
        reshaped_array = reshaped_array.flatten()

        # a map of number of elements in the reshaped array
        # example: {1:2,2:0,3:1,.......9:1}
        count_values = Counter(tuple(reshaped_array))

        # penalize if not uniquely present & even missing
        # 2 forms of penalty:
        # 1) Extra elements(elements that are larger than 1 in count)
        # 2) Required element not present at all (elements whose count is 0)
        for element in count_values.keys():
            if count_values[element] is not 1 and not 0:
                # anything larger than 1, is penalized
                penalty_scores += count_values[element] - 1

        # Penalize for required element missing
        penalty_scores += len(Counter(self.unique_numbers_set) - count_values)

        return perfect_score - penalty_scores

    def get_board(self):
        return self.board




class Population:
    def __init__(self):
        self.population = []

    def sort_population(self):
        sorted(self.population)


if __name__ == '__main__':
    board = SudokuBoard()
    fake_arr = np.array([[1, 2, 3],
                         [4, 5, 5],
                         [6, 7, 8]])

    print(board.array_fitness_score(fake_arr))
