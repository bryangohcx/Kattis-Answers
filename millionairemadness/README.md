Millionaire madness requires us to find the path that requires the shortest ladder to move from one end of the vault to the other.

For my implemnentation, intend to use a UFDS structure to maintain the groupings of all the nodes
    once we find that the start and end node are in the same group we can break the loop and return the current required ladder height.

Many believe an MST is required but i will simply use a priority queue with all the weights of the edges