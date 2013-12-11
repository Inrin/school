#!/usr/bin/python
from random import randint
from time import clock

def sort(unsorted_list) -> "sorted list":
    """ Sort with selection """

    sorted_list = []
    while unsorted_list:
        tmp = unsorted_list[0]
        for item in unsorted_list:
            if tmp > item:
                tmp = item
        sorted_list.append(tmp)
        unsorted_list.remove(tmp)

    return sorted_list

def sortWithLoppCounters(unsorted_list) -> "sorted list":
    """ Sort with selection """

    sorted_list = []
    ## count loops
    whileCounter = 0
    forCounter = 0
    while unsorted_list:
        whileCounter += 1
        tmp = unsorted_list[0]
        for item in unsorted_list:
            forCounter += 1
            if tmp > item:
                tmp = item
        sorted_list.append(tmp)
        unsorted_list.remove(tmp)

    print("\n" + str(whileCounter) + " Weilschleifen durchlaufen")
    print(str(forCounter) + " Forschleifen durchlaufen\n")

    return sorted_list


###############################################################################
##                          Generiere unsortierte Liste                      ##
###############################################################################

unsortierte_list = [randint(0,i) for i in range(100)]
""" Kopiere Liste by Value da sonst by Reference diese löscht """
unsortierte_list2 = unsortierte_list[:]

###############################################################################
##                              Teste Schleifendurchläufe                    ##
###############################################################################

print(sortWithLoppCounters(unsortierte_list))
unsortierte_list = unsortierte_list2[:]

###############################################################################
##                              Teste Zeitaufwand                            ##
###############################################################################
ergebnisse_list = []
durchschnitt_float = 0

for i in range(10000):
    start1 = clock()

    sortierte_list = sort(unsortierte_list)

    stop = (clock() - start1)


    ergebnisse_list.append(stop)
    unsortierte_list = unsortierte_list2[:]

###############################################################################
##                              Berrechne Durchscnitt                        ##
###############################################################################
for i in ergebnisse_list:
    durchschnitt_float += i

durchschnitt_float /= len(ergebnisse_list)
print("\n Durschnitt Zeit: " + str(durchschnitt_float))
