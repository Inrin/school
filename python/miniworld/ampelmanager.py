class RoboMan(object):
    """Ampelsystem verwalten"""
    robos = []
    cpm = None

    def __init__(self):
        cpm = CPM()
        robos = [AutoRobo('gruen'),PedesRobo('gruen'),
                AutoRobo('gruen'),PedesRobo('gruen'),
                AutoRobo('rot'),PedesRobo('rot'),
                AutoRobo('rot'),PedesRobo('rot')]
                
