from Population import Population
from Board import SudokuBoard
import time

initial_time = time.time()
pop = Population(1000000)
pop.initialize_populations()
pop.sort_population()

boards = pop.get_boards()

for board in boards:
    print(board.board_fitness_score())

final_time = time.time()

print("===================")
print("Time to execute: {} s".format(final_time-initial_time))

