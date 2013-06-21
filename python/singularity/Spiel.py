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

## Use custom theme, yes = 'enabled'; no = 'disabled'
useCustomTheme('disabled')

root = Tk()
root.title(TITLE)
root.geometry(ROOTSIZE)

##############################################################################
##                                 Frames                                   ##
##############################################################################

frameResults = Frame(master=root, bg=BGF)

##############################################################################
##                                Labels                                    ##
##############################################################################

## Label für Titel
labelTitle = Label(master=root, text=TITLE, fg=FGT, bg=BGT,
    font=(FONT, FONTSIZET))

## Label der Bereiche
labelSegment1 = Label(master=root, text=SEGMENTT1, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment2 = Label(master=root, text=SEGMENTT2, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment3 = Label(master=root, text=SEGMENTT3, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))

## Label der Auswertungen
labelCredit = Label(master=root, text='100', fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelResults = [None,None,None]
for i in range(len(labelResults)):
    labelResults[i] = Label(master=frameResults, text='-1', fg=FGL,
            bg=BGL, font=(FONT ,FONTSIZEL))

##############################################################################
##                                Inputs                                    ##
##############################################################################

entryBetInt = Entry(master=root, fg=FGE, bg=BGE, font=(FONT, FONTSIZEE))

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
entryBetInt.grid(row=2, column=1, padx=PADX, pady=PADY)
frameResults.grid(row=2, column=2, padx=PADX, pady=PADY)
buttonBet.grid(row=3, column=0, padx=PADX, pady=PADY)
buttonPay.grid(row=3, column=1, padx=PADX, pady=PADY)
buttonDice.grid(row=3, column=2, padx=PADX, pady=PADY)

## Putting in the frame
[labelResults[i].pack(side='left', fill='both') 
    for i in range(len(labelResults))]

## Resizeable, YES
root.columnconfigure(0, weight=1)
root.columnconfigure(1, weight=1)
root.columnconfigure(2, weight=1)
root.columnconfigure(3, weight=1)
root.rowconfigure(0, weight=1)
root.rowconfigure(1, weight=1)
root.rowconfigure(2, weight=1)
root.rowconfigure(3, weight=1)
