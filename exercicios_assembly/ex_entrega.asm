
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

; add your code here
MOV AX, 38; teste
MOV CX, 5
MOV DL, 0
MOV DH, 0

CMP AX, CX
JGE for
JMP resto

for:
    SUB AX, CX
    INC DL
    CMP AX, CX
    JGE for
    JMP resto
    
resto:
    MOV DH, AL

ret




