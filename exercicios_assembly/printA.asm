org 100h

MOV AX, 0800h
MOV DS, AX
MOV CL, 'A'

MOV CH, 1101_1111b
MOV BX, 15Eh
MOV [BX], CX

RET
