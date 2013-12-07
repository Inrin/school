#!/usr/bin/python

from time import *

__TESTRANGE=10000

listeDaten2 = [
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
    ('Schreiber', 'Barbara', 'Stresemannstr. 56', '66592', 'St Wendel'),
    ('Schulz', 'Alexander', 'Anhalter Strasse 45', '67744', 'Seelen')
    ]

listeDaten = []
for i in range(__TESTRANGE):
    listeDaten.append((1,2,3,4,5))

def naivSuchen(name):
    i = 0
    for person in listeDaten:
        i = i + 1
        if name == person[0]:
            #print(str(person))
            #print(i)
            break



def binaerSuchen(name):
    gefunden = False
    links = 0
    rechts = len(listeDaten)-1
    i2 = 0
    while not gefunden and links <= rechts:
        mitte = (links + rechts) // 2
        i2 = i2 + 1
        if name == listeDaten[mitte][0]:
            gefunden = True
        elif name < listeDaten[mitte][0]:
            rechts = mitte - 1
        else:
            links = mitte + 1
    #print(listeDaten[mitte])
    #print(i2)


#Test
listeErgebnisseNaiv = []
listeErgebnisseBinaer = []

for t in range(__TESTRANGE):
    t1 = clock()
    naivSuchen(3)
    t2 = clock()
    gesamt = t2 - t1
    listeErgebnisseNaiv.append(gesamt)
    #print(gesamt)

    t3 = clock()
    binaerSuchen(3)
    t4 = clock()
    gesamt2 = t4 - t3
    listeErgebnisseBinaer.append(gesamt2)
    #print(gesamt2)

durchschnittNaiv = 0
for i in range(__TESTRANGE):
    durchschnittNaiv += listeErgebnisseNaiv[i]
    durchschnittNaiv /= __TESTRANGE

print("Durschnitt naive Suche")
print(durchschnittNaiv)

durchschnittBinaer = 0
for i in range(__TESTRANGE):
    durchschnittBinaer += listeErgebnisseBinaer[i]
    durchschnittBinaer /= __TESTRANGE

print("Durschnitt binaer Suche")
print(durchschnittBinaer)
