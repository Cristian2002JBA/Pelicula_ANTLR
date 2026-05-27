#include <stdio.h>
#include <stdbool.h>

int main() {
    printf("%s\n", "Sumatoria del 1 al 10:");
    int limite = 10;
    int sumaTotal = 0;
    int i = 1;
    for (int i = 1; i < limite + 1; i = i + 1) {
        sumaTotal = sumaTotal + i;
    }
    printf("%s\n", "La suma es:");
    printf("%d\n", sumaTotal);
    return 0;
}
