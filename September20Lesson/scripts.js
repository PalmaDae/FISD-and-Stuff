function changeToRight() {
    let block = document.getElementById("dev");
    let id = document.getElementById("id_text");
    let idButton = document.getElementById("id_button");
    if (block.classList == "left") {
        block.classList.remove("left");
        block.classList.add("right");
        id.textContent = "Надпись справа";
        idButton.textContent = "Правая кнопка";
    } else {
        block.classList.remove("right");
        block.classList.add("left");
        id.textContent = "Надпись слева";
        idButton.textContent = "Левая кнопка";
    }
}
