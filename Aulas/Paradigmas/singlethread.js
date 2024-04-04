function f4() {
    setTimeout(() => console.log('f5() rodou'), 5000);
    console.log('f4() rodou');
}

function f3() {
    console.log('f3() rodou');
    f4();
}

function f2() {
    console.log('f2() rodou');
    f3();
}

function f1() {
    console.log('f1() rodou');
    f2();
}

f1();