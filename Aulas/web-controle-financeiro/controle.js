const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valueInput = document.querySelector('#montante');
const balance = document.getElementById('balanco');
const revenue = document.querySelector('#din-positivo');
const expenses = document.querySelector('#din-negativo');
const transactionsList = document.getElementById('transacoes');

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
        value: parseFloat(valueTransaction),
    }

    sumToBalance(transaction);

    sumRevenueExpenses(transaction);

    addTransactionToList(transaction);

    descInput.value = '';
    valueInput.value = '';
});

function sumToBalance(transaction) {
    let balanceValue = balance.innerHTML.trim();
    balanceValue = balanceValue.replace('R$', '');
    balanceValue = parseFloat(balanceValue); 
    balanceValue += transaction.value;

    balance.innerHTML = `R$${balanceValue.toFixed(2)}`;
}

function sumRevenueExpenses(transaction) {
    const element = transaction.value > 0 ? revenue : expenses;
    const sub = transaction.value > 0 ? '+ R$' : '- R$';
    
    let value = element.innerHTML.replace(sub, '');
    value = parseFloat(value);
    value += Math.abs(transaction.value);

    element.innerHTML = `${sub}${value.toFixed(2)}`;
}

function addTransactionToList(transaction) {
    const cssClass = transaction.value > 0 ? 'positivo' : 'negativo';
    const currency = transaction.value > 0 ? 'R$' : '-R$';

    let element = `<li class="${cssClass}">
    ${transaction.desc} <span>${currency}${Math.abs(transaction.value)}</span><button class="delete-btn">X</button>
  </li>`

    transactionsList.innerHTML += element;
}