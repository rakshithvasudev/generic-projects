import math

from PopulationC import initialize_population, generate_bred_population, mutate_new_population, sort_population
import time

time1 = time.time()
saved_population = initialize_population(2000)
generation_counter = 0


def get_best_pop(init_pop, bred_pop, mutated_pop):
    return bred_pop


if __name__ == '__main__':

    while True:

        init_pop = sort_population(saved_population)
        print("First init pop: {}, size = {}".format(init_pop[0].board_fitness_score(), len(init_pop)))
        bred_pop = generate_bred_population(init_pop)
        bred_pop = sort_population(bred_pop)
        print("bred pop : {}, size = {}".format(bred_pop[0].board_fitness_score(), len(bred_pop)))
        mutated_pop = mutate_new_population(bred_pop)
        mutated_pop = sort_population(mutated_pop)
        print("mut pop : {}, size = {}".format(mutated_pop[0].board_fitness_score(), len(mutated_pop)))
        print("Current gen: {}".format(generation_counter))

        if saved_population[0].board_fitness_score() > 240:
            break

        # kill 50% of population from the bottom
        # total_count = len(saved_mutated_population)
        # delete_count = math.floor((0.50 * total_count))
        # remaining_index = total_count - delete_count
        # saved_mutated_population = saved_mutated_population[0:remaining_index]

        saved_population = bred_pop
        generation_counter += 1
        print("============================================================")
    time2 = time.time()
    print("Execution took: {}s = {}m ".format(round((time2 - time1), 2), round((time2 - time1) / 60), 2))
