
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

; add your code here
                     
MOV DL, 5
MOV CL, 3 
MOV BL, 0
MOV CH, 0

JNZ for

for:
    ADD BL, DL
    INC CH
    CMP CH, CL
    JNZ for
          
MOV AX, BX

ret
