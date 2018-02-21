import math

from PopulationC import initialize_population, generate_bred_population, mutate_new_population, sort_population
import time

time1 = time.time()
saved_mutated_population = None
generation_counter = 0

while True:
    if saved_mutated_population is None:
        initial_population = initialize_population(200)
    else:
        # print("Inside else, len(saved_mutated_population) = {}".format(len(saved_mutated_population)))
        initial_population = saved_mutated_population
    sorted_init_pop = sort_population(initial_population)
    print("First init pop: {}, size = {}".format(sorted_init_pop[0].board_fitness_score(), len(sorted_init_pop)))
    bred_population = generate_bred_population(initial_population)
    sorted_bred_pop = sort_population(bred_population)
    print("bred pop : {}, size = {}".format(sorted_bred_pop[0].board_fitness_score(), len(sorted_init_pop)))
    mutated_pop = mutate_new_population(sorted_bred_pop)
    mutated_pop = sort_population(mutated_pop)

    # if saved_mutated_population is not None:
    #     saved_mutated_population.clear()
    #
    # if saved_mutated_population is not None:
    #     print("Before allocation len(saved_mutated_population) = {}".format(len(saved_mutated_population)))

    # print("mutated_pop before allocation len(mutated_pop) = {}".format(len(mutated_pop)))
    saved_mutated_population = mutated_pop
    # print("mutated_pop after allocation len(mutated_pop) = {}".format(len(mutated_pop)))

    # if saved_mutated_population is not None:
    #     print("After allocation len(saved_mutated_population) = {}".format(len(saved_mutated_population)))

    print("mut pop : {}, size = {}".format(mutated_pop[0].board_fitness_score(), len(mutated_pop)))
    print("Current gen: {}".format(generation_counter))

    if mutated_pop[0].board_fitness_score() > 200:
        break

    # kill 99% of population from the bottom
    # total_count = len(saved_mutated_population)
    # delete_count = math.floor((0.98 * total_count))
    # remaining_index = total_count - delete_count
    # saved_mutated_population = saved_mutated_population[0:remaining_index]
    generation_counter += 1
    print("============================================================")
time2 = time.time()
print("Execution took: {}s = {}m ".format(round((time2 - time1), 2), round((time2 - time1) / 60), 2))
