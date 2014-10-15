from serial import *
from time import *

bitTime = 0.6

s = Serial('/dev/pts/2', xonxoff=True)
#s.flowControlOut(True)

def sendChar(char):
    """ Send a Char via serial line """
    ## Send Startbit
#    s.setRTS(True)
    s.flowControlOut(True)

    ## Char -> Int -> Bit
    ## !Voltage = 0 Voltage = 1
    for i in bin(ord(char))[2:].zfill(8):
        print(i)
        if i == "1":
            #s.setRTS(True)
            s.flowControlOut(True)
            sleep(1)
        elif i == "0":
#            s.setRTS(False)
            s.flowControlOut(False)
            sleep(1)
        else:
            print("Error")

def sendString(string):
    """ Send an Char-Array """
    for i in string:
        sendChar(i)

#sendChar("A")
#sendString("HAHA")

while True:

    print("Enabeling FlowOut")
    s.setXON(False)
    sleep(1)
    print("------")
    print("Disabling FlowOut")
    s.setXON(True)
    sleep(1)
    print("------")
