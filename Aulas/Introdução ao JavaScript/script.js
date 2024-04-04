// higher order function

function moreThan(writer) {
    let num = (Math.random() * 100).toFixed();
    writer("Random " + num);

    return function(value) {
        return value > num;
    }
}

// Usando uma variável intermediária
const funcRef = moreThan(console.log);
console.log(funcRef(10));