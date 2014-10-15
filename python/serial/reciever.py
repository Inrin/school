from serial import *
from time import *

bitTime = 0.6

r = Serial("com1")
r.setRTS(False)

def recieve():
    """ Get a Bitstream and save it as string"""
    message = ""

    ## Wait for Connectionbit
    while not r.getCTS():
        sleep(0.0001)

    ## Jump to first Messagebit
    sleep(bitTime * 1.5)

    ## Read the 8-Bit block
    for i in range(8):
        if getCTS():
            message += "1"
            sleep(bitTime)
        elif not getCTS():
            message += "0"
            sleep(bitTime)
        else:
            print("Severe Error recieving")
    ## Jump to EOT-Bit
    sleep(bitTime / 2)

    ## Start again
    recieve()

def binToChar(binString):
    return chr(int(binString,2))
