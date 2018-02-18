from Population import Population
from Board import SudokuBoard
import time, numpy as np

initial_time = time.time()
pop = Population(1000000)
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

final_time = time.time()
print("new population: " + str(len(new_pop)))
print("Old population highest fitness score: " + str(old_pop[0].board_fitness_score()))
print("New population highest fitness score: " + str(new_pop[0].board_fitness_score()))
print("===================")
print("Time to execute: {} s".format(final_time - initial_time))

# a = np.array(np.random.random_integers(1, 10, (9, 9)))
# b = np.array(np.random.random_integers(1, 10, (9, 9)))
# print(a)
# print("=============================")
# print(b)
# a[:3,] = b[:3,]
# print("=============================")
# print(a)
