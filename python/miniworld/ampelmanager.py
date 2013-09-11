class Ampelmanager(object):
    """Ampelsystem verwalten"""
    ampeln = []
    spm = None

    def __init__(self):
        spm = Spm()
