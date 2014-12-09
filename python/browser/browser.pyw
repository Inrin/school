#!/usr/bin/python

from socket import *
from tkinter import *

def getWebpage(address, port) -> "string":
    s = socket()
    s.connect((address, port))
    s.send(bytes('GET / HTTP/1.1\r\nHost: '+address+'\r\n\r\n','ascii'))
    content = s.recv(4096)
    return str(content, 'utf-8')

def sendButtonClick(event):
    urlstring = url.get()
    if urlstring:
        content = getWebpage(urlstring, 80)
        display.config(state=NORMAL)
        display.delete(1.0, END)
        display.insert(1.0, content)
        display.config(state=DISABLED)
    else:
        sleep(0.1)


root = Tk()
root.title('Webpy')

contentString = ""

url = Entry(root)
sendButton = Button(root, text="Get", command=sendButtonClick)
display = Text(root)
scrollbar = Scrollbar(root)

url.pack(side=TOP, fill=X)
scrollbar.pack(side=RIGHT, fill=Y)
sendButton.pack(side=RIGHT, fill=Y)
display.pack(fill=BOTH, expand=1)

sendButton.bind("<Enter>", sendButtonClick)
scrollbar.config(command=display.yview)
display.config(state=DISABLED,yscrollcommand=scrollbar.set)
url.focus()

root.mainloop()
