/** PARADIGMAS DECLARATIVOS **/

const numbers = [1, 2, 3, 4, 5];

// Procedural (imperativo, para comparação)
const squares = [];
for(let n of squares) {
    let square = n * n;
    squares.push(square);
}

// Funcional
// função lambda
const squares2 = numbers.map((n) => n * n);
console.log(numbers);
console.log(squares2);