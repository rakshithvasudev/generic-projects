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
    consonants = "[^aeiou^\s ^"+string.punctuation+"]"
    white_space = "[\s]"
    punctuation = "["+string.punctuation+"]"

    if re.match(vowels, lower_case) is not None:
        return 'V'
    elif re.match(consonants, lower_case) is not None:
        return 'C'
    elif re.match(white_space, lower_case) is not None:
        return 'W'
    elif re.match(punctuation, lower_case) is not None:
        return 'P'


if __name__ == '__main__':
    #file = open("dataset/bible.txt", "r").read()

    file = "John’s tire was not 12 inches across anymore!"

    tokens = tokenize(file)

    converted_categories = []

    for char in tokens:
        category = categorized_outcome(char)
        converted_categories.append(category)

    print("".join(converted_categories))
