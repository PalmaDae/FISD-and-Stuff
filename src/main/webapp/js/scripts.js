let block;
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("dnd_fact").textContent = randomFact();
}
);


document.addEventListener("DOMContentLoaded", () => {

    const quizData = [
        {
            question: "Кто издатель игры года?",
            options: ["Bethesda", "Larian", "OwlCats", "ITISGaming"],
            correct: 1
        },
        {
            question: "По какой причине вы умрёте в файте с Миркулом?",
            options: ["Ваш тимейт кинет гранаты под себя на доблести", "Ваш тимейт начнёт бесконечную драку с гиенами на доблести", "Просто так", "Ваш тимейт застрянет в роще друидов (на доблести)"],
            correct: 0
        },
        {
            question: "Кто лучшая девочка BG3?",
            options: ["Шадуха", "Минтара", "Карлах", "Этель"],
            correct: 1
        },
        {
            question: "Кем является Тёмный Соблаз?н",
            options: ["Демон", "Рандомный шизик", "Отродье Баала", "Бастард Короля"],
            correct: 2
        },
        {
            question: "Cколько баллов Пальмун залутает за эту семестровку?",
            options: ["0", "20", "5", "10"],
            correct: 5
        }
    ];

    const questionEl = document.getElementById("question");
    const optionsEl = document.getElementById("options");
    const nextBtn = document.getElementById("nextBtn");
    const resultEl = document.querySelector(".result");

    if (!questionEl || !optionsEl || !nextBtn || !resultEl) return;

    let currentQuestion = 0;
    let score = 0;

    function loadQuestion() {
        const current = quizData[currentQuestion];
        questionEl.textContent = current.question;
        optionsEl.innerHTML = "";

        current.options.forEach((option, index) => {
            const label = document.createElement("label");
            label.innerHTML = `
                <input type="radio" name="option" value="${index}">
                ${option}
            `;
            optionsEl.appendChild(label);
        });
    }

    function getSelectedOption() {
        const options = document.querySelectorAll('input[name="option"]');
        for (let opt of options) {
            if (opt.checked) return parseInt(opt.value);
        }
        return null;
    }

    nextBtn.addEventListener("click", () => {
        const answer = getSelectedOption();
        if (answer === null) return;

        if (answer === quizData[currentQuestion].correct) score++;
        currentQuestion++;

        if (currentQuestion < quizData.length) loadQuestion();
        else showResult();
    });

    function getRank(score) {
        // const percent = (score / total) * 100;
        if (score >= 5) return "БорнТуДайчик";
        if (score >= 3) return "Медвесыч";
        if (score >= 2) return "Лягушка";
        return "Ты кто вообще?";
    }

    function showResult() {
        questionEl.textContent = "";
        optionsEl.innerHTML = "";
        nextBtn.style.display = "none";

        const rank = getRank(score);

        resultEl.innerHTML = `
            Вы набрали ${score} из ${quizData.length} правильных ответов.<br>
            Ваш Титул: <span style="color:#8911d9">${rank}</span>
        `;
    }

    loadQuestion();
});

document.addEventListener("DOMContentLoaded", beatifulInfo);

document.querySelectorAll('.gallery-item img').forEach(img => {
    img.addEventListener('click', () => {
        const overlay = document.createElement('div');
        overlay.classList.add('overlay');
        overlay.innerHTML = `<img src="${img.src}" class="large-img">`;
        overlay.addEventListener('click', () => overlay.remove());
        document.body.appendChild(overlay);
    });
});


