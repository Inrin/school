##############################################################################
##                                 Imports                                  ##
##############################################################################

import Spiel
from random import randint

##############################################################################
##                                  Fields                                  ##
##############################################################################

_entry = 0
_credit = -1
_results = [0,0,0]

##############################################################################
##                                Definitions                               ##
##############################################################################

def getUpdate(entry=True, credit=True, results=True):
    """get all needed values"""
    ## Use fields
    global _entry
    global _credit
    global _results

    try:
        if entry:
            _entry = int(Spiel.entryBetInt.get())
        if credit:
            _credit = int(Spiel.labelCredit.cget('text'))
        if results:
            _results = [int(Spiel.labelResults[i].cget('text')) for i in range(3)]

    except ValueError:
        Spiel.showerror('Convert Error!','Unable to convert input to int')
        Spiel.entryBetInt.delete(0, Spiel.END)

### BUTTONS BEGIN

def buttonBetClick():
    """Sets users input"""
    getUpdate()
    if _entry != 0 and _entry not in range(1,7):
        Spiel.showerror('Logic Error', 'Please insert a value between 1~6')
    elif _entry not in range(1,7): 
        return
    else:
        Spiel.labelCredit.config(text=str((_credit -1)))
        Spiel.buttonBet.config(state='disabled')
        Spiel.buttonDice.config(state='normal')
        Spiel.entryBetInt.config(state='readonly')

def buttonPayClick():
    """Give it to me"""
    ## Use fields
    global _credit

    getUpdate()
    _credit += _results.count(_entry)
    Spiel.labelCredit.config(text=_credit)
    Spiel.buttonBet.config(state='normal')
    Spiel.buttonPay.config(state='disabled')

def buttonDiceClick():
    """alea iacta est"""
    #use fields
    global _results

    getUpdate()
    rand = [randint(1,6) for x in range(len(_results))]
    [Spiel.labelResults[i].config(text=str(rand[i])) 
        for i in range(len(_results))]
    Spiel.buttonDice.config(state='disabled')
    Spiel.buttonPay.config(state='normal')

### BUTTONS END
