// Traducción a TypeScript
let edad: number = 10;
let contador: any = 0;
console.log("Iniciando la pelicula de prueba...");
if (edad > 5) {
    console.log("Es apta para la familia.");
}
else {
    console.log("Es para niños menores de 5 años.");
}
console.log("Contando del 0 al 4:");
let i: any = 0;
for (let i = 0; i < 5; i = i + 1) {
    console.log(i);
    contador = contador + 2;
}
console.log("El contador final es:");
console.log(contador);
