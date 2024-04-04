function verify(){
    let data = new Date()
    let year = data.getFullYear()
    const fyear = document.getElementById('age')
    const res = document.getElementById('res')

    if (fyear.value.length == 0 || Number(fyear.value) > year){
        window.alert('Verique os dados e tente novamente!')
    } else {
        var fsex = document.getElementsByName('radsex')
        var age = year - Number(fyear.value)
        var gender = ''
        var img = document.createElement('img')
        img.setAttribute('Id', 'foto')


        if (fsex[0].checked){
            gender = 'Homem'
            if (age>= 0 && age <10){
                img.setAttribute('src', './assets/foto-bebe-m.JPG')
            } else if (age < 21){
                img.setAttribute('src', './assets/foto-jovem-m.JPG')
            } else if (age < 50){
                img.setAttribute('src', './assets/foto-adulto-m.JPG')
            } else {
                img.setAttribute('src', './assets/foto-idoso-m.JPG')
            }          
        } 
        else if (fsex[1].checked) {
            gender = 'Mulher'
            if (age>= 0 && age <10){
                img.setAttribute('src', './assets/foto-bebe-f.JPG')
            } else if (age < 21){
                img.setAttribute('src', './assets/foto-jovem-f.JPG')
            } else if (age < 50){
                img.setAttribute('src', './assets/foto-adulto-f.JPG')
            } else {
                img.setAttribute('src', './assets/foto-idoso-f.JPG')
            } 
        }
        res.style.textAlign = 'center'
        res.innerHTML = `Detectamos ${gender} com ${age} anos <br>`
        res.appendChild(img)
    }
}