#------------------------------------------------------------------------------
# Ampel
#------------------------------------------------------------------------------

class Ampel(object):

    def __init__(self, anfangszustand):
        self.zustand = anfangszustand

    def setZustand(self, z):
        self.zustand = z

    def getZustand(self):
        return self.zustand

    def schalten(self):
        if self.zustand == 'rot':
            self.zustand = 'rotgelb'
        elif self.zustand == 'rotgelb':
            self.zustand = 'gruen'
        elif self.zustand == 'gruen':
            self.zustand = 'gelb'
        elif self.zustand == 'gelb':
            self.zustand = 'rot'

    def getLampen(self):
        if self.zustand == 'rot':
            lampen = (True, False, False)
        elif self.zustand == 'rotgelb':
            lampen = (True, True, False)
        elif self.zustand == 'gruen':
            lampen = (False, False, True)
        elif self.zustand == 'gelb':
            lampen = (False, True, False)
        return lampen

#------------------------------------------------------------------------------
# AmpelFussgaenger
#------------------------------------------------------------------------------

class AmpelFussgaenger(object):

    def __init__(self, anfangszustand):
        self.zustand = anfangszustand

    def setZustand(self, z):
        self.zustand = z

    def getZustand(self):
        return self.zustand

    def schalten(self):
        if self.zustand == 'rot':
            self.zustand = 'gruen'
        elif self.zustand == 'gruen':
            self.zustand = 'rot'

    def getLampen(self):
        if self.zustand == 'rot':
            lampen = (True, False)
        elif self.zustand == 'gruen':
            lampen = (False, True)
        return lampen

#------------------------------------------------------------------------------
# Zaehler
#------------------------------------------------------------------------------

class Zaehler(object):
    def __init__(self, g):
        self.grenze = g
        self.stand = 0

    def weiterzaehlen(self):
        if self.stand < self.grenze-1:
            self.stand = self.stand + 1
        else:
            self.stand = 0

    def getStand(self):
        return self.stand

    def setStand(self, s):
        self.stand = s

#------------------------------------------------------------------------------
# Schalttabelle
#------------------------------------------------------------------------------

class SchaltplanVerwalter(object):
    def __init__(self):
        self.listePlaene = [
            [False, True, True, False, False, True, True, False, False, False],
            [True, True, False, False, False, False, True, True, False, False],
            [False, True, True, False, False, True, True, False, False, False],
            [True, True, False, False, False, False, True, True, False, False],
            [False, False, True, False, False, True, False, False, False, False],
            [True, False, False, False, False, False, False, True, False, False],
            [False, False, True, False, False, True, False, False, False, False],
            [True, False, False, False, False, False, False, True, False, False]
            ]
        self.zaehler = Zaehler(10)

    def getAktuelleSchaltsignale(self):
        s = self.zaehler.getStand()
        listeSchaltsignale = []
        for plan in self.listePlaene:
            schaltsignal = plan[s]
            listeSchaltsignale = listeSchaltsignale + [schaltsignal]
        self.zaehler.weiterzaehlen()
        return listeSchaltsignale

#------------------------------------------------------------------------------
# Ampelmanager
#------------------------------------------------------------------------------

class AmpelManager(object):
    def __init__(self, pListeAmpeln, pSchaltplanverwalter):
        self.listeAmpeln = pListeAmpeln
        self.schaltplanverwalter = pSchaltplanverwalter

    def schalteAmpeln(self):
        listeSchaltsignale = self.schaltplanverwalter.getAktuelleSchaltsignale()
        for i in range(len(self.listeAmpeln)):
            ampel = self.listeAmpeln[i]
            if listeSchaltsignale[i] == True:
                ampel.schalten()

