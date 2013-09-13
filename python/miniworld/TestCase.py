'''
File: TestCase.py
Author: Rieger Anton
Description: Unittestklasse
'''
#!/usr/bin/python
import roboMan
import robos
import unittest

class TestSequenceFunctions(unittest.TestCase):

    def setUp(self):
        self.rm = roboMan.RoboMan()
        self.ar = robos.AutoRobo('rot')
        self.pr = robos.PedesRobo('rot')

    def test_init(self):
        self.assertEqual(self.rm.getStates(), ['gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen', 'rot', 'rot'])

    def test_cpm(self):
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['gelb', 'rot', 'rot', 'rot', 'gelb', 'rot', 'rot', 'rot'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rot', 'rot', 'rotgelb', 'rot', 'rot', 'rot', 'rotgelb', 'rot'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rot', 'rot', 'gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rot', 'rot', 'gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rot', 'rot', 'gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rot', 'rot', 'gelb', 'rot', 'rot', 'rot', 'gelb', 'rot'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['rotgelb', 'rot', 'rot', 'rot', 'rotgelb', 'rot', 'rot', 'rot'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen', 'rot', 'rot'])
        self.rm.switchRobos()
        self.assertEqual(self.rm.getStates(), ['gruen', 'gruen', 'rot', 'rot', 'gruen', 'gruen', 'rot', 'rot'])

    def test_auto_robo(self):
        self.assertEqual(self.ar.getState(),'rot')
        self.ar.switch()
        self.assertEqual(self.ar.getState(),'rotgelb')
        self.ar.switch()
        self.assertEqual(self.ar.getState(),'gruen')
        self.ar.switch()
        self.assertEqual(self.ar.getState(),'gelb')
        self.ar.switch()
        self.assertEqual(self.ar.getState(),'rot')

    def test_pedes_robo(self):
        self.assertEqual(self.pr.getState(), 'rot')
        self.pr.switch()
        self.assertEqual(self.pr.getState(), 'gruen')
        self.pr.switch()
        self.assertEqual(self.pr.getState(), 'rot')


if __name__ == '__main__':
    unittest.main()
