from collections import Counter

# using numpy for easy array operations
import numpy as np

# define the size of the sudoku board
BOARD_SIZE = 9


class SudokuBoard:
    def __init__(self, board_elements=None):
        self.board = board_elements
        self.unique_numbers_set = set(np.arange(1, BOARD_SIZE + 1))

    def generate_board(self):
        # generate a board having numbers from 1 to 9 whose
        # dimension is 9 x 9
        self.board = np.random.random_integers(1, BOARD_SIZE,
                                               (BOARD_SIZE, BOARD_SIZE))

    def set_board(self, board_elements):
        self.board = board_elements

    def board_fitness_score(self):
        fitness_score = 0

        # check rows fitness score
        for row in self.board:
            fitness_score += self.array_fitness_score(row)

        # check cols fitness score
        for col in self.board.T:
            fitness_score += self.array_fitness_score(col)

        # get all of 9 the 3 x 3 cells
        # Hardcoded to select cells due to lack of time

        # 1st to 3rd col, 1st row to 3rd row
        cell_unit_1 = self.board[0:3, 0:3]
        fitness_score += self.array_fitness_score(cell_unit_1)

        # 4th col to 6th col, 1st row to 3rd row
        cell_unit_2 = self.board[0:3, 3:6]
        fitness_score += self.array_fitness_score(cell_unit_2)

        # 6th col to 9th col, 1st row to 3rd row
        cell_unit_3 = self.board[0:3, 6:9]
        fitness_score += self.array_fitness_score(cell_unit_3)

        # 1st to 3rd col, 4th row to 6th row
        cell_unit_4 = self.board[3:6, 0:3]
        fitness_score += self.array_fitness_score(cell_unit_4)

        # 4th col to 6th col, 4th row to 6th row
        cell_unit_5 = self.board[3:6, 3:6]
        fitness_score += self.array_fitness_score(cell_unit_5)

        # 6th col to 9th col, 4th row to 6th row
        cell_unit_6 = self.board[3:6, 6:9]
        fitness_score += self.array_fitness_score(cell_unit_6)

        # 1st to 3rd col, 6th row to 9th row
        cell_unit_7 = self.board[6:9, 0:3]
        fitness_score += self.array_fitness_score(cell_unit_7)

        # 4th col to 6th col, 6th row to 9th row
        cell_unit_8 = self.board[6:9, 3:6]
        fitness_score += self.array_fitness_score(cell_unit_8)

        # 6th col to 9th col, 7th row to 9th row
        cell_unit_9 = self.board[6:9, 6:9]
        fitness_score += self.array_fitness_score(cell_unit_9)

        return fitness_score

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
        # using just the first form to penalize
        for element in count_values.keys():
            if count_values[element] is not 1 and not 0:
                # anything larger than 1, is penalized
                penalty_scores += count_values[element] - 1

        # Penalize for required element missing
        # penalty_scores += len(Counter(self.unique_numbers_set) - count_values)

        # fitness score is the remaining score from the perfect score
        return perfect_score - penalty_scores

    def get_board(self):
        return self.board

    def __str__(self):
        return str(self.board_fitness_score())

    def __eq__(self, other):
        return isinstance(other, SudokuBoard.__class__) and self.board == other.board


