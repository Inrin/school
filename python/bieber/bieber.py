#!/usr/bin/python

def printDiagramm(n):
    """Prints diagram of biebers way"""
    friends = []
    sign = '<'
    for i in range(n):
        friends.append(97+i) # CHar 97 = 'a'

    i=0
    while(i < n-1):
        print(chr(friends[i]), "   ",chr(friends[i+1]), "     ", end="")
        i += 2
    print()

def whichFriendToVisit(n, d):
    if (d > n):
        d %=n

printDiagramm(4)
