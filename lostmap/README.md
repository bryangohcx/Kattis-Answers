Somewhere in a mountainous region of the world is a collection of 
 villages. Connecting these villages to one another is a series of roads, always running directly between two villages and allowing travel in both directions. Due to the treacherous landscape, building these roads is expensive, so the minimum number of roads have been constructed such that each village can reach every other village via a sequence of roads.
Trade between these villages is very important, since not every village has access to the same supply of natural resources. Many villages produce the same resource, however, so it is useful for villages to know their relative distance to other villages so that they can choose trading partners to minimize overall trading costs. Note that the distance between two villages 
 and 
 is the sum of the lengths of the individual roads on the shortest path that connects 
 and 
.

A project has been underway to compute the distance between every pair of villages. This information has been incorporated in a table, along with a map that shows the layout of villages and roads that run between them. You have been assigned the task of distributing the table and map to all the villages for the betterment of the regional economy.

Unfortunately, not long after you were given this task, a gust of wind blew the map right out of your hand and into the countryside. Despite your best efforts of searching for it, you have been unable to locate it. You know that you could visit all the villages to reconstruct the map and THEN start distributing the map and table, but this will take twice as long as the original task and the villages will be very displeased with you. You wonder, maybe it’s possible to reconstruct the map given only the table?

Input
The first line of input will contain the integer 
 (
), the number of villages in this region. The next 
 lines will contain 
 integers each. The 
 integer of the 
 line is the distance from village 
 to village 
. All distances are greater than zero unless 
, less than 
, and it is guaranteed that the distance from village 
 to village 
 is the same as the distance from village 
 to village 
.

Output
For each test case, output 
 lines with two integers 
 and 
 on each line, indicating that there is a road connecting villages 
 and 
 in this region. Assume the villages are numbered from 
 to 
. Any solution that outputs the original set of roads will be accepted.