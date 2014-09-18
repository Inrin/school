#!/usr/bin/python

import fileinput

ints = []
registers = []
orders = []

def process(line):
    values = line.split()

    global ints

    if values and 'i' in values[0]:
        registers.append(values[0])
        ints.append(values[1])

    if values and len(values) == 3:
        orders.append(values)

for line in fileinput.input():
    process(line)

def create_C_file(ints, orders):
    c_file = """
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
"""

    for i in range(len(ints)):
        c_file += "    int i" + str(i) + " = " + str(ints[i]) + ";\n"

    c_file += "\n    goto r0;\n\n"

    for o in orders:
        c_file += "r" + o[0] + ":\n"
        if o[2] and o[2] != "-":
            ifvar = str(int(o[0])+1)
            elvar = str(int(o[0])+2)

        if "TST" in o[1]:
            c_file += "    if (i" + o[2] + ")\n        goto r" + str(ifvar) + ";\n    else\n        goto r" + str(elvar) + ";\n"
        elif "JMP" in o[1]:
            c_file += "    goto r" + o[2] + ";\n"
        elif "INC" in o[1]:
            c_file += "    i" + o[2] + "++;\n    goto r" + ifvar + ";\n"
        elif "DEC" in o[1]:
            c_file += "    i" + o[2] + "--;\n    goto r" + ifvar + ";\n"
        elif "HLT" in o[1]:
            c_file += "    goto HLT;\n"

    c_file += """


HLT:
    printf("%d\\n", i0);

    exit(EXIT_SUCCESS);
}
"""

    print(c_file)

create_C_file(ints, orders)
