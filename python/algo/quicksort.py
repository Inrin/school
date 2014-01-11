#!/usr/bin/python
from random import randint
from time import clock

counter = 0

def quicksort(liste):
    if not liste:
        return []
    else:
        pivotelement = liste[0]
        kleiner = quicksort([x for x in liste[1:] if x < pivotelement])
        groesser= quicksort([x for x in liste[1:] if x>= pivotelement])
        return kleiner + [pivotelement] + groesser

def quicksortCount(liste):
    global counter
    counter = counter + 1
    if not liste:
        return []
    else:
        pivotelement = liste[0]
        kleiner = quicksortCount([x for x in liste[1:] if x < pivotelement])
        groesser= quicksortCount([x for x in liste[1:] if x>= pivotelement])
        return kleiner + [pivotelement] + groesser

def countingTest(countsize):
    global counter
    counter = 0
    print("\n\n=====================================================")
    print(countsize, " sized list")
    templist = []
    for i in range(countsize):
        templist.append(randint(0,countsize))
    print("\n", templist, "\n")
    templist = quicksortCount(templist)
    print("\n", templist, "\n")
    print("Counter: ", counter, "\n")

def timeTest(countsize):
    print("\n\n=====================================================")
    print(countsize, " sized list\n")
    templist = []
    for i in range(countsize):
        templist.append(randint(0,countsize))
    t1 = clock()
    templist = quicksort(templist)
    t2 = clock() - t1
    print(t2)
    return t2



print("Testing recursion depth")
quicksortCount.counter = 0
countingTest(10)
countingTest(100)
countingTest(1000)
countingTest(20000000)

print("Testing time")
listeZeit = []
for i in range(0,1100,100):
    listeZeit.append(timeTest(i))

print("Durschnitt Zeit:")
x=0
for i in listeZeit:
    x+=i
durschnitt = x/len(listeZeit)
print(durschnitt)

