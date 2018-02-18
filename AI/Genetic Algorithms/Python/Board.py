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
        return self.board_fitness_score()

    def __eq__(self, other):
        return isinstance(other, SudokuBoard.__class__) and self.board == other.board


if __name__ == '__main__':
    board = SudokuBoard()
    solution_arr1 = np.array([[5, 3, 4, 6, 7, 8, 9, 1, 2],
                              [6, 7, 2, 1, 9, 5, 3, 4, 8],
                              [1, 9, 8, 3, 4, 2, 5, 6, 7],
                              [8, 5, 9, 7, 6, 1, 4, 2, 3],
                              [4, 2, 6, 8, 5, 3, 7, 9, 1],
                              [7, 1, 3, 9, 2, 4, 8, 5, 6],
                              [9, 6, 1, 5, 3, 7, 2, 8, 4],
                              [2, 8, 7, 4, 1, 9, 6, 3, 5],
                              [3, 4, 5, 2, 8, 6, 1, 7, 9]
                              ])

    solution_arr2 = np.array([[7, 3, 5, 6, 1, 4, 8, 9, 2],
                              [8, 4, 2, 9, 7, 3, 5, 6, 1],
                              [9, 6, 1, 2, 8, 5, 3, 7, 4],
                              [2, 8, 6, 3, 4, 9, 1, 5, 7],
                              [4, 1, 3, 8, 5, 7, 9, 2, 6],
                              [5, 7, 9, 1, 2, 6, 4, 3, 8],
                              [1, 5, 7, 4, 9, 2, 6, 8, 3],
                              [6, 9, 4, 7, 3, 8, 2, 1, 5],
                              [3, 2, 8, 5, 6, 1, 7, 4, 9]
                              ])

    solution_arr3 = np.array([[2, 9, 5, 7, 4, 3, 8, 6, 1],
                              [4, 3, 1, 8, 6, 5, 9, 2, 7],
                              [8, 7, 6, 1, 9, 2, 5, 4, 3],
                              [3, 8, 7, 4, 5, 9, 2, 1, 6],
                              [6, 1, 2, 3, 8, 7, 4, 9, 5],
                              [5, 4, 9, 2, 1, 6, 7, 3, 8],
                              [7, 6, 3, 5, 3, 4, 1, 8, 9],
                              [9, 2, 8, 6, 7, 1, 3, 5, 4],
                              [1, 5, 4, 9, 3, 8, 6, 7, 2]
                              ])

    board.set_board(solution_arr1)
    print(board.board_fitness_score())

    board.set_board(solution_arr2)
    print(board.board_fitness_score())

    board.set_board(solution_arr3)
    print(board.board_fitness_score())
