#!/usr/bin/python

def crack(cipher, pubkey):
    e = pubkey[0]
    n = pubkey[1]

    ## Get factors of N
    factors = [[i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0][1]

    p = factors[0]
    q = factors[1]

    ## Generate own phi
    phi = (p-1) * (q-1)

    ## Generate own private key
    for d in range(2,phi-1):
        if ((e*d)%phi == 1):
            break

    ## Decrypt the message
    c = cipher
    return (c**d) % n

print(crack(113, (17,299)))


from genkeys import encrypt

pubkey = (2**16+1, 492773)
cmessage = 272146

print("")
print("-------Cracked Result-----------")
print(crack(cmessage, pubkey))

for m in range(98,101):
    if (encrypt(m, pubkey) == cmessage):
        print("")
        print("-------Message was--------------")
        print(m)
        break
