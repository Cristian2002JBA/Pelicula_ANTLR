#include <stdio.h>
#include <stdbool.h>

int main() {
    int edad = 10;
    int contador = 0;
    printf("%s\n", "Iniciando la pelicula de prueba...");
    if (edad > 5) {
        printf("%s\n", "Es apta para la familia.");
    }
    else {
        printf("%s\n", "Es para niños menores de 5 años.");
    }
    printf("%s\n", "Contando del 0 al 4:");
    int i = 0;
    for (int i = 0; i < 5; i = i + 1) {
        printf("%d\n", i);
        contador = contador + 2;
    }
    printf("%s\n", "El contador final es:");
    printf("%d\n", contador);
    return 0;
}
