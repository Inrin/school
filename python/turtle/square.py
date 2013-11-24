#!/usr/bin/python
from turtle import *

speed(0)

left(180)

def squareLEFT(l):
    for i in range(4):
        forward(l)
        right(90)
    forward(l)

    left(45)

    if l >=3:
        squareLEFT(l/1.1)

def squareRIGHT(l):
    for i in range(4):
        forward(l)
        right(90)

    right(90)
    forward(l)

    left(45)

    if l >=3:
        squareRIGHT(l/1.1)



squareLEFT(100)
#squareRIGHT(200)
exitonclick()
