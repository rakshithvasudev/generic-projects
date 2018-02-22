from random import randint
import math

from Board import SudokuBoard

BOARD_SIZE = 9


def initialize_population(population_count=200):
    """
    Generate a sudoku population based on the count.
    :param population_count: number of populations to be created.
    :return: initialized population.
    """
    initialized_population = []
    for number in range(population_count):
        board = SudokuBoard()
        board.generate_board()
        initialized_population.append(board)

    return initialized_population


def sort_population(population):
    """
    Sorts the entire set of population based on the fitness score.
    :param population: population to be sorted.
    :return: sorted population.
    """
    return sorted(population, key=lambda x: x.board_fitness_score(), reverse=True)


def crossover(chromosome1, chromosome2, row_index, col_index):
    """
            Performs crossover.
            :param chromosome1: parent 1
            :param chromosome2: parent 2
            :param row_index: row index where parents needs to be cut off
            :param col_index: col index where parents needs to be cut off
            :return: crossover chromosomes
            """

    # here is where the cols and rows get swapped, thanks to numpy which makes this process
    # painless.
    chromosome1.get_board()[:row_index, :col_index] = chromosome2.get_board()[:row_index, :col_index]
    chromosome2.get_board()[:row_index, :col_index] = chromosome1.get_board()[:row_index, :col_index]
    return [chromosome1, chromosome2]


def breed_population(original_population):
    """
    Performs breeding and crossover over a population
    :param original_population: the parent population from which the cross over happens
    :return: bred population
    """

    bred_population = []
    row_index = randint(1, 9)
    col_index = randint(1, 9)

    if row_index > BOARD_SIZE or col_index > BOARD_SIZE:
        raise ValueError("Indices can't be larger than board size, Breeding failed!")

    max_limit = len(original_population)
    stopping_point = int(math.ceil(max_limit / 2))

    # get the parents from the end points of the original_population and breed them
    for counting_index in range(stopping_point):
        chromosome1 = original_population[counting_index]
        chromosome2 = original_population[(max_limit - 1) - counting_index]
        crossover_result = crossover(chromosome1, chromosome2, row_index, col_index)
        bred_population.append(crossover_result[0])
        bred_population.append(crossover_result[1])

    return bred_population


def mutate_population(mutable_population, probability=0.3):
    """
    Modifies the crossover elements based on the modification probability.
    :param mutable_population: The actual population that needs to be mutated.
    :param probability: probability percentage of the board elements to be modified
    :return: mutated population
    """

    mutated_population = []

    # check out how many elements to modify based on the mutation probability
    elements_mutation_count = int(math.ceil(probability * BOARD_SIZE * BOARD_SIZE))

    for board in mutable_population:
        for inc in range(elements_mutation_count):
            random_row_index = randint(0, BOARD_SIZE - 1)
            random_col_index = randint(0, BOARD_SIZE - 1)
            board.get_board()[random_row_index][random_col_index] = randint(1, BOARD_SIZE)
        mutated_population.append(board)

    return mutated_population
