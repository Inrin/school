#!/usr/bin/python

#------------------------------------------------------------------------------
# Import des Datenmodells
#------------------------------------------------------------------------------

from ampel import Ampel

#------------------------------------------------------------------------------
# GUI-Klasse
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

class GUI(object):
    def __init__(self, datenmodell):
        # Referenzattribute zum Datenmodell
        self.ampel = datenmodell[0]
        # Erzeugung des Fensters
        self.fenster = Tk()
        self.fenster.title("Ampel")
        self.fenster.geometry("400x300")
        # Zeichenfläche
        self.canvas = Canvas(master=self.fenster)
        self.canvas.place(x=0, y=0, width=400, height=300)
        # Hintergrundbild
        self.hintergrundbild = PhotoImage(file="hintergrund.gif")
        self.canvas.create_image(0, 0, image=self.hintergrundbild, anchor=NW)
        # Ampelanzeige
        # Ampelkasten
        self.canvas.create_rectangle(250, 120, 262, 152, fill=grau)
        # Rot-Licht
        self.id_rot = self.canvas.create_oval(252, 122, 260, 130, fill=grau)
        # Gelb-Licht
        self.id_gelb = self.canvas.create_oval(252, 132, 260, 140, fill=grau)
        # Grün-Licht
        self.id_gruen = self.canvas.create_oval(252, 142, 260, 150, fill=grau)
        # Stange
        self.canvas.create_rectangle(255, 152, 257, 184, fill=grau)
        # Aktualisierung der Anzeige
        self.anzeigeAktualisieren()
        # Button zum Weiterschalten
        self.buttonWeiter = Button(master=self.fenster,
                                   text="weiter",
                                   command=self.buttonWeiterClick)
        self.buttonWeiter.place(x=150, y=270, width=100, height=20)

    def buttonWeiterClick(self):
        # Verarbeitung der Daten
        self.ampel.schalten()
        # Aktualisierung der Anzeige
        self.anzeigeAktualisieren()

    def anzeigeAktualisieren(self):
        (lampeRot, lampeGelb, lampeGruen) = ampel.getLampen()
        if lampeRot:
            self.canvas.itemconfigure(self.id_rot, fill=rotAn)
        else:
            self.canvas.itemconfigure(self.id_rot, fill=rotAus)
        if lampeGelb:
            self.canvas.itemconfigure(self.id_gelb, fill=gelbAn)
        else:
            self.canvas.itemconfigure(self.id_gelb, fill=gelbAus)
        if lampeGruen:
            self.canvas.itemconfigure(self.id_gruen, fill=gruenAn)
        else:
            self.canvas.itemconfigure(self.id_gruen, fill=gruenAus)

#------------------------------------------------------------------------------
# Erzeugung der Objekte
#------------------------------------------------------------------------------

ampel = Ampel('rot')
datenmodell = [ampel]
gui = GUI(datenmodell)
gui.fenster.mainloop()

