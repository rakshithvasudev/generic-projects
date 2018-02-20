import math
import random

from Board import SudokuBoard

BOARD_SIZE = 9


class Population:
    def __init__(self, population_count=200):
        self.population = []
        self.population_count = population_count
        self.new_population = []
        self.mutated_population = []

    def initialize_populations(self):
        """
        Generate Random Sudoku boards as specified in the population count
        :return: None
        """
        for inc in range(self.population_count):
            generated_board_object = SudokuBoard()
            generated_board_object.generate_board()
            self.population.append(generated_board_object)

    def sort_original_population(self):
        self.population = sorted(self.population, key=lambda x: x.board_fitness_score(), reverse=True)

    def get_population(self):
        return self.population

    def set_population(self, outside_population):
        self.population = outside_population

    def generate_new_population(self):
        self.breed(random.randint(1, 9), random.randint(1, 9))

    def breed(self, row_index=5, col_index=5):
        if row_index > BOARD_SIZE or col_index > BOARD_SIZE:
            raise ValueError("Indices can't be larger than board size")

        max_limit = len(self.population)
        stopping_point = int(math.ceil(max_limit / 2))

        # get the parents from the end points and breed them
        for counting_index in range(stopping_point):
            chromosome1 = self.population[counting_index]
            chromosome2 = self.population[(max_limit - 1) - counting_index]
            crossover_result = self.crossover(chromosome1, chromosome2, row_index, col_index)
            self.new_population.append(crossover_result[0])
            self.new_population.append(crossover_result[1])

    def crossover(self, chromosome1, chromosome2, row_index, col_index):
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

    def sort_new_population(self):
        self.new_population = sorted(self.new_population, key=lambda x: x.board_fitness_score(), reverse=True)

    def get_new_population(self):
        return self.new_population

    def mutate_new_population(self, probability=0.3):
        """
        Modifies the crossover elements based on the modification probability
        :param probability: probability percentage of the board elements to be modified
        :return: NONE
        """

        # check out how many elements to modify based on the mutation probability
        elements_mutation_count = int(math.ceil(probability * BOARD_SIZE * BOARD_SIZE))

        for board in self.new_population:
            for inc in range(elements_mutation_count):
                random_row_index = random.randint(0, BOARD_SIZE - 1)
                random_col_index = random.randint(0, BOARD_SIZE - 1)
                board.get_board()[random_row_index][random_col_index] = random.randint(1, BOARD_SIZE)
                self.mutated_population.append(board)

    def sort_mutated_population(self):
        self.mutated_population = sorted(self.mutated_population, key=lambda x: x.board_fitness_score(), reverse=True)

    def get_mutated_population(self):
        return self.mutated_population
