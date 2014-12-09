from serial import *
from time import *

bitTime = 0.6

s = Serial('com1')
s.setRTS(False)

def sendChar(char):
    """ Send a Char via serial line """
    ## Send Startbit
    s.setRTS(True)

    ## Char -> Int -> Bit
    ## !Voltage = 0 Voltage = 1
    for i in bin(ord(char))[2:].zfill(8):
        print(i)
        if i == "1":
            s.setRTS(True)
            sleep(1)
        elif i == "0":
            s.setRTS(False)
            sleep(1)
        else:
            print("Error sending")

def sendString(string):
    """ Send an Char-Array """
    for i in string:
        sendChar(i)

sendChar("A")
#sendString("HAHA")
