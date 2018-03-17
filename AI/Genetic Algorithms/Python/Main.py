import copy
import time
from Genetic_Algo import initialize_population, breed_population, mutate_population, sort_population


def get_best_pop(init_pop, bred_pop, mutated_pop):
    """
    Selects the best population amongst all the population in a given generation.
    This reduces the steps to converge to a solution.
    :param init_pop: The starting population of the generation.
    :param bred_pop: The bred population of the generation.
    :param mutated_pop: The Mutated population of the generation.
    :return: The best population of all.
    """
    actual_pops = [init_pop, bred_pop, mutated_pop]
    representatives = [init_pop[0].board_fitness_score(), bred_pop[0].board_fitness_score(),
                       mutated_pop[0].board_fitness_score()]
    pop_picked = max(representatives)
    index_picked = representatives.index(pop_picked)
    return actual_pops[index_picked]


if __name__ == '__main__':

    # initial time.
    time1 = time.time()

    # contains the continual generations.
    saved_population = {}

    # keeps the track of the current generation.
    generation_counter = 0

    while True:

        # if there is no population then initialize, if already initialized
        # then then use the best of the population in the generation.
        if len(saved_population) == 0:
            saved_population['saved_population'] = initialize_population(50000)
        else:
            starting_population = copy.deepcopy(saved_population['saved_population'])
        starting_population = sort_population(copy.deepcopy(saved_population['saved_population']))
        print("Starting population fitness = {}, size = {}".format(starting_population[0].board_fitness_score(),
                                                                   len(starting_population)))

        # breed the population from the starting_population
        # deep copy is required because the list gets changed during the run.
        bred_population = breed_population(copy.deepcopy(starting_population))
        bred_population = sort_population(copy.deepcopy(bred_population))
        print("Bred population fitness = {}, size = {}".format(bred_population[0].board_fitness_score(),
                                                               len(bred_population)))

        # mutate the population from the breed_population
        # deep copy is required because the list gets changed during the run.
        mutated_population = mutate_population(copy.deepcopy(bred_population))
        mutated_population = sort_population(copy.deepcopy(mutated_population))
        print("Mutated population fitness = {}, size = {}".format(mutated_population[0].board_fitness_score(),
                                                                  len(mutated_population)))

        # get the best population with the highest fitness score for the current generation.
        saved_population['saved_population'] = get_best_pop(starting_population,
                                                            bred_population, mutated_population)

        # break if the perfect score has reached
        if len(saved_population) != 0 and saved_population['saved_population'][0].board_fitness_score() == 243:
            # print the solution
            print("Solution:")
            print(saved_population['saved_population'][0].get_board())
            break

        generation_counter += 1
        print("Current Generation : {}".format(generation_counter))
        print("===============================================")

    # final time to execute
    time2 = time.time()
    print("Execution took: {}s = {}m ".format(round((time2 - time1), 2), round((time2 - time1) / 60, 2)))
