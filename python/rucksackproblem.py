#!/usr/bin/python
from random import randint

gegenstaende = [(3.5, 375), (2.5, 300), (2.0, 100), (3.0, 225), (1.0, 50),
               (1.75, 125), (0.75, 75), (3.0, 275), (2.5, 150), (2.25, 50)]

def attribs(komb, weight=True, value=True):

    while len(komb) < len(gegenstaende):
        komb = "0" + komb

    if weight:
        gewicht = 0
        for s in range (len(gegenstaende)):
            gewicht += int(komb[s]) * gegenstaende[s][0]
    if value:
        wert = 0
        for p in range (len(gegenstaende)):
            wert += int(komb[p]) * gegenstaende[p][1]

    if weight and value:
        return [gewicht, wert]
    elif weight and not value:
        return gewicht
    elif not weight and value:
        return wert

def crossing(candidates):
    splitter = randint(0, len(candidates[0]))
    child1 = candidates[0][0:splitter]
    child1 += candidates[1][splitter:len(candidates[1])]

    child2 = candidates[1][0:splitter]
    child2 += candidates[0][splitter:len(candidates[0])]

    return [child1, child2]

def selection(population, maxWeight):
    quantity = len(population)-1

    parents = [population[randint(0, quantity)] for x in range(2)]

    weight1 = attribs(parents[0], weight=True, value=False);
    weight2 = attribs(parents[1], weight=True, value=False);

    if weight1 and weight2 > maxWeight:
        del parents[:]
    elif weight1 > maxWeight:
        del parents[0]
    elif weight2 > maxWeight:
        del parents[1]

    return parents

def cycle(startpopulation):
    pass

def mutate():
    pass

"""
crossing(["0000","1111"])

print(attribs("1011110010", False))
print(attribs("0000110010", True, False))
print(attribs("1011010111", value=False ))
print(attribs("1000010010", value=True, weight=True))
print(attribs("1010010010", value=False, weight=False))
print(attribs("1011110111"))
print(attribs("1011110010"))
print(attribs("1010111000"))
"""
