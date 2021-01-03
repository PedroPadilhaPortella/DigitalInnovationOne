let order = [];
let clickedOrder = [];
let score = 0


// Ativa a classe selected por um periodo de tempo
let lightColor = (element, time) => {
    time = time * 500;
    setTimeout(() => {
        element.classList.add('selected');
    }, time -250);
    
    setTimeout(() => {
        element.classList.remove('selected');
    }, time);
}

// cria o elemento e retorna a cor baseada no seu valor
let createColorElement = (color) =>  {
    if(color == 0)
        return green;

    else if(color == 1)
        return red;

    else if(color == 2)
        return yellow;

    else if(color == 3)
        return blue;
}

// Cria ordem aleatória de cores
let nextRound = () => {
    let colorOrder = Math.floor(Math.random() * 4);
    order[order.length] = colorOrder;
    clickedOrder = []
    
    for (let i in order) {
        let elementColor = createColorElement(order[i]);
        lightColor(elementColor, Number(i) + 1);
    }
}

// Checa se os botões clicados são os mesmos botões gerados pelo jogo
let checkOrder = () => {
    for (let i in clickedOrder) {
        if(clickedOrder[i] != order[i]) {
            gameOver();
            break;
        }
    }
    if(clickedOrder.length == order.length) {
        nextRound();
        score ++
    }
}

// Rastrear clique do usuário
let click = (color) => {
    clickedOrder[clickedOrder.length] = color;
    createColorElement(color).classList.add('selected');
    
    setTimeout(() => {
        createColorElement(color).classList.remove('selected');
        checkOrder();
    }, 250);
}


// game Over
let gameOver = () => {
    alert(`Pontuação: ${score}\nVocê perdeu o jogo! Clique em ok para reiniciar!`);
    order = []
    clickedOrder = []
    
    playGame();
}

// Iniciar partida
let playGame = () => {
    alert("Genius, iniciar novo jogo...")
    score = 0;
    nextRound();
}

/*  Programa Principal */

// 0 - verde
// 1 - vermelho
// 2 - amarelo
// 3 - azul

const blue = document.querySelector('.blue')
const red = document.querySelector('.red')
const green = document.querySelector('.green')
const yellow = document.querySelector('.yellow')

green.onclick = () => click(0);
red.onclick = () => click(1);
yellow.onclick = () => click(2);
blue.onclick = () => click(3);

playGame();