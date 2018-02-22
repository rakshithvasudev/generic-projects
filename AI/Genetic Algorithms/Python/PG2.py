import math, copy

from PopulationC import initialize_population, breed_population, mutate_population, sort_population
import time


def get_best_pop(init_pop, bred_pop, mutated_pop):
    return copy.deepcopy(bred_pop)


if __name__ == '__main__':

    time1 = time.time()
    saved_population = {}
    generation_counter = 0

    while True:

        if len(saved_population) == 0:
            saved_population['saved_population'] = initialize_population(5000)
        else:
            starting_population = copy.deepcopy(saved_population['saved_population'])
        starting_population = sort_population(copy.deepcopy(saved_population['saved_population']))
        print("Starting population fitness = {}, size = {}".format(starting_population[0].board_fitness_score(),
                                                                   len(starting_population)))

        bred_population = breed_population(copy.deepcopy(starting_population))
        bred_population = sort_population(copy.deepcopy(bred_population))
        print("Bred population fitness = {}, size = {}".format(bred_population[0].board_fitness_score(),
                                                               len(bred_population)))

        mutated_population = mutate_population(copy.deepcopy(bred_population))
        mutated_population = sort_population(copy.deepcopy(mutated_population))
        print("Mutated population fitness = {}, size = {}".format(mutated_population[0].board_fitness_score(),
                                                                  len(mutated_population)))

        saved_population['saved_population'] = get_best_pop(starting_population, bred_population, mutated_population)

        if starting_population[0].board_fitness_score() > 200:
            break
        print("===============================================")
    time2 = time.time()
    print("Execution took: {}s = {}m ".format(round((time2 - time1), 2), round((time2 - time1) / 60, 2)))
