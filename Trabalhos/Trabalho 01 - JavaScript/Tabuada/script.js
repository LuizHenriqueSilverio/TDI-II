function mult() {
    const num = document.getElementById('input');
    const tab = document.getElementById('seltab');

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um número');
    } else {
        let n = Number(num.value);
        let c = 1;
        tab.innerHTML = '';
        while (c <= 10){
            let item = document.createElement('option');
            item.text = `${n} x ${c} = ${n*c}`;
            item.value = `tab${c}`;
            tab.appendChild(item);
            c++
        }
    }
}

function div() {
    const num = document.getElementById('input')
    const tab = document.getElementById('seltab2')

    if (num.value.length == 0 ){
        window.alert('Por favor, digite um número');
    } else {
        let n = Number(num.value);
        let c = 1;
        tab.innerHTML = '';
        while (c <= 10){
            let item = document.createElement('option');
            item.text = `${n} / ${c} = ${n/c}`;
            item.value = `tab${c}`;
            tab.appendChild(item);
            c++
        }
    }
}