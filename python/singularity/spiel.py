#!/usr/bin/python

##############################################################################
##                               Imports                                    ##
##############################################################################

from tkinter import *

##############################################################################
##                               Constants                                  ##
##############################################################################
TITLE='Chuck-a-Luck'

## Segmenttitel
SEGMENTT1='Konto'
SEGMENTT2='Zahl'
SEGMENTT3='Wurfel' 

## Buttontext
BUTTONBET='Einsatz zahlen'
BUTTONPAY='Gewinn auszahlen'
BUTTONDICE='Würfel werfen'

## Fonts
FONT='Arial'
FONTSIZET=18
FONTSIZEL=16
FONTSIZWB=17

## Label Colors
BGT='gray'
FGT='white'
BGL='gray'
FGL='white'

## Button Colors
BGB='gray'
FGB='white'

##############################################################################
##                                Fields                                    ##
##############################################################################
RESULT=[0,0,0]

##############################################################################
##                                 GUI                                      ##
##############################################################################


##############################################################################
##                               Creation                                   ##
##############################################################################
tkwindow = Tk()
tkwindow.title(TITLE)
tkwindow.geometry('500x500')

##############################################################################
##                                Labels                                    ##
##############################################################################

## Label für Titel
labelTitle = Label(master=tkwindow, text=TITLE, fg=FGT, bg=BGT,
    font=(FONT, FONTSIZET))

## Label der Bereiche
labelSegment1 = Label(master=tkwindow, text=SEGMENTT1, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment2 = Label(master=tkwindow, text=SEGMENTT2, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelSegment3 = Label(master=tkwindow, text=SEGMENTT3, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))

## Label der Auswertungen
labelCredit = Label(master=tkwindow, text=CREDIT, fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelResult1 = Label(master=tkwindow, text=RESULT[0], fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelResult2 = Label(master=tkwindow, text=RESULT[1], fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))
labelResult3 = Label(master=tkwindow, text=RESULT[2], fg=FGL, bg=BGL, 
    font=(FONT,FONTSIZEL))

##############################################################################
##                                Inputs                                    ##
##############################################################################

##############################################################################
##                                Buttons                                   ##
##############################################################################

buttonBet = Button(master=tkwindow, text=BUTTONBET, fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), command=buttonBetClick)
buttonBet = Button(master=tkwindow, text=BUTTONPAY, fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), command=buttonPayClick)
buttonBet = Button(master=tkwindow, text=BUTTONDICE, fg=FGB, bg=BGB, font=(FONT,
    FONTSIZEB), command=buttonDiceClick)

##############################################################################
##                                Layout                                    ##
##############################################################################

## aktiviere Fenster
tkwindow.mainloop()

##############################################################################
##                                 Def's                                    ##
##############################################################################

def buttonBetClick():
    """Bet to win some nice prices"""
    pass

def buttonPayClick():
    """Yes I have won, give Player his money or take it all"""
    pass

def buttonDiceClick():
    """Alea iacta est. Give the results"""
    pass
