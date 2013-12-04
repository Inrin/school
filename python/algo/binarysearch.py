#!/usr/bin/python
from time import clock

listeDaten = [
('Bergmann', 'Laura', 'Schmarjestrasse 76', '93497', 'Willmering'),
('Brandt', 'Mandy', 'Scharnweberstrasse 84', '68199', 'Mannheim Almenhof'),
('Ebersbacher', 'Michelle', 'Alt-Moabit 10', '06691', 'Zeitz'),
('Frey', 'Kristian', 'Hans-Grade-Allee 7', '24870', 'Ellingstedt'),
('Gruenewald', 'Marco', 'Nuernbergerstrasse 15', '26386', 'Wilhelmshaven'),
('Herzog', 'Marco', 'Scharnweberstrasse 90', '61130', 'Nidderau'),
('Keller', 'Christina', 'Alt Reinickendorf 24', '87542', 'Blaichach'),
('Koertig', 'Christine', 'Hardenbergstraße 82', '66887', 'Niederalben'),
('Kortig', 'Stefanie', 'Mühlenstrasse 76', '97201', 'Höchberg'),
('Krause', 'Stefanie', 'Brandenburgische Str. 20', '74343', 'Sachsenheim'),
('Loewe', 'Ulrike', 'Messedamm 69', '06054', 'Halle'),
('Mahler', 'Sophia', 'Charlottenstrasse 87', '01463', 'Langebrück'),
('Meister', 'Stephan', 'Fasanenstrasse 17', '22605', 'Hamburg Othmarschen'),
('Möller', 'Jens', 'Schoenebergerstrasse 47', '08313', 'Bernsbach'),
('Nussbaum', 'Florian', 'Kurfürstendamm 56', '08004', 'Zwickau'),
('Reinhard', 'Kevin', 'An Der Urania 15', '25856', 'Hattstedt'),
('Schmidt', 'Vanessa', 'Paderborner Strasse 44', '86359', 'Gersthofen'),
('Schmitz', 'Andreas', 'Meininger Strasse 84', '66539', 'Neunkirchen Ludwigsthal'),
('Schreiber', 'Barbara', 'Stresemannstr.  56', '66592', 'St Wendel'),
('Schulz', 'Alexander', 'Anhalter Strasse 45', '67744', 'Seelen')
]

def searchNaive(name, l):
    count=0
    for i in (l):
        count +=1
        if name in i:
            return count-1

def searchBinary(name, l):
    result=-1
    found=False
    left=0
    right=len(l)-1
    while not found and left <= right:
        center = (left+right) // 2
        if name == l[center][0]:
            found = True
            indexResult = center
        elif name < l[center][0]:
            right = center-1
        else:
            left = center+1
    return indexResult


"""Anfang testen"""
print("\n\nAnfang testen\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
t1=clock()
searchNaive("Bergmann", listeDaten)
t2=clock()
print("Naive Suche:\n" + str(t2-t1) + "\n==========================================")

t1=clock()
searchBinary("Bergmann", listeDaten)
t2=clock()
print("Binäre Suche:\n" + str(t2-t1) + "\n==========================================")


"""Mitte testen"""
print("\n\nMitte testen\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
t1=clock()
searchNaive("Krause", listeDaten)
t2=clock()
print("Naive Suche:\n" + str(t2-t1) + "\n==========================================")

t1=clock()
searchBinary("Krause", listeDaten)
t2=clock()
print("Binäre Suche:\n" + str(t2-t1) + "\n==========================================")


"""Ende testen"""
print("\n\nEnde  testen\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
t1=clock()
searchNaive("Schulz", listeDaten)
t2=clock()
print("Naive Suche:\n" + str(t2-t1) + "\n==========================================")

t1=clock()
searchBinary("Schulz", listeDaten)
t2=clock()
print("Binäre Suche:\n" + str(t2-t1) + "\n==========================================")



"""1/4 testen"""
print("\n\n1/4  testen\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
t1=clock()
searchNaive("Gruenewald", listeDaten)
t2=clock()
print("Naive Suche:\n" + str(t2-t1) + "\n==========================================")

t1=clock()
searchBinary("Gruenewald", listeDaten)
t2=clock()
print("Binäre Suche:\n" + str(t2-t1) + "\n==========================================")



"""3/4 testen"""
print("\n\n3/4  testen\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
t1=clock()
searchNaive("Nussbaum", listeDaten)
t2=clock()
print("Naive Suche:\n" + str(t2-t1) + "\n==========================================")

t1=clock()
searchBinary("Nussbaum", listeDaten)
t2=clock()
print("Binäre Suche:\n" + str(t2-t1) + "\n==========================================")
