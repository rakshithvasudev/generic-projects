from Population import Population
from Board import SudokuBoard
import numpy as np
import time

initial_time = time.time()
final_time = time.time()
current_gen_mutated_population = None
generation_count = 0

while True:
    population = Population()

    if current_gen_mutated_population is not None:
        population.set_population(current_gen_mutated_population)
    else:
        population.initialize_populations()

    population.sort_original_population()
    population.generate_new_population()
    population.sort_new_population()
    population.mutate_new_population()
    population.sort_mutated_population()
    current_gen_mutated_population = population.get_mutated_population()
    print("===========================================================")
    print("Current generation mutated high score : {}".
          format(current_gen_mutated_population[0].board_fitness_score()))
    print("Current generation count: {}".format(generation_count))

    if current_gen_mutated_population[0].board_fitness_score() > 200:
        break

    generation_count += 1
