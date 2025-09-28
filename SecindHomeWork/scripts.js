let block;

function randomFact() {

}

function changeTheme() {
    let idButton = document.getElementById("changeButton");

    if (block.classList.contains("radiant")) {
        block.classList.remove("radiant");
        block.classList.add("dark");
        localStorage.setItem('theme', 'dark');
    } else {
        block.classList.remove("dark");
        block.classList.add("radiant");
        localStorage.setItem('theme', 'radiant');
    }
}

window.addEventListener('load', () => {
    block = document.getElementById("change_theme");
    const savedTheme = localStorage.getItem('theme');

    if (savedTheme) {
        block.classList.remove('radiant', 'dark');
        block.classList.add(savedTheme);
    }
});

function picturesCarousel() {

}

function feedBack() {

}

function beatifulInfo() {

}

function timer() {

}

function trueSideOfPage() {

}