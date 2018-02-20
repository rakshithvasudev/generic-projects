from Population import Population
from Board import SudokuBoard
import numpy as np
import time

initial_time = time.time()

generations_count = 0
mutated_sample = None
while True:
    if generations_count == 0:
        pop = Population(50)
        pop.initialize_populations()
        pop.sort_original_population()
        old_pop = pop.get_population()

        for new_board in old_pop:
            print(new_board.board_fitness_score())

        print("Original population: " + str(len(old_pop)))
        print("========================")
        print("breeding:....")
        pop.generate_new_population()
        pop.sort_new_population()
        new_pop = pop.get_new_population()

        for new_board in new_pop:
            print(new_board.board_fitness_score())

        print("========================")
        print("mutating:....")
        pop.mutate_new_population()
        pop.sort_mutated_population()
        mut_pop = pop.get_mutated_population()

        for mutated_board in mut_pop:
            print(mutated_board.board_fitness_score())

        print("===================")
        print("Population count: " + str(len(new_pop)))
        print("Old population highest fitness score: " + str(old_pop[0].board_fitness_score()))
        print("Crossover population highest fitness score: " + str(new_pop[0].board_fitness_score()))
        print("Mutated population highest fitness score: " + str(mut_pop[0].board_fitness_score()))
        print("===================")

        mutated_sample = mut_pop

        del mut_pop, new_pop, pop, old_pop, mutated_board
        generations_count += 1

    elif generations_count != 0:
        print("Inside elif")
        new_gen_population = mutated_sample
        population_obj = Population()
        population_obj.set_population(new_gen_population)
        population_obj.breed()
        population_obj.mutate_new_population()
        population_obj.sort_mutated_population()
        mut_pop = population_obj.get_mutated_population()
        print(" New max score:  " + str(mut_pop[0].board_fitness_score()))
        if mut_pop[0].board_fitness_score() > 242:
            print(">200 goal reached")
            print("Inside break")
            print(mut_pop[0].get_board())
            break
        generations_count += 1
        mutated_sample = mut_pop
        print("Current generation count {} ".format(generations_count))
        print("====================================================")
print("goal took {} generations".format(generations_count))
final_time = time.time()
print("Time to execute: {} s".format(final_time - initial_time))

# a = np.array(np.random.random_integers(1, 10, (9, 9)))
# b = np.array(np.random.random_integers(1, 10, (9, 9)))
# print(a)
# print("=============================")
# print(b)
# a[:3,] = b[:3,]
# print("=============================")
# print(a)
