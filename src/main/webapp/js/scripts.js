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
            question: "Кем является Тёмный Соблазн?",
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

document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll('.gallery-item img').forEach(img => {
        img.addEventListener('click', () => {
            const overlay = document.createElement('div');
            overlay.classList.add('overlay');
            overlay.innerHTML = `<img src="${img.src}" class="large-img">`;

            overlay.addEventListener('click', () => overlay.remove());

            document.addEventListener('keydown', function escHandler(e) {
                if (e.key === "Escape") {
                    overlay.remove();
                    document.removeEventListener('keydown', escHandler);
                }
            });

            document.body.appendChild(overlay);
        });
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
        "Дварф": `
        <p>Дварфы — низкорослые и выносливые существа, известные своей стойкостью и мастерством кузнечного дела.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Любят пиво, но не эльфское</li>
            <li>Рост как у студента ХимФака</li>
            <li>Даже представители женского пола имеют бороду</li>
        </ul>
    `,
        "Эльф": `
        <p>Эльфы — грациозные и мудрые, обладают острым зрением и долголетием.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Долгая жизнь</li>
            <li>Владение луком и магией</li>
            <li>Любят природу и искусство</li>
        </ul>
    `,
        "Орк": `
        <p>Орки — сильные и свирепые воины, с высоким чувством чести.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Физическая мощь</li>
            <li>Агрессивность в бою</li>
            <li>Простота и прямота</li>
        </ul>
    `,
        "Человек": `
        <p>Люди — универсальная и амбициозная раса, способная к любому делу.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Быстро учатся</li>
            <li>Адаптивность</li>
            <li>Разнообразие талантов и профессий</li>
        </ul>
    `,
        "Тифлинг": `
        <p>Тифлинги — потомки демонов и людей, отличающиеся уникальной внешностью и магическим потенциалом.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Демонские черты</li>
            <li>Склонность к магии</li>
            <li>Привлекают внимание окружающих</li>
        </ul>
    `,
        "Кенку": `
        <p>Кенку — птицеподобные существа, умеющие копировать голоса и звуки.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Без собственного голоса</li>
            <li>Отличное чувство слуха</li>
            <li>Маневренность и скрытность</li>
        </ul>
    `,
        "Гитьянка": `
        <p>Гитьянки — ловкие и хитрые странники, происходящие из племён с далёких планов.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Высокая ловкость</li>
            <li>Отличное стратегическое мышление</li>
            <li>Привязка к клану и традициям</li>
        </ul>
    `,
        "Гном": `
        <p>Гномы — маленькие и умелые мастера, известные инженерией и алхимией.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Любят механизмы и изобретения</li>
            <li>Выносливость и стойкость</li>
            <li>Ценят семейные традиции</li>
        </ul>
    `,
        "Полу-Эльф": `
        <p>Полу-эльфы — смесь человеческой энергии и эльфийской грации.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Соединяют лучшие качества обоих народов</li>
            <li>Универсальность в навыках</li>
            <li>Привлекательность и обаяние</li>
        </ul>
    `,
        "Дроу": `
        <p>Дроу — темные эльфы, живущие под землей и обладающие магической силой.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Темная кожа и светлые глаза</li>
            <li>Мастерство в магии и скрытности</li>
            <li>Социальная структура с строгой иерархией</li>
        </ul>
    `,
        "Драконорождённый": `
        <p>Драконорождённые — потомки драконов, обладающие физической силой и дыхательной способностью.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Драконьи черты</li>
            <li>Сильное тело и выносливость</li>
            <li>Природная аура магии</li>
        </ul>
    `,
        "Грунг": `
        <p>Грунг — маленькие пловцы с племенной культурой, обычно водные существа.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Любят воду</li>
            <li>Сильная племенная сплочённость</li>
            <li>Маневренность в бою</li>
        </ul>
    `,
        "Нага": `
        <p>Наги — змееобразные существа с магическими способностями.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Отличное чувство скрытности</li>
            <li>Магические атаки</li>
            <li>Гибкость и скорость</li>
        </ul>
    `,

        // Классы
        "Плут": `
        <p>Плуты — хитрые и ловкие, мастера скрытности и обмана.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Воровство и взлом</li>
            <li>Скрытность и манёвренность</li>
            <li>Умение избегать опасностей</li>
        </ul>
    `,
        "Бард": `
        <p>Барды — вдохновители, владеющие силой музыки и слов.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Заклинания через музыку</li>
            <li>Обаяние и харизма</li>
            <li>Поддержка команды</li>
        </ul>
    `,
        "Воин": `
        <p>Воины — мастера оружия и тактики, опора любого отряда.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Боевая стойкость</li>
            <li>Опыт ведения боя</li>
            <li>Физическая сила</li>
        </ul>
    `,
        "Колдун": `
        <p>Колдуны — обладатели врождённой магической силы.</p>
        <p><strong>Особенности</strong></p>
        <ul>
            <li>Врожденная магия</li>
            <li>Заклинания высокой мощности</li>
            <li>Мистическая аура</li>
        </ul>
    `,
        "Варвар": `
        <p>Варвары — яростные воины, полагающиеся на физическую силу и инстинкты.</p>
        <ul>
            <li>Гнев в бою</li>
            <li>Физическая мощь</li>
            <li>Выносливость</li>
        </ul>
    `,
        "Волшебник": `
        <p>Волшебники — мастера изучения и применения магии.</p>
        <ul>
            <li>Заклинания разнообразной силы</li>
            <li>Умение предвидеть события</li>
            <li>Интеллектуальная подготовка</li>
        </ul>
    `,
        "Друид": `
        <p>Друиды — хранители природы, способные превращаться в животных.</p>
        <ul>
            <li>Форма животных</li>
            <li>Контроль над стихиями</li>
            <li>Магия исцеления</li>
        </ul>
    `,
        "Жрец": `
        <p>Жрецы — посредники богов, способные исцелять и благословлять союзников.</p>
        <ul>
            <li>Исцеление</li>
            <li>Божественные заклинания</li>
            <li>Поддержка команды</li>
        </ul>
    `,
        "Монах": `
        <p>Монахи — мастера боевых искусств, движущиеся с высокой скоростью и точностью.</p>
        <ul>
            <li>Быстрые атаки</li>
            <li>Физическая выносливость</li>
            <li>Контроль энергии</li>
        </ul>
    `,
        "Паладин": `
        <p>Паладины — защитники добра и справедливости, с божественной силой.</p>
        <ul>
            <li>Божественные заклинания</li>
            <li>Защита союзников</li>
            <li>Физическая мощь и стойкость</li>
        </ul>
    `,
        "Следопыт": `
        <p>Следопыты — мастера выживания и охоты на врагов.</p>
        <ul>
            <li>Следопытские навыки</li>
            <li>Стрельба из лука</li>
            <li>Выживание в дикой местности</li>
        </ul>
    `,
        "Чародей": `
        <p>Чародеи — маги, получающие силу из своей крови.</p>
        <ul>
            <li>Стихийная магия</li>
            <li>Высокая интуиция</li>
            <li>Природный магический потенциал</li>
        </ul>
    `,
        "Тараска": "Тараска — гигантское чудовище, почти неуязвимое.",
        "Вурдалак": "Вурдалаки — мертвецы, питающиеся плотью живых.",
        "Лич": "Лич — могущественный маг, обретший бессмертие через некромантию.",
        "Гончая": "Адская гончая — демоническое существо, преследующее души грешников."
    };

    document.getElementById("info-title").textContent = name;
    document.getElementById("info-box").innerHTML = info[name] || "<p>Информации нет</p>";
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


    document.addEventListener("click", (e) =>
        {
            if (!menuButton.contains(e.target) && !menuList.contains(e.target)) {
                menuList.classList.remove("show");
            }
        }
    )
}