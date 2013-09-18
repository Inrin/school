#!/usr/bin/python

#------------------------------------------------------------------------------
# Erzeugung des Datenmodell-Objekts
#------------------------------------------------------------------------------

from ampel import Ampel
ampel = Ampel('rot')

#------------------------------------------------------------------------------
# GUI
#------------------------------------------------------------------------------

from tkinter import *

# Farben
grau     = '#404040'
rotAn    = '#FF0000'
rotAus   = '#550000'
gelbAn   = '#FFFF00'
gelbAus  = '#555500'
gruenAn  = '#00FF00'
gruenAus = '#005500'

# Ereignisverarbeitung
def buttonWeiterClick():
    # Verarbeitung der Daten
    ampel.schalten()
    # Aktualisierung der Anzeige
    (lampeRot, lampeGelb, lampeGruen) = ampel.getLampen()
    if lampeRot:
        canvas.itemconfigure(id_rot, fill=rotAn)
    else:
        canvas.itemconfigure(id_rot, fill=rotAus)
    if lampeGelb:
        canvas.itemconfigure(id_gelb, fill=gelbAn)
    else:
        canvas.itemconfigure(id_gelb, fill=gelbAus)
    if lampeGruen:
        canvas.itemconfigure(id_gruen, fill=gruenAn)
    else:
        canvas.itemconfigure(id_gruen, fill=gruenAus)

                                                                                                # Erzeugung des Fensters
fenster = Tk()
fenster.title("Ampel")
fenster.geometry("640x480")
# Zeichenfläche
canvas = Canvas(master=fenster)
canvas.place(x=0, y=0, width=640, height=480)
# Hintergrundbild
hintergrundbild = PhotoImage(file="hintergrund.gif")
canvas.create_image(0, 0, image=hintergrundbild, anchor=NW)
# Ampelanzeige
# Ampelkasten
canvas.create_rectangle(350, 200, 362, 232, fill=grau)
# Rot-Licht
id_rot = canvas.create_oval(352, 202, 360, 210, fill=grau)
# Gelb-Licht
id_gelb = canvas.create_oval(352, 212, 360, 220, fill=grau)
# Grün-Licht
id_gruen = canvas.create_oval(352, 222, 360, 230, fill=grau)
# Stange
canvas.create_rectangle(355, 232, 357, 264, fill=grau)
# Aktualisierung der Anzeige
(lampeRot, lampeGelb, lampeGruen) = ampel.getLampen()
if lampeRot:
    canvas.itemconfigure(id_rot, fill=rotAn)
else:
    canvas.itemconfigure(id_rot, fill=rotAus)
if lampeGelb:
    canvas.itemconfigure(id_gelb, fill=gelbAn)
else:
    canvas.itemconfigure(id_gelb, fill=gelbAus)
if lampeGruen:
    canvas.itemconfigure(id_gruen, fill=gruenAn)
else:
    canvas.itemconfigure(id_gruen, fill=gruenAus)
# Button zum Weiterschalten
buttonWeiter = Button(master=fenster,
        text="weiter",
        command=buttonWeiterClick)
buttonWeiter.place(x=150, y=270, width=100, height=20)
# Ereignisschleife starten
fenster.mainloop()