function randomFact() {
    let facts = [
        "Dungeons & Dragons была создана в 1974 году Гэри Гайгэксом и Дэйвом Арнесоном.",
        "Первоначально D&D была вдохновлена настольными военными играми.",
        "В D&D существуют разные классы персонажей: воин, маг, вор, клирик и др.",
        "Расовые варианты персонажей включают эльфов, дворфов, людей, гномов и полуэльфов.",
        "Система D&D использует разные кости: d4, d6, d8, d10, d12, d20.",
        "D20 — самая известная кость, определяющая успех или провал действия.",
        "В D&D есть основные характеристики персонажа: Сила, Ловкость, Выносливость, Интеллект, Мудрость и Харизма.",
        "Мастер игры (Dungeon Master) управляет сюжетом и миром.",
        "Игровой процесс включает исследование, бой, взаимодействие с NPC и решение загадок.",
        "Кампания — это серия связанных приключений, проводимых с одними и теми же персонажами.",
        "D&D вдохновила создание многих видеоигр, книг и фильмов.",
        "Заклинания в D&D имеют уровни от 0 (трюки) до 9 и различные эффекты.",
        "Монстры и существа имеют свои характеристики, способности и поведение.",
        "Роли персонажей в группе могут быть боевыми, магическими или поддерживающими.",
        "D&D использует систему опытных очков (XP) для повышения уровня персонажей.",
        "Некоторые версии D&D используют боевые сетки и миниатюры для боя.",
        "Критические успехи и провалы добавляют элемент случайности и драматизма.",
        "D&D оказала большое влияние на популяризацию жанра фэнтези.",
        "Многие знаменитые писатели и разработчики игр начинали с D&D.",
        "В D&D есть классические кампании, такие как 'Лабиринт Минотавра' и 'Tomb of Horrors'.",
        "Патчевые книги и дополнения расширяют мир и правила игры.",
        "Некоторые игровые миры D&D имеют свои собственные карты, лор и историю.",
        "Игроки могут создавать уникальные персонажи с историей, целями и мотивацией.",
        "Система навыков позволяет персонажам взаимодействовать с миром вне боя.",
        "D&D популярна среди игроков всех возрастов по всему миру.",
        "Игровой процесс развивает воображение, командную работу и стратегическое мышление.",
        "Классический стиль D&D отличается эпическим сюжетом и фэнтезийной атмосферой.",
        "Существуют турниры и соревнования по D&D с различными правилами.",
        "Многие мемы и культурные отсылки связаны с D&D.",
        "D&D имеет официальные и фанатские издания правил и материалов."
    ];

    const randomIndex = Math.floor(Math.random() * facts.length);

    return facts[randomIndex];
}

function showInfo(name) {
    const info = {
        "Дварф": "Дварфы — низкорослые и выносливые существа, известные своей стойкостью и мастерством кузнечного дела.",
        "Эльф": "Эльфы — грациозные и мудрые, обладают острым зрением и долголетием.",
        "Орк": "Орки — сильные воины, известные своей свирепостью и честью в бою.",
        "Человек": "Люди — универсальная и амбициозная раса, способная к любому делу.",
        "Плут": "Плуты — хитрые и ловкие, мастера обмана и скрытности.",
        "Бард": "Барды — вдохновители, владеющие силой музыки и слов.",
        "Воин": "Воины — мастера оружия и тактики, опора любого отряда.",
        "Колдун": "Колдуны — обладатели врождённой магической силы.",
        "Тараска": "Тараска — гигантское чудовище, почти неуязвимое.",
        "Вурдалак": "Вурдалаки — мертвецы, питающиеся плотью живых.",
        "Лич": "Лич — могущественный маг, обретший бессмертие через некромантию.",
        "Гончая": "Адская гончая — демоническое существо, преследующее души грешников."
    };

    document.getElementById("info-title").textContent = name;
    document.getElementById("info-box").textContent = info[name] || "Информации нет";
}


function changeTheme() {
    let idButton = document.getElementById("changeButton");

    if (block.classList.contains("radiant")) {
        block.classList.remove("radiant");
        block.classList.add("dire");
        localStorage.setItem('theme', 'dire');
    } else {
        block.classList.remove("dire");
        block.classList.add("radiant");
        localStorage.setItem('theme', 'radiant');
    }
}

window.addEventListener('load', () => {
    block = document.getElementById("change_theme");
    const savedTheme = localStorage.getItem('theme');

    if (savedTheme) {
        block.classList.remove('radiant', 'dire');
        block.classList.add(savedTheme);
    }
});

function beatifulInfo() {
    let menuButton = document.getElementById("menuButton");
    let menuList = document.getElementById("menuList");

    if (!menuButton || !menuList) return;

    menuButton.addEventListener("click", (e) => {

        e.preventDefault();
        menuList.classList.toggle("show");

    });

    menuButton.addEventListener("click", (e) => {
        if (!menuButton.contains(e.target) && !menuList.contains(e.target)) {
            menuList.classList.remove("show");
        }
    });
}