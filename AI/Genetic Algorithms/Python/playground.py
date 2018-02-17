import numpy as np
from collections import Counter

# standard = Counter(np.arange(1,10))
# junk = Counter([1,1,2,3,4,5,6,7,8])
#
# print(junk)

board = np.random.random_integers(1, 10, (9, 9))
print(board)
print("=========================================")
# 1st to 3rd col, 1st row to 3rd row
cell_unit_1 = board[0:3, 0:3]
print(cell_unit_1)
# 4th col to 6th col, 1st row to 3rd row
cell_unit_2 = board[0:3, 3:6]
print(cell_unit_2)
# 6th col to 9th col, 1st row to 3rd row
cell_unit_3 = board[0:3, 6:9]
print(cell_unit_3)
# 1st to 3rd col, 4th row to 6th row
cell_unit_4 = board[3:6, 0:3]
print(cell_unit_4)
# 4th col to 6th col, 4th row to 6th row
cell_unit_5 = board[3:6, 3:6]
print(cell_unit_5)
# 6th col to 9th col, 4th row to 6th row
cell_unit_6 = board[3:6, 6:9]
print(cell_unit_6)
# 1st to 3rd col, 6th row to 9th row
cell_unit_7 = board[6:9, 0:3]
print(cell_unit_7)
# 3rd col to 6th col, 6th row to 9th row
cell_unit_8 = board[6:9, 3:6]
print(cell_unit_8)
# 6th col to 9th col, 7th row to 9th row
cell_unit_9 = board[6:9, 6:9]
print(cell_unit_9)