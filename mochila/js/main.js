// traz o "form" html para o js pelo id
const tagForm = document.getElementById("formItem");

// traz a tag "ul" que tem a classe "lista" para o js
const tagUl = document.getElementById("lista");

/* 
- recebe os itens já salvos no localstorage ou cria uma lista vazia
- o localstorage armazenas strings e o JSON.parse() para formar novamente os objetos usados pelo função addItem()
*/
const listItems = JSON.parse(localStorage.getItem("listItems")) || []

// laço que envia os objetos (se houver) para serem inseridos na página
listItems.forEach((element) => {
    addItem(element)
})

/*
- "addEventListener()" adiciona um ouvinte ao enveto de 'submit" do formulário
- "preventDefault()" cancela o evento padrão de direcionar o clique para própria página
- "const name" recebe do envento o elemento chamado "nome" que irá conter o nome do item digitado no formulário
- "const quantity" recebe do evento o elemento chamando "quantidade" que irá conter a quantidade digitada no fomrulário 
- "const item" é um objeto com atrivutos name e quantity, ele receberam os valores da const name e const quantity e formarão um objeto
- "validatorItem()" verifica se o item já existe
- const name e const quantity recebem uma string vazia para limpar o formulário

*/
tagForm.addEventListener("submit", event => {
    event.preventDefault();

    const name = event.target.elements["nome"];
    const quantity = event.target.elements["quantidade"];
    const item = {
        "name": name.value,
        "quantity": quantity.value
    };

    validatorItem(item, event);

    name.value = "";
    quantity.value = "";
})

/*
- "push()" adicona o objeto criado na lista de itens
- "localStorage" é o tipo de armazenamento do navegador que será usado. O método .setItem() recebe dois parâmetros: nome da coleção de dados e os dados no formato string, por isso o JSON.stringify() converte os objetos em strings 
- "addItem()" recebe o objeto criado para ser adicionado ao html (passo a passo mais abaixo)
*/

function validatorItem(item) {
    if ((item.name == "" && item.quantity == "") || item.name == "" || item.quantity == "") {
        const tagInput = document.getElementById("nome")
        tagInput.classList.add("active")
        return
    }

    const exist = listItems.find(element => element.name === item.name)

    if (exist) {
        item.id = exist.id
        updateItem(item)
    } else {
        item.id = listItems[listItems.length - 1] ? listItems[listItems.length - 1].id + 1 : 0
        listItems.push(item);
        localStorage.setItem("listItems", JSON.stringify(listItems));
        addItem(item)
    }
}

/*
- "document.createElement("strong")" cria uma tag "strong" do HTML
- "document.createElement('li')" cria uma tag "li" do HTML
- "tagLi.appendChild(tagStrong)" adiciona a tag "strong" dentro da "li" no HTML
- "tagUl.appendChild(tagLi)" adicona a tag "li" que ja tem a Stong, dentro da "ul" no HTML
*/

function addItem(item) {
    const tagStrong = document.createElement('strong');
    tagStrong.textContent = item.quantity;
    tagStrong.dataset.id = item.id;

    const tagLi = document.createElement('li');
    tagLi.classList.add("item");
    tagLi.appendChild(tagStrong);
    tagLi.innerHTML += item.name;
    tagLi.appendChild(buttonDelete());

    tagUl.appendChild(tagLi);
}

/*
- ("[data-id='" + item.id + "']") localiza pelo id do item
*/

function updateItem(item) {
    const quantity = document.querySelector("[data-id='" + item.id + "']")
    quantity.textContent = item.quantity
}

/*
- "document.createElement("button")" cria um tag "button" no HTML
- "addEventListener("click", event =>" adicionar ouvinte de click
*/

function buttonDelete() {
    const button = document.createElement("button")
    button.innerText = "X";
    button.addEventListener("click", event => {
        const tagLi = event.target.parentNode
        deleteItem(tagLi)
    })
    return button
}

/*
- "tagLi.childNodes" traz a lista de childs para iterar e achar a tag strong
- "splice(index, quantidade)" método para remover itens da lista. o primeiro paremetro e o index onde começar e o segundo e a quantidade de itens para excluir na sequência 
- "findIndex("joão")" retorna o index do elemento ou -1 se não achar 
*/

function deleteItem(tagLi) {
    const tagStrong = tagLi.childNodes
    tagStrong.forEach((element => {
        if (element.tagName === "STRONG") {
            const id = element.dataset.id
            listItems.splice(listItems.findIndex(elemento => elemento.id === id), 1)
            localStorage.setItem("listItems", JSON.stringify(listItems))
            tagLi.remove()
        }
    }))
}
