#!/usr/bin/python

def printDiagramm(n):
    """Prints diagram of biebers way"""
    friends = []
    sign = '<'
    for i in range(n):
        friends.append(97+i) # Char 97 = 'a'

    for i in range(0, n-1, 2):
        print(chr(friends[i]), " ", chr(friends[i+1]), "    ", end="")

    if n%2 != 0:
        print(chr(friends[n-1]), end="")

    print()


    for i in range(0, n-1, 2):
        print("-- --     ", end="")

    if n%2 != 0:
        print("-- --", end="")

    print()

def whichFriendToVisit(n, d):
    if (d > n):
        d %= n

printDiagramm(7)
