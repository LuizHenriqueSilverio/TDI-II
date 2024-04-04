const num = document.getElementById('num');
const list = document.getElementById('list');
const res = document.getElementById('res');
let values = [];

const isNumber = (n) => {
    if(Number(n) >= 1 && Number(n) <= 100) {
        return true;
    }
    return false;
};

const inList = (n, list) => { 
    if(list.indexOf(Number(n)) != -1) {
        return true;
    }
    return false;
}

function add() {
    if(isNumber(num.value) && !inList(num.value, values)) {
        values.push(Number(num.value));
        let item = document.createElement('option');
        item.text = `Valor ${num.value} adicionado.`;
        list.appendChild(item);
        res.innerHTML = '';
    }else {
        window.alert('Valor inválido ou já encontrado na lista.');
    }
    num.value = '';
    num.focus();
}

function finish() {
    if(values.length == 0) {
        window.alert('Adicione valores antes de finalizar.');
        return;
    }

    let total = values.length;
    let largest = values[0];
    let smallest = values[0];
    let sum = 0;
    let average = 0;

    for(let pos in values) {
        sum += values[pos];
        if(values[pos] > largest) {
            largest = values[pos];
        }
        if(values[pos] < smallest) {
            smallest = values[pos];
        }
    }

    average = sum / total;
    res.innerHTML = '';
    res.innerHTML += `<p>Ao todo, temos ${total} números cadastrados.</p>`;
    res.innerHTML += `<p>O maior valor informado foi ${largest}.</p>`;
    res.innerHTML += `<p>O menor valor informado foi ${smallest}.</p>`;
    res.innerHTML += `<p>Somando todos os valores, temos ${sum}.</p>`;
    res.innerHTML += `<p>A média dos valores digitados é ${average}.</p>`;
}