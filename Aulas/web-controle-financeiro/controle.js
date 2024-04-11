const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valueInput = document.querySelector('#montante');
const balance = document.getElementById('balanco');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const descTransaction = descInput.value.trim();
    const valueTransaction = valueInput.value.trim();

    if(descTransaction == '') {
        alert("Informe a descrição da transação!");
        descInput.focus();
        return;
    }

    if(valueTransaction == '') {
        alert("Informe o valor da transação!");
        valueInput.focus();
        return;
    }

    const transaction = {
        id: parseInt(Math.random() * 10000),
        desc: descTransaction,
        value: valueTransaction
    }

    descInput.value = '';
    valueInput.value = '';
});

function sumToBalance(transaction) {
    let balanceValue = balance.innerHTML.trim();
    balanceValue = balanceValue.replace('R$', '');
    balanceValue = parseFloat(balanceValue); 
}