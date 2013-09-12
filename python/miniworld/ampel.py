class Ampel(object):
    """Lenkt die Lampen"""
    state

    def __init__(self, initstate):
        self.state = initstate
        
    def getState():
        return self.state
        
    def switch():
        if self.state == 'rot':
            state == 'rotgelb'
        elif self.state == 'rotgelb':
            state == 'gelb'
        elif self.state == 'gelb':
            state == 'gruen'
        elif self.state == 'gruen'
            state == 'rot'
        
