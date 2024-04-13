store the input as a matrix O(MN)

go through the matrix > v O(MN)
if it is a land mass add 1 to the island counter
look at the 4 corners around each land mass if they exist(within the frame) O(1)
- ? -
? x ?
- ? -
if it is a cloud update it to a land mass