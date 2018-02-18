from Board import SudokuBoard


class Population:
    def __init__(self, population_count=100):
        self.population = []
        self.population_count = population_count

    def initialize_populations(self):
        """
        Generate Random Sudoku boards as specified in the population count
        :return: None
        """
        for inc in range(self.population_count):
            generated_board_object = SudokuBoard()
            generated_board_object.generate_board()
            self.population.append(generated_board_object)

    def sort_population(self):
        self.population = sorted(self.population, key=lambda x: x.board_fitness_score(), reverse=True)

    def get_boards(self):
        return self.population
