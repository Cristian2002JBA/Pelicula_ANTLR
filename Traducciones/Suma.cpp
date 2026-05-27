#include <iostream>
#include <string>

int main() {
    std::cout << "Sumatoria del 1 al 10:" << std::endl;
    auto limite = 10;
    auto sumaTotal = 0;
    auto i = 1;
    for (auto i = 1; i < limite + 1; i = i + 1) {
        sumaTotal = sumaTotal + i;
    }
    std::cout << "La suma es:" << std::endl;
    std::cout << sumaTotal << std::endl;
    return 0;
}
