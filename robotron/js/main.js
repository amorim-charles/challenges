/*
Usando data atributes para manipular objetos do dom
*/

const arrayParts = document.querySelectorAll("[data-operator]");
const arrayDataStatistic = document.querySelectorAll("[data-statistic]");

//constante que armazena os valores das estatisticas que serão adicionados ou removidos 
const arrayStatisticsValues = {
    "weapon": {
        "precision": 29,
        "resistance": 0,
        "energy": 0,
        "velocity": 0
    },

    "drone": {
        "precision": 0,
        "resistance": 0,
        "energy": -19,
        "velocity": 0
    },

    "items": {
        "precision": 0,
        "resistance": 0,
        "energy": 0,
        "velocity": -11
    },

    "physicist": {
        "precision": 27,
        "resistance": 21,
        "energy": 0,
        "velocity": 29
    },

    "squad": {
        "precision": 29,
        "resistance": 28,
        "energy": 19,
        "velocity": 10
    }
}

/*
laço que adiciona um ouvinte(addEventListener) em todos os buttons que contem o "data atributo" "part". quando o botação e clicado o método updateControlAtributes recebe dois paremetros, o "operator"(indica se é pra somar ou subtrair atributos) e o parentNode(que é a identificação da tag pai do elemento, que nesse caso é uma <div>) assim o método updateControlAtributes vai usar essa div para achar o data atributo "count". Para o método updateStatistics também é passado o "operator" e, o data "part"(que indica a parte que foi clicada)
*/

arrayParts.forEach((element) => {
    element.addEventListener("click", (event) => {
        console.log(event.target.parentNode.dataset)
        updateControlAtributes(event.target.dataset.operator, event.target.parentNode);
        updateStatistics(event.target.dataset.operator, event.target.dataset.part);
    })
})

/*
função que recebe o operador e contador e alterar o valor da parte clicada para mais ou menos
*/

function updateControlAtributes(operator, countInput) {
    const part = countInput.querySelector("[data-count]");
    
    if(operator === "-") {
        part.value = parseInt(part.value) - 1
    } else if(operator === "+") {
        part.value = parseInt(part.value) + 1
    }
}


/*
função que recebe o operador e a parte clicada, percorre as estatísticas busca no arrayStatisticsValues [pela parte clicada] [os atributos] (ex: arrayStatisticsValues[weapon][precision: 29, resistance: 0, energy: 0, velocity: 0]) adiciona ou subtrai de acordo com o operador e faz a converção de string para inteiro com (parseInt) 
*/

function updateStatistics(operator, part) {
    arrayDataStatistic.forEach((element => {
        if(operator === "-") {
            element.textContent = parseInt(element.textContent) - arrayStatisticsValues[part][element.dataset.statistic]
        } else if(operator === "+") {
            element.textContent = parseInt(element.textContent) + arrayStatisticsValues[part][element.dataset.statistic]
        }
    }))
}
   
   
   
