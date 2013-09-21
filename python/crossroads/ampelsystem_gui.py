#!/usr/bin/python
#------------------------------------------------------------------------------
# GUI
#------------------------------------------------------------------------------

# Farben
grau     = '#404040'
hellgrau = '#808080'
rotAn    = '#FF0000'
rotAus   = '#550000'
gelbAn   = '#FFFF00'
gelbAus  = '#555500'
gruenAn  = '#00FF00'
gruenAus = '#005500'

from tkinter import *
from ampelsystem_datenmodell import *

class GUI(object):
    def __init__(self, datenmodell):
        # Referenzattribute zum Datenmodell
        self.aN = datenmodell[0][0]
        self.aFN = datenmodell[0][1]
        self.aO = datenmodell[0][2]
        self.aFO = datenmodell[0][3]
        self.aS = datenmodell[0][4]
        self.aFS = datenmodell[0][5]
        self.aW = datenmodell[0][6]
        self.aFW = datenmodell[0][7]
        self.aM = datenmodell[1]

        # Erzeugung des Fensters
        self.fenster = Tk()
        self.fenster.title("Ampel")
        self.fenster.geometry("400x400")
        # Zeichenfläche
        self.canvas = Canvas(master=self.fenster)
        self.canvas.place(x=0, y=0, width=400, height=400)
        # Kreuzung
        self.canvas.create_rectangle(160, 0, 240 ,400, fill=hellgrau, outline=hellgrau)
        self.canvas.create_rectangle(0, 160, 400, 240, fill=hellgrau, outline=hellgrau)
        # Ampeln
        (self.id_ampel1_rot, self.id_ampel1_gelb, self.id_ampel1_gruen) = self.erzeugeAnsichtAmpel(150, 150, 5, 2)
        self.aktualisiereAnsichtAmpel(self.id_ampel1_rot, self.id_ampel1_gelb, self.id_ampel1_gruen, (True, False, False))
        (self.id_ampel2_rot, self.id_ampel2_gelb, self.id_ampel2_gruen) = self.erzeugeAnsichtAmpel(250, 150, 5, 1)
        self.aktualisiereAnsichtAmpel(self.id_ampel2_rot, self.id_ampel2_gelb, self.id_ampel2_gruen, (False, False, True))
        (self.id_ampel3_rot, self.id_ampel3_gelb, self.id_ampel3_gruen) = self.erzeugeAnsichtAmpel(250, 250, 5, 0)
        self.aktualisiereAnsichtAmpel(self.id_ampel3_rot, self.id_ampel3_gelb, self.id_ampel3_gruen, (True, False, False))
        (self.id_ampel4_rot, self.id_ampel4_gelb, self.id_ampel4_gruen) = self.erzeugeAnsichtAmpel(150, 250, 5, 3)
        self.aktualisiereAnsichtAmpel(self.id_ampel4_rot, self.id_ampel4_gelb, self.id_ampel4_gruen, (False, False, True))
        (self.id_ampel5_rot, self.id_ampel5_gruen) = self.erzeugeAnsichtKleineAmpel(130, 150, 5, 2)
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel5_rot, self.id_ampel5_gruen, (True, False))
        (self.id_ampel6_rot, self.id_ampel6_gruen) = self.erzeugeAnsichtKleineAmpel(250, 130, 5, 1)
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel6_rot, self.id_ampel6_gruen, (False, True))
        (self.id_ampel7_rot, self.id_ampel7_gruen) = self.erzeugeAnsichtKleineAmpel(270, 250, 5, 0)
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel7_rot, self.id_ampel7_gruen, (True, False))
        (self.id_ampel8_rot, self.id_ampel8_gruen) = self.erzeugeAnsichtKleineAmpel(150, 270, 5, 3)
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel8_rot, self.id_ampel8_gruen, (False, True))
        # Button zum Schalten
        self.buttonWeiter = Button(master=self.fenster, text="schalten",
                                   command=self.buttonWeiterClick)
        self.buttonWeiter.place(x=290, y=370, width=100, height=20)

    def erzeugeAnsichtAmpel(self, x, y, r, o=0):
        farbe = grau
        if o == 0:
            # Ampelkasten
            self.canvas.create_rectangle(x,y,x+3*r,y+8*r,fill=farbe)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x+0.5*r,y+0.5*r,x+2.5*r,y+2.5*r,fill=farbe)
            # Gelb-Licht
            id_gelb = self.canvas.create_oval(x+0.5*r,y+3*r,x+2.5*r,y+5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x+0.5*r,y+5.5*r,x+2.5*r,y+7.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x+1.25*r,y+8*r,x+1.75*r,y+16*r,fill=farbe)
        elif o == 1:
            # Ampelkasten
            self.canvas.create_rectangle(x,y,x+8*r,y-3*r,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x+0.5*r,y-0.5*r,x+2.5*r,y-2.5*r,fill=farbe)
            # Gelb-Licht
            id_gelb = self.canvas.create_oval(x+3*r,y-0.5*r,x+5*r,y-2.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x+5.5*r,y-0.5*r,x+7.5*r,y-2.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x+8*r,y-1.25*r,x+16*r,y-1.75*r,fill=grau)
        elif o == 2:
            # Ampelkasten
            self.canvas.create_rectangle(x-3*r,y,x,y-8*r,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x-2.5*r,y-0.5*r,x-0.5*r,y-2.5*r,fill=farbe)
            # Gelb-Licht
            id_gelb = self.canvas.create_oval(x-2.5*r,y-3*r,x-0.5*r,y-5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x-2.5*r,y-5.5*r,x-0.5*r,y-7.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x-1.75*r,y-8*r,x-1.25*r,y-16*r,fill=grau)
        elif o == 3:
            # Ampelkasten
            self.canvas.create_rectangle(x-8*r,y+3*r,x,y,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x-2.5*r,y+2.5*r,x-0.5*r,y+0.5*r,fill=farbe)
            # Gelb-Licht
            id_gelb = self.canvas.create_oval(x-5*r,y+2.5*r,x-3*r,y+0.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x-7.5*r,y+2.5*r,x-5.5*r,y+0.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x-16*r,y+1.75*r,x-8*r,y+1.25*r,fill=grau)
        return (id_rot, id_gelb, id_gruen)

    def erzeugeAnsichtKleineAmpel(self, x, y, r, o=0):
        farbe = grau
        if o == 0:
            # Ampelkasten
            self.canvas.create_rectangle(x,y,x+3*r,y+5.5*r,fill=farbe)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x+0.5*r,y+0.5*r,x+2.5*r,y+2.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x+0.5*r,y+3*r,x+2.5*r,y+5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x+1.25*r,y+5.5*r,x+1.75*r,y+16*r,fill=farbe)
        elif o == 1:
            # Ampelkasten
            self.canvas.create_rectangle(x,y,x+5.5*r,y-3*r,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x+0.5*r,y-0.5*r,x+2.5*r,y-2.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x+3*r,y-0.5*r,x+5*r,y-2.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x+5.5*r,y-1.25*r,x+16*r,y-1.75*r,fill=farbe)
        elif o == 2:
            # Ampelkasten
            self.canvas.create_rectangle(x-3*r,y,x,y-5.5*r,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x-2.5*r,y-0.5*r,x-0.5*r,y-2.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x-2.5*r,y-3*r,x-0.5*r,y-5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x-1.75*r,y-5.5*r,x-1.25*r,y-16*r,fill=farbe)
        elif o == 3:
            # Ampelkasten
            self.canvas.create_rectangle(x-5.5*r,y+3*r,x,y,fill=grau)
            # Rot-Licht
            id_rot = self.canvas.create_oval(x-2.5*r,y+2.5*r,x-0.5*r,y+0.5*r,fill=farbe)
            # Grün-Licht
            id_gruen = self.canvas.create_oval(x-5*r,y+2.5*r,x-3*r,y+0.5*r,fill=farbe)
            # Stange
            self.canvas.create_rectangle(x-16*r,y+1.75*r,x-5.5*r,y+1.25*r,fill=farbe)
        return (id_rot, id_gruen)

    def aktualisiereAnsichtAmpel(self, id_rot, id_gelb, id_gruen, lampenzustand):
        (lampeRot, lampeGelb, lampeGruen) = lampenzustand
        if lampeRot:
            self.canvas.itemconfigure(id_rot, fill=rotAn)
        else:
            self.canvas.itemconfigure(id_rot, fill=rotAus)
        if lampeGelb:
            self.canvas.itemconfigure(id_gelb, fill=gelbAn)
        else:
            self.canvas.itemconfigure(id_gelb, fill=gelbAus)
        if lampeGruen:
            self.canvas.itemconfigure(id_gruen, fill=gruenAn)
        else:
            self.canvas.itemconfigure(id_gruen, fill=gruenAus)

    def aktualisiereAnsichtKleineAmpel(self, id_rot, id_gruen, lampenzustand):
        (lampeRot, lampeGruen) = lampenzustand
        if lampeRot:
            self.canvas.itemconfigure(id_rot, fill=rotAn)
        else:
            self.canvas.itemconfigure(id_rot, fill=rotAus)
        if lampeGruen:
            self.canvas.itemconfigure(id_gruen, fill=gruenAn)
        else:
            self.canvas.itemconfigure(id_gruen, fill=gruenAus)

    def buttonWeiterClick(self):
        datenmodell[1].schalteAmpeln()
        self.aktualisiereAnsichtAmpel(self.id_ampel1_rot,self.id_ampel1_gelb,self.id_ampel1_gruen,
                datenmodell[0][0].getLampen())
        self.aktualisiereAnsichtAmpel(self.id_ampel2_rot,self.id_ampel2_gelb,self.id_ampel2_gruen,
                datenmodell[0][2].getLampen())
        self.aktualisiereAnsichtAmpel(self.id_ampel3_rot,self.id_ampel3_gelb,self.id_ampel3_gruen,
                datenmodell[0][4].getLampen())
        self.aktualisiereAnsichtAmpel(self.id_ampel4_rot,self.id_ampel4_gelb,self.id_ampel4_gruen,
                datenmodell[0][6].getLampen())
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel5_rot,
                self.id_ampel5_gruen, datenmodell[0][1].getLampen())
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel6_rot,
                self.id_ampel6_gruen, datenmodell[0][3].getLampen())
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel7_rot,
                self.id_ampel7_gruen, datenmodell[0][5].getLampen())
        self.aktualisiereAnsichtKleineAmpel(self.id_ampel8_rot,
                self.id_ampel8_gruen, datenmodell[0][7].getLampen())
#------------------------------------------------------------------------------
# Erzeugung der Objekte
#------------------------------------------------------------------------------

ampeln = [
        Ampel('rot'),AmpelFussgaenger('rot'),
        Ampel('gruen'),AmpelFussgaenger('gruen'),
        Ampel('rot'),AmpelFussgaenger('rot'),
        Ampel('gruen'),AmpelFussgaenger('gruen'),
        ]
am = AmpelManager(ampeln, SchaltplanVerwalter())
datenmodell = [ampeln, am]
gui = GUI(datenmodell)
gui.fenster.mainloop()
