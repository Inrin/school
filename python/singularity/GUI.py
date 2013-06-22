##############################################################################
##                               Imports                                    ##
##############################################################################

from tkinter import *
from tkinter.messagebox import showerror
import Engine
from config import *

##############################################################################
##                              GUI ~Creation                               ##
##############################################################################

root = Tk()
root.title(TITLE)
root.geometry(ROOTSIZE)

##############################################################################
##                                 Frames                                   ##
##############################################################################

frameResults = Frame(master=root, bg=BGF)
frameInputs = Frame(master=root, bg=BGF)

##############################################################################
##                                Labels                                    ##
##############################################################################

## Label of title
labelTitle = Label(master=root, text=TITLE, fg=FGT, bg=BGT,
    font=(FONT, FONTSIZET))

## Label of segments
labelSegment1 = Label(master=root, text=SEGMENTT1, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment2 = Label(master=root, text=SEGMENTT2, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment3 = Label(master=root, text=SEGMENTT3, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))

## Label of evaluations
labelCredit = Label(master=root, text='100', fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelResults = []
for i in range(3):
    labelResults.append(
        Label(master=frameResults, text='-1', fg=FGL,
            bg=BGL, font=(FONT ,FONTSIZEL))
    )

##############################################################################
##                                Inputs                                    ##
##############################################################################

## Controlvar for users choice
inputChoice = IntVar()

## Radiobuttons for users choice
radiobuttons = []
for i in range(1,7):
    radiobuttons.append(
        Radiobutton(master=frameInputs, text=str(i), indicatoron=0, 
            bg=BGR, fg=FGR, font=FONT,
            value=i, variable=inputChoice)
    )

radiobuttons[1].select()

##############################################################################
##                                Buttons                                   ##
##############################################################################

buttonBet = Button(master=root, text=BUTTONBET,fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), command=lambda: Engine.buttonBetClick())
buttonPay = Button(master=root, text=BUTTONPAY, fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), state='disabled', command=lambda: Engine.buttonPayClick())
buttonDice = Button(master=root, text=BUTTONDICE, fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), state='disabled', command=lambda: Engine.buttonDiceClick())


##############################################################################
##                                Layout                                    ##
##############################################################################

## Putting in the grid
labelTitle.grid(row=0, column=0, columnspan=3, padx=PADX, pady=PADY)
labelSegment1.grid(row=1, column=0, padx=PADX, pady=PADY)
labelSegment2.grid(row=1, column=1, padx=PADX, pady=PADY)
labelSegment3.grid(row=1, column=2, padx=PADX, pady=PADY)
labelCredit.grid(row=2, column=0, padx=PADX, pady=PADY)
frameInputs.grid(row=2, column=1, padx=PADX, pady=PADY)
frameResults.grid(row=2, column=2, padx=PADX, pady=PADY)
buttonBet.grid(row=3, column=0, padx=PADX, pady=PADY)
buttonPay.grid(row=3, column=1, padx=PADX, pady=PADY)
buttonDice.grid(row=3, column=2, padx=PADX, pady=PADY)

### Putting in the frames ###
## Labelresults
for i in range(len(labelResults)):
    labelResults[i].pack(side='left', fill='both') 

## Radiobuttons first row
for i in range(len(radiobuttons)//2):
    radiobuttons[i].grid(row=0, column=i, padx=PADX, pady=PADY)

## Radiobuttons second row
for i in range(((len(radiobuttons)//2)), (len(radiobuttons))):
    radiobuttons[i].grid(row=1, column=i-(len(radiobuttons))//2, padx=PADX, pady=PADY)

## Resizeable, YES
root.columnconfigure(0, weight=1)
root.columnconfigure(1, weight=1)
root.columnconfigure(2, weight=1)
root.columnconfigure(3, weight=1)
root.rowconfigure(0, weight=1)
root.rowconfigure(1, weight=1)
root.rowconfigure(2, weight=1)
root.rowconfigure(3, weight=1)
