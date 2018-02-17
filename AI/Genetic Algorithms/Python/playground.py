import numpy as np
from collections import Counter

# standard = Counter(np.arange(1,10))
# junk = Counter([1,1,2,3,4,5,6,7,8])
#
# print(junk)

board = np.random.random_integers(1, 10, (9, 9))
print(board)
print(board[6:9,6:9])