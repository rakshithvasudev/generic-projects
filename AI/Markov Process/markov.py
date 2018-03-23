import re
import string
from collections import Counter


def tokenize(text_content):
    """
    Converts an entire text corpus into tokens of characters
    :param text_content: incoming text
    :return: character by character element in a list
    """

    return list(text_content)


def categorized_outcome(char_content):
    """
    Returns the category to which the character belongs to
    :param char_content: char input to check
    :return: category
    """

    lower_case = char_content.lower()

    vowels = "[aeiou]"
    consonants = "[^aeiou]"
    white_space = "[\s]"
    punctuation = "[" + string.punctuation + "\d" + "]"

    decision = None
    if re.match(vowels, lower_case) is not None:
        decision = 'V'
    if re.match(consonants, lower_case) is not None:
        decision = 'C'
    if re.match(white_space, lower_case) is not None:
        decision = 'W'
    if re.match(punctuation, lower_case) is not None:
        decision = 'P'
    return decision


def collect_words(sequence, order):
    """
    Collects the distribution of words in a Hashmap/Dictionary which later can
    be used to analyze the distribution of probabilities.
    :param sequence: Input sequence of words from the text corpus.
    :param order: Describes the number of previous states the current outcome is dependent on.
    :return: the dictionary of mappings counted based on the order of dependency count.
    """
    char_map = {}

    # iterate through the sequence(as long as the characters support the ordering)
    for counter in range(order, len(sequence) - order + 1):

        current_char = sequence[counter]

        # create an empty list to add all the characters that occurred previously
        # from the current character based on the order
        previous_chars = []

        for in_counter in range(counter + 1 - order, counter + 1):
            previous_chars.append(sequence[in_counter - 1])

        if current_char not in char_map:
            char_map[current_char] = previous_chars
        else:
            char_map[current_char] += previous_chars

        # proceed counting in accordance the order.
        counter += order
    return char_map


def sort_char_map(map_of_chars):
    """
    Sorts the counts of characters.
    :param map_of_chars: map to be sorted.
    :return: sorted version of input based on the items.
    """
    sorted_map = {}

    # sort the counts
    for key in map_of_chars.keys():
        sorted_map[key] = sorted(Counter(map_of_chars[key]).items())
    return sorted_map


def unpack_sorted_map(sorted_map):
    """
    Unpacks the sorted tuple
    :param sorted_map: map whose tuple keys need to be removed.
    :return: plain map with just keys and sorted values according to counts of [c,p,v,w]
    """
    unpacked_sorted_map = {}

    # unpack the tuple formed by sort and assign plain values
    for key in sorted_map.keys():
        counts = []
        for tuple_counter in range(len(sorted_map[key])):
            counts.append(sorted_map[key][tuple_counter][1])
        unpacked_sorted_map[key] = counts

    return unpacked_sorted_map


def convert_to_probabilities(map_with_chars):
    """
    Converts the given character map to probabilities of occurrences, which
    serves as the transition probabilities.
    :param map_with_chars: input map which contains words.
    :return: map with transition probabilities sorted in alphabetical order.
    example : {'C': [0.3013, 0.001, 0.4185, 0.2791], 'V': [0.7081, 0.0, 0.1043, 0.1875],
    'W': [0.5413, 0.1823, 0.2447, 0.0317], 'P': [0.3898, 0.3984, 0.0915, 0.1203]}
    where the values inside the list are representatives of \CPVW\ probabilities
    """
    sorted_map = sort_char_map(map_with_chars)
    unpacked_sorted_map = unpack_sorted_map(sorted_map)
    probabilites_map = {}

    # convert into normalized probabilities
    for key in unpacked_sorted_map.keys():

        total = sum(unpacked_sorted_map[key])
        probabilities = []

        for element in unpacked_sorted_map[key]:
            probabilities.append(round(element / total, 4))

        probabilites_map[key] = probabilities

    return probabilites_map


def check_morkov(sequence):
    """
    Checks if the given input is a first order markov model using the rule
    P(Xi|Xi-1, Xi-2) = P(Xi|Xi-1)?
    :param sequence: input characters to check
    :return: True if they satisfies the rule.
    """

    first_order_map = collect_words(sequence, 1)
    # second_order_map = collect_words(sequence, 2)

    first_order_map = convert_to_probabilities(first_order_map)
    # second_order_map = convert_to_probabilities(second_order_map)

    print(first_order_map)


if __name__ == '__main__':

    file1 = open("dataset/bible.txt", "r").read()
    tokens = tokenize(file1)

    converted_categories = []

    for char in tokens:
        category = categorized_outcome(char)
        converted_categories.append(category)

    corpus1 = "".join(converted_categories)

    check_morkov(corpus1)
