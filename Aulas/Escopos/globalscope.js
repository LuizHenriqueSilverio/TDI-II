function scopeTest() {
    const brand = 'Volvo';
    let model = 'CX40';

    // Atribuição SEM declaração
    year = '2024';
    var test = 'test';

    console.log(`${brand} ${model} ${year}`);
}

scopeTest();
// Atribuições sem declarações são elevadas para o escopo global
console.log(`${year}`);

// Irá retornar um erro, pois não está no escopo global
// console.log(`${brand}`); 