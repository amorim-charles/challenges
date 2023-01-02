/*
######################################################################################
 1° exemplo: 
 Usar "id" e "classes" para manipular os elementos do dom (gera acoplamento com CSS)
######################################################################################
*/

// recebe uma lista (array) dos elementos com a classe "tecla"

const arrayOfButtons = document.querySelectorAll('.tecla');

/* 
1° percorre os itens da lista acima e cria uma nova constante (instrument) que recebe o nome da segunda classe[1] do elemento iterado. Depois a lista no valor iterado[i] diz que quando o evento "onclick" for acionado (quando elemento for clicado) irá executar um função anônima que irá executar a função "playSound" passando como parametro uma string concatenada com o a variavel instrument que contém o nome da classe do instrumento que será tocado formando o "id" do elemento audio clicado (#som_tecla_pom) Obs: eles devem ser passados entre crase `` por causa da variável.
*/

for (let i = 0; i < arrayOfButtons.length; i++) {
    const instrument = arrayOfButtons[i].classList[1];
    arrayOfButtons[i].onclick = function () {
        //playSound(`#som_${instrument}`);
    }

    /* 
    quando o evento "onkeydown"(quando uma tecla do teclado e pressionada) for acionado, irá executar uma função anônima que compara se o "code"(código do evento) da tecla pressionada é Space ou Enter (tecla espaço ou tecla entrer) se verdade, irá adicionar a classe "ativa" no html do elemento, pintando ele de vermelho enquanto estiver pressionado
    */

    arrayOfButtons[i].onkeydown = function (event) {
        if (event.code === "Space" || event.code === "Enter") {
            arrayOfButtons[i].classList.add("ativa");
        }
    }

    /* 
    "onkeyup"(quando a tecla que foi pressionada e liberada) faz a mesma comparação, no entanto, ela remove a classe "ativa" e faz o botão ficar com a cor normal
    */
    arrayOfButtons[i].onkeyup = (event) => {
        if (event.code === "Space" || event.code === "Enter") {
            listOfKeys[i].classList.remove('ativa')
        }
    }
}

/* 
função que recebe o "id" da tag audio que deve ser tocada. Ela compara se o atributo "localName" não é igual("!" negação) a "audio" (que indica se o elemento é do tipo audio) ou se é nulo, se verdade, exibe: "som não encontrado". Caso contrário, se "localName" for igual a audio, o querySelector vai localizar o elemento no dom e depois aplica o método "play()" que vai tocar o som. 
*/

function playSound(elementAudio) {
    if (!elementAudio.localName === "audio") {
        throw new ('som não encontrado');
    } else {
        document.querySelector(elementAudio).play();
    }
}

/*
--------------------------------------------------------------------------------------
 2° Exemplo:
 Usar atributos "data" para manipular os elementos do dom (sem acoplamento com CSS)
--------------------------------------------------------------------------------------
*/

// constantes que recebem listas de "botões"(data-soundButton) e seus respectivos "audios"(data-sound)
const arrayOfSoundButton = document.querySelectorAll("[data-soundButton]");
const arrayOfSound = document.querySelectorAll("[data-sound]");

arrayOfSoundButton.forEach((element) => {
    element.addEventListener("click", (event) => {
        playSoundData(event.target.dataset.soundbutton)
    })
})

function playSoundData(button) {
    arrayOfSound.forEach((element => {
        if(element.dataset.sound === button) {
            element.play();
        }
    }))
}





