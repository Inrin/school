class CPM(object):
    """Schaltplanmanager"""

    def __init__(self):
        self.plans = [
            [False, True, True, False, False, True, True, False, False, False],
            [True, True, False, False, False, False, True, True, False, False],
            [False, True, True, False, False, True, True, False, False, False],
            [True, True, False, False, False, False, True, True, False, False],
            [False, False, True, False, False, True, False, False, False, False],
            [True, False, False, False, False, False, False, True, False, False],
            [False, False, True, False, False, True, False, False, False, False],
            [True, False, False, False, False, False, False, True, False, False]
            ]
        self.counter = 0
        self.LIMIT = 10

    def getCurrentSectionSignal(self):
        signals = []
        for plan in self.plans:
            signal = plan[self.counter]
            signals += [signal]
        if self.counter < self.LIMIT -1:
            self.counter += 1
        else:
            self.counter = 0
        return signals
