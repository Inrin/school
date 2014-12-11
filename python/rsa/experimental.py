p = 577
q = 541
N = p * q
e = 7
print('Öffentlicher Schlüssel:', e, N)
for i in range(0, 20):
    c = (i**e) % N
    if i < 10:
        print(i, ' ', c)
    else:
        print(i, '', c)


""" @see genkeys.py for task 2 """
