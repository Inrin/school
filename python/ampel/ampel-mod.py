class Ampel(object):
    def __init__(self, anfangszustand):
        self.lampeRot = (anfangszustand[0:3] == 'rot'
        self.lampeGelb = ('gelb' in anfangszustand)
        self.lampeGruen = (anfangszustand == 'gruen' )

    def schalten(self):
        if slef.zustand == 'rot':
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

        def getZustand(self):
            return self.zustand

        def setZustand(self, z):
            self.zustand = z
