import re, string


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


if __name__ == '__main__':

    file = open("dataset/bible.txt", "r").read()
    tokens = tokenize(file)

    converted_categories = []

    for char in tokens:
        category = categorized_outcome(char)
        converted_categories.append(category)

    print("".join(converted_categories))
