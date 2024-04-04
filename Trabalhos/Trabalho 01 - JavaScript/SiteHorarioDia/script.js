function load(){
    const msg = window.document.getElementById('msg');
    const img = window.document.getElementById('photo');

    let date = new Date();
    let hour = date.getHours();

    msg.innerHTML = `Agora são ${hour} horas.`;

    if (hour >= 0 && hour < 12) {
        img.src = 'assets/dia.jpg';
        document.body.style.background = '#e2be9f'
    } else if (hour >= 12 && hour <= 18) {
        img.src = 'assets/tarde.jpg';
        document.body.style.background = '#b97e6f'
    } else {
        img.src = 'assets/noite.jpg';
        document.body.style.background = '#1b1a6f'
    }
 
}