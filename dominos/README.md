Read scanner and stuff
    q = number of queries                                                                                                    
    n = number of dominos
    m = number of loops

Initialise
    int count #records how many we need to knock over
    Start Array (n+1) #to tell us if is has NO tiles that knock it over
    make Start[0] = true (because is not a real domino)
    S Stack;
    Visited Array (n+1) #to tell us if it has been visited before
    V int = 0 #counter to store if all have been visited
    Children AdjList (n+1) #to tell us what dominos this one will knock over

Loop (m)
    Go through the input and add items to the adjacency list.
    If any item is knocked over change start[item] to false
Add all itmes in Start to S
Loop (while visited != n)
    if S not empty pop = s
        count ++
        visit(s)
    else()
        for i in 1 to end
            if visited[i] == false 
                count++
                visit(i)

Function visit
    if visited[s] = true 
        stop
    else
        update visited[s] to true
        go to Children[s] 
        for child in the Childeren[s]
            visit(child)
