/** PROGRAMAÇÃO IMPERATIVA **/

// procedural
const sum = function(v1, v2) {
    return v1 + v2;
}

// POO
// Sintaxe da ECMAScript 6
class Person {
    // atributos
    constructor(name, cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    //métodos
    salute() {
        console.log(`Nome: ${this.name}, CPF: ${this.cpf}`);
    }
}

// Sintaxe pré ES6
function Person(name, cpf) {
    // atributos
    this.name = name;
    this.cpf = cpf;

    this.salute = function(){
        console.log(`Nome: ${this.name}, CPF: ${this.cpf}`);
    };
}

const programmer = new Person("Bill Gates", 12345678910);
programmer.salute();
console.log(programmer.salute);