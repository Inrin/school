##############################################################################
##                                 Imports                                  ##
##############################################################################

import GUI
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
            _entry = int(GUI.entryBetInt.get())
        if credit:
            _credit = int(GUI.labelCredit.cget('text'))
        if results:
            _results = [int(GUI.labelResults[i].cget('text')) for i in range(3)]

    except ValueError:
        GUI.showerror('Convert Error!','Unable to convert input to int')
        GUI.entryBetInt.delete(0, GUI.END)

### BUTTONS BEGIN

def buttonBetClick():
    """Sets users input"""
    getUpdate()
    if _entry != 0 and _entry not in range(1,7):
        GUI.showerror('Logic Error', 'Please insert a value between 1~6')
    elif _entry not in range(1,7): 
        return
    else:
        GUI.labelCredit.config(text=str((_credit -1)))
        GUI.buttonBet.config(state='disabled')
        GUI.buttonDice.config(state='normal')
        GUI.entryBetInt.config(state='readonly')

def buttonPayClick():
    """Give it to me"""
    ## Use fields
    global _credit

    getUpdate()
    _credit += _results.count(_entry)
    GUI.labelCredit.config(text=_credit)
    GUI.buttonBet.config(state='normal')
    GUI.buttonPay.config(state='disabled')
    GUI.entryBetInt.config(state='normal')

def buttonDiceClick():
    """alea iacta est"""
    #use fields
    global _results

    getUpdate()
    rand = [randint(1,6) for x in range(len(_results))]
    [GUI.labelResults[i].config(text=str(rand[i])) 
        for i in range(len(_results))]
    GUI.buttonDice.config(state='disabled')
    GUI.buttonPay.config(state='normal')

### BUTTONS END
