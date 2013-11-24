#!/usr/bin/python
from turtle import *

#speed(0)

def triangle(length):
    forward(length)
    left(120)
    forward(length)
    left(120)
    forward(length)
    left(120)

def triangleUpsideDown(length):
    forward(length)
    right(120)
    forward(length)
    right(120)
    forward(length)
    right(120)

def triforce(l):
    triangle(l)
    left(60)
    forward(l/2)
    right(60)
    triangleUpsideDown(l/2)

def sierpinski(l):
    speed(1)
    triforce(l)

    right(120)
    forward(l/2)
    left(120)
    triforce(l/2)
    right(120)
    forward(l/4)
    left(120)
    forward(l/2)
    triforce(l/2)

    left(60)
    forward(l/4)
    left(60)
    triforce(l/2)
    left(60)
    forward(l/4)
    left(180)

    if l >=50:
        sierpinski(l/2)


sierpinski(200)
exitonclick()
