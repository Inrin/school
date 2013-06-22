##############################################################################
##                                 Imports                                  ##
##############################################################################

import GUI
from random import randint

##############################################################################
##                                  Fields                                  ##
##############################################################################

_entry = 0
_credit = 0
_results = [0,0,0]
_canDice = [True,True,True]

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
            _entry = int(GUI.inputChoice.get())
        if credit:
            _credit = int(GUI.labelCredit.cget('text'))
        if results:
            _results = [int(GUI.labelResults[i].cget('text')) for i in range(3)]

    except ValueError:
        GUI.showerror('Convert Error!','Unable to convert input to int')

### BUTTONS BEGIN

def buttonBetClick():
    """Sets users input"""
    getUpdate(results=False)
    if _entry != 0 and _entry not in range(1,7):
        GUI.showerror('Logic Error', 'Please insert a value between 1~6')
    elif _entry not in range(1,7): 
        return
    else:
        GUI.labelCredit.config(text=str((_credit -1)))
        GUI.buttonBet.config(state='disabled')
        GUI.buttonDice.config(state='normal')
        for i in range(len(GUI.radiobuttons)):
            GUI.radiobuttons[i].config(state='disabled') 

def buttonPayClick():
    """Give it to me"""
    ## Use fields
    global _credit

    getUpdate()
    _credit += _results.count(_entry)
    GUI.labelCredit.config(text=_credit)
    GUI.buttonBet.config(state='normal')
    GUI.buttonPay.config(state='disabled')
    for i in range(len(GUI.radiobuttons)):
        GUI.radiobuttons[i].config(state='normal') 

def buttonDiceClick():
    """alea iacta est"""
    #use fields
    global _results

    getUpdate(entry=False, credit=False)
    rand = [randint(1,6) for x in range(len(_results))]
    for i in range(len(_results)):
        GUI.labelResults[i].config(text=str(rand[i])) 
        GUI.labelResults[i].config(image=GUI.imageDice[rand[i]]) 
    GUI.buttonDice.config(state='disabled')
    GUI.buttonPay.config(state='normal')

def labelDieDoubleClick(event):
    """alea iacta est"""
    #use fields
    global _results
    global _canDice

    if True not in _canDice:
            for i in range(len(_canDice)):
               _canDice[i]=True

    GUI.buttonDice.config(state='disabled')

    getUpdate(entry=False, credit=False)
    rand = randint(1,6) 
    if True in _canDice: 
        if event.widget is GUI.labelResults[0] and _canDice[0]:
            event.widget.config(text=str(rand)) 
            event.widget.config(image=GUI.imageDice[rand]) 
            _canDice[0] = False
        elif event.widget is GUI.labelResults[1] and _canDice[1]:
            event.widget.config(text=str(rand)) 
            event.widget.config(image=GUI.imageDice[rand]) 
            _canDice[1] = False
        elif event.widget is GUI.labelResults[2] and _canDice[2]:
            event.widget.config(text=str(rand)) 
            event.widget.config(image=GUI.imageDice[rand]) 
            _canDice[2] = False

        if _canDice.count(False) == 3: 
            GUI.buttonDice.config(state='disabled')
            GUI.buttonPay.config(state='normal')

### BUTTONS END
