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


def convert_to_probabilities(map_with_words):
    """
    Converts the given character map to probabilities of occurrences, which
    serves as the transition probabilities.
    :param map_with_words: input map which contains words.
    :return: map with transition probabilities sorted in alphabetical order.
    """
    probabilty_map = {}

    for key in map_with_words.keys():
        probabilty_map[key] = sorted(Counter(map_with_words[key]).items())

    return probabilty_map
def check_morkov(sequence):
    """
    Checks if the given input is a first order markov model using the rule
    P(Xi|Xi-1, Xi-2) = P(Xi|Xi-1)?
    :param sequence: input characters to check
    :return: True if they satisfies the rule.
    """

    first_order_map = collect_words(sequence, 1)
    #second_order_map = collect_words(sequence, 2)

    first_order_map = convert_to_probabilities(first_order_map)
    #second_order_map = convert_to_probabilities(second_order_map)

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
