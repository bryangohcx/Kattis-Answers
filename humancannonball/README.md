Human Canonball can be modelled as a graph problem where starting point ending point and all cannons are vertices which are all linked to one another

this is because there is no reason to make zigzag paths etc to reach the next point and we would only run or shoot towards another cannon or final point

The issue is how we are going to define the weights of the nodes.

    Special case(from starting node A to any cannon is purely running and so we just take distance*speed)
    Canon case 
        run anyway if less than or equal to 30m
        take cannon if more than 30m

Once we create the graph we can use a shortest path algorithm to find the shortest path from A to B
Dikjstras algorithm where we want to minimize the path from A to B

because the answer must be accurate despite using floating point numbers if it is realy necessary after finding the optimal path, we can go back to the path and take cannon routes *2 + running distance/5 and attempth to get a better value.