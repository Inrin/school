from serial import *
from time import *

bitTime = 0.6

r = Serial("/dev/pts/2", xonxoff=True)
#r.setRTS(False)
#r.flowControlOut(True)

def recieve():
    """ Get a Bitstream and save it as string"""
    message = ""

    ## Wait for Connectionbit
    #while not r.getCTS():
    while not r.xonxoff:
        sleep(0.0001)

    ## Jump to first Messagebit
    sleep(bitTime * 1.5)

    ## Read the 8-Bit block
    for i in range(8):
        #if getCTS():
        if r.xonxoff:
            message += "1"
            sleep(bitTime)
        #elif not getCTS():
        elif not r.xonxoff:
            message += "0"
            sleep(bitTime)
        else:
            print("Severe Error")
    ## Jump to EOT-Bit
    sleep(bitTime / 2)

    ## Start again
    recieve()

def binToChar(binString):
    return chr(int(binString,2))


while True:
    print(r.xonxoff)
    sleep(0.6)
