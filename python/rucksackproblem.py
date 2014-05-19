#!/usr/bin/python
from random import randint
from random import shuffle

gegenstaende = [(3.5, 375), (2.5, 300), (2.0, 100), (3.0, 225), (1.0, 50),
               (1.75, 125), (0.75, 75), (3.0, 275), (2.5, 150), (2.25, 50)]

population = [
"1011110010",
"0000110010",
"1011010111",
"1000010010",
"1010010010",
"1011110111",
"1011110010",
"1010111000"
]

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

def crossing(candidates, mutationRate):
    splitter = randint(0, len(candidates[0]))
    child1 = candidates[0][0:splitter]
    child1 += candidates[1][splitter:len(candidates[1])]

    child2 = candidates[1][0:splitter]
    child2 += candidates[0][splitter:len(candidates[0])]

    rand = randint(0, 100)

    if rand <= mutationRate:
        mutate(child1)
        mutate(child2)

    return [child1, child2]

def selection(population, maxWeight):
    quantity = len(population)-1

    parents = []
    for x in range(4):
        rand = randint(0, quantity)
        parents.append(population[rand])

    for p in parents:
        if attribs(p, weight=True, value=False) > maxWeight or 0:
            parents.remove(p)

    while len(parents) != 2:
        parentsAndDensity = [[attribs(p, weight=False) / attribs(p, value=False), p] for p in parents]
        parentsAndDensity.sort()
        parents.remove(parentsAndDensity[0][1])
        del parentsAndDensity[0]

    return parents

def cycle(startPopulation, maxWeight, howLong):
    for i in range(howLong):
        newPopulation = []
        for j in range(4):
            descendants = crossing(selection(startPopulation, maxWeight), 100)
            newPopulation += [c for c in descendants]
        startPopulation = newPopulation
        print(startPopulation)
    return startPopulation

def mutate(individual):
    rand = randint(0, len(individual)-1)
    individualLocal = [int(x) for x in individual]

    if individualLocal[rand] == 0:
        individualLocal[rand] = 1
    else:
        individualLocal[rand] = 0

    individual = [str(y) for y in individualLocal]


def createBagpack(itemsCount):
    backpack = ""
    for i in range(itemsCount):
        if randint(0,1) == 1:
            backpack += '1'
        else:
            backpack += '0'
    return backpack

def createPopulation(howManyBacks, itemsCount):
    population = []
    for i in range(howManyBacks):
        population.append(createBagpack(itemsCount))
    return population

print(cycle(createPopulation(1000, 8), 15, 100))
