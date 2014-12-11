#!/usr/bin/python

def genKeys(p,q):
    N = p * q
    phi = (p-1) * (q-1)

    e = 1031

    for d in range(2,phi-1):
        if ((e*d)%phi == 1):
            break

    return ((e,N),(d,N))


def encrypt(message, pubkey):
    m = message

    if m > pubkey[1]:
        raise

    return (m**pubkey[0]) % pubkey[1]

def decrypt(cipher, key):
    c = cipher
    return (c**key[0]) % key[1]

keypair = genKeys(3,17)

print("---------Keypair----------------")
print(keypair)
print("---------Message----------------")
message = 42
print(message)
print("--------CMessage----------------")
cryptedmessage = encrypt(message, keypair[0])
print(cryptedmessage)
print("--------DMessage----------------")
decryptedMessage = decrypt(cryptedmessage, keypair[1])
print(decryptedMessage)
