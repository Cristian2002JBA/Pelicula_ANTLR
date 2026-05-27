#include <iostream>
#include <string>

int main() {
    int edad = 10;
    auto contador = 0;
    std::cout << "Iniciando la pelicula de prueba..." << std::endl;
    if (edad > 5) {
        std::cout << "Es apta para la familia." << std::endl;
    }
    else {
        std::cout << "Es para niños menores de 5 años." << std::endl;
    }
    std::cout << "Contando del 0 al 4:" << std::endl;
    auto i = 0;
    for (auto i = 0; i < 5; i = i + 1) {
        std::cout << i << std::endl;
        contador = contador + 2;
    }
    std::cout << "El contador final es:" << std::endl;
    std::cout << contador << std::endl;
    return 0;
}
