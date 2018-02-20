from Board import SudokuBoard

BOARD_SIZE = 9


def initialize_population(population_count=200):
    """
    Generate a sudoku population based on the count
    :param population_count: number of populations to be created
    :return: initialized population
    """
    initialized_population = []
    for number in range(population_count):
        board = SudokuBoard()
        board.generate_board()
        initialized_population.append(board)


def sort_population(population):
    """
    Sorts the entire set of population based on the fitness score
    :param population: population to be sorted
    :return: sorted population
    """
    return sorted(population, key=lambda x: x.board_fitness_score(), reverse=True)
