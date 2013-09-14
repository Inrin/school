'''
File: roboMan.py
Author: Rieger Anton
Description: Ampelmanager
'''
from cpm import CPM
from robos import *
class RoboMan(object):
    """Ampelsystem verwalten"""

    def __init__(self):
        self.cpm = CPM()
        self.robos = [AutoRobo('gruen'),PedesRobo('gruen'),
                AutoRobo('rot'),PedesRobo('rot'),
                AutoRobo('gruen'),PedesRobo('gruen'),
                AutoRobo('rot'),PedesRobo('rot')]

    def switchRobos(self):
        """switch according to plan"""
        signals = self.cpm.getCurrentSectionSignal()
        for i in range(len(self.robos)):
            if signals[i] == True:
                self.robos[i].switch()

    def getStates(self) -> 'as string list':
        """get state of all robos clockwise (NOSW)"""
        states = []
        for robo in self.robos:
            states.append(robo.getState())
        return states
