import math
import random

from Board import SudokuBoard


class Population:
    def __init__(self, population_count=100):
        self.population = []
        self.population_count = population_count
        self.new_population = []

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

    def generate_new_population(self):
        self.breed(0.5, random.randint(1, 9), random.randint(1, 9))

    def breed(self, probability=0.5, row_index=5, col_index=5):
        if row_index > 9 or col_index > 9:
            raise ValueError("Indices can't be larger than board size")

        max_limit = len(self.population)
        stopping_point = int(math.ceil(max_limit / 2))

        # get the parents from the end points and breed them
        for counting_index in range(stopping_point):
            chromosome1 = self.population[counting_index]
            chromosome2 = self.population[(max_limit - 1) - counting_index]
            crossover_result = self.crossover(chromosome1, chromosome2, probability, row_index, col_index)
            self.new_population.append(crossover_result[0])
            self.new_population.append(crossover_result[1])

    def crossover(self, chromosome1, chromosome2, probability, row_index, col_index):
        """
        Performs crossover.
        :param chromosome1: parent 1
        :param chromosome2: parent 2
        :param probability:
        :param row_index:
        :param col_index:
        :return:
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
