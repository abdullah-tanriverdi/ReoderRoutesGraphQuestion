# Reordering Routes to Make All Paths Lead to City Zero

This Java code aims to reorient roads between cities in such a way that all cities can reach the capital city, which is city 0.

## Problem Statement

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network forms a tree). Last year, the Ministry of Transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.


## Example

Total number of cities: 6

Connections:
- 0 -> 1
- 0 -> 2
- 1 -> 3
- 2 -> 4
- 3 -> 5
- 4 -> 5

In this case, the output will be 4.
