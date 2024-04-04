function count() {
    const start = document.getElementById('start');
    const end = document.getElementById('end');
    const step = document.getElementById('step');
    const res = document.getElementById('res');

    if(start.value.length === 0
        || end.value.length === 0
        || step.value.length === 0) {
        res.innerHTML = 'Impossível contar!';
        return;
    }

    res.innerHTML = `Contando <br>`
    let i = Number(start.value);
    let f = Number(end.value);
    let p = Number(step.value);
    
    if(p <= 0) {
        window.alert('Passo inválido! Considerando PASSO 1');
        p = 1;
    }

    if(i < f) {
        for(let c = i; c <= f ; c += p) {
            res.innerHTML += `${c} \u{1F449}`
        }
    }else {
        for(let c = i; c >= f; c -= p){
            res.innerHTML += `${c} \u{1F449}`
        }
    }
    res.innerHTML += `\u{1F3C1}`
}