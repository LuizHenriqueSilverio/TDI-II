const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valueInput = document.querySelector('#montante');

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

    descInput.value = '';
    valueInput.value = '';
});