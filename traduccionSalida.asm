section .data
    format_int db "%lld", 10, 0
    edad dq 0
    contador dq 0
    str0 db "Iniciando la pelicula de prueba...", 10, 0
    str1 db "Es apta para la familia.", 10, 0
    str2 db "Es para niños menores de 5 años.", 10, 0
    str3 db "Contando del 0 al 4:", 10, 0
    i dq 0
    str4 db "El contador final es:", 10, 0

section .text
    global main
    extern printf

main:
    push rbp
    mov rbp, rsp
    sub rsp, 32
    mov rax, 10
    mov qword [rel edad], rax
    mov rax, 0
    mov qword [rel contador], rax
    lea rcx, [rel str0]
    call printf
    mov rax, qword [rel edad]
    push rax
    mov rax, 5
    mov rbx, rax
    pop rax
    cmp rax, rbx
    jg L2
    jmp L1
L2:
    lea rcx, [rel str1]
    call printf
    jmp L0
L1:
    lea rcx, [rel str2]
    call printf
L0:
    lea rcx, [rel str3]
    call printf
    mov rax, 0
    mov qword [rel i], rax
    mov rax, 0
    mov qword [rel i], rax
L3:
    mov rax, qword [rel i]
    push rax
    mov rax, 5
    mov rbx, rax
    pop rax
    cmp rax, rbx
    jl L5
    jmp L4
L5:
    mov rax, qword [rel i]
    lea rcx, [rel format_int]
    mov rdx, rax
    call printf
    mov rax, qword [rel contador]
    push rax
    mov rax, 2
    mov rbx, rax
    pop rax
    add rax, rbx
    mov qword [rel contador], rax
    mov rax, qword [rel i]
    push rax
    mov rax, 1
    mov rbx, rax
    pop rax
    add rax, rbx
    mov qword [rel i], rax
    jmp L3
L4:
    lea rcx, [rel str4]
    call printf
    mov rax, qword [rel contador]
    lea rcx, [rel format_int]
    mov rdx, rax
    call printf
    add rsp, 32
    mov eax, 0
    pop rbp
    ret
