class SPM(object):
    """Schaltplanmanager"""
    
    section = 0
    circuitPlan = [[]]
    def __init__(self):
        self.section = [
            [False, True, True, False, False, True, True, False, False],
            [True, True, False, False, False, False, True, True, False],
            [False, False, True, False, False, True, False, False, False],
            [True, False, False, False, False, False, False, True, False]
            ]
