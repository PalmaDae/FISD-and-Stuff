let block;
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("dnd_fact").textContent = randomFact();
}
);

document.addEventListener("DOMContentLoaded", timer);

document.addEventListener("DOMContentLoaded", picturesCarousel);

document.addEventListener("DOMContentLoaded", beatifulInfo);

document.addEventListener("DOMContentLoaded", dynamicNewsLoader);

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

function picturesCarousel() {
    let pics = [
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6685a14b20f44851592cac9f_6685a9f8db69b121a667d567/scale_1200",
            caption: "Первое пиво у мужчины"
        },
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_6632152247c42e563308e291_66321a3fdc525b089c8729fd/scale_1200",
            caption: "Лучшее пиво на свете"
        },
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_665090c9f429d0796c1d9c60_6650928a2f539b1ddc369dbe/scale_1200",
            caption: "Под доту покатит"
        },
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_65ed02ea46391233959a7cb0_65ef34b4d0da6a450caa4be9/scale_1200",
            caption: "Проклятый напиток"
        },
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_66583010e420d72646942a2e_6659fe6852837e61466f363a/scale_1200",
            caption: "Лучшее пиво если у тебя нет аллергии на мёд("
        },
        {
            src: "https://avatars.mds.yandex.net/i?id=f3e3647570749ce53580a1e10ceed06d_l-5669034-images-thumbs&n=13",
            caption: "Ну покатит"
        },
        {
            src: "https://avatars.dzeninfra.ru/get-zen_doc/9366213/pub_6499291b5a71a1676e7ec87c_649ba22b0d74bf7b022f763b/scale_1200",
            caption: "0_0"
        }
    ];

    let currentIndex = 0;

    let img = document.getElementById("carouselImage");
    let caption = document.getElementById("carouselCaption");

    function showPic(index) {
        img.src = pics[index].src;
        caption.textContent = pics[index].caption
    }

    document.getElementById("next").addEventListener("click", function() {
        currentIndex = (currentIndex + 1) % pics.length;
        showPic(currentIndex);
    });

    document.getElementById("prev").addEventListener("click", function() {
        currentIndex = (currentIndex - 1 + pics.length) % pics.length;
        showPic(currentIndex);
    });

    showPic(currentIndex);

}

function feedBack(event) {
    event.preventDefault();

    let email = document.getElementById("email").value.trim();
    let message = document.getElementById("message").value.trim();
    let feedBackResult = document.getElementById("feedback");

    let mailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!mailPattern.test(email)) {
        feedBackResult.textContent = "Пожалуйста введите корректный e-mail адрес";
        feedBackResult.style.color = "red";
        return;
    }

    if (message === "") {
        feedBackResult.textContent = "Пожалуйста напишите ваше сообщение 0_0";
        feedBackResult.style.color = "red";
        return;
    }

    feedBackResult.textContent = "Спасибо, ваше сообщение было отправлено(На самом деле нам без разницы на ваше мнение)"
    feedBackResult.style.color = "green";

    document.getElementById("feedbackForm").reset();
}

function timer() {
    let festivalDate = new Date("2025-10-01T12:00:00");
    let timerInPage = document.getElementById("festivalTimer");

    function updateTimer() {
        let now = new Date();
        let diff = festivalDate - now;

        if (diff <= 0) {
            timerInPage.textContent = "ФЕСТИВАЛЬ В САМОМ РАЗГАРЕ"
            clearInterval(interval);
            return;
        }

        let days = Math.floor(diff / (1000*60*60*24) )
        let hours = Math.floor((diff / (1000*60*60)) % 24);
        let minutes = Math.floor((diff / (1000*60)%60));
        let secunds = Math.floor((diff / (1000)%60));

        timerInPage.textContent = `${days} дней ${hours} часов ${minutes} минут ${secunds} секунд`;
    }

    updateTimer();

    let interval = setInterval(updateTimer, 1000);

}

function trueSideOfPage() {

}

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

function dynamicNewsLoader() {
    let newsContainer = document.getElementById("newsCont");
    let loadButton = document.getElementById("loadnews");

    let newsList = [
        "Новое крафтовое пиво стало хитом летнего сезона.",
        "Производители обещают увеличить экспорт пива на 20% в этом году.",
        "В России открывается первый музей пивоварения.",
        "Учёные нашли способ снизить калорийность пива без потери вкуса.",
        "Популярный бренд представил лимитированную серию пива с фруктовыми вкусами.",
        "Пивные фестивали в Европе привлекают рекордное число туристов.",
        "В США растёт интерес к безалкогольному пиву.",
        "Производители экспериментируют с добавлением специй в пиво.",
        "В Германии открыли пивоварню с полностью экологическим производством.",
        "Мировой рынок крафтового пива ожидает рост на 15% за год.",
        "Учёные доказали, что умеренное потребление пива может быть полезно для сердца.",
        "Популярный блогер провёл дегустацию редких сортов пива.",
        "В Японии разработали пиво с уникальным ароматом сакуры.",
        "Производители пива активно используют технологии искусственного интеллекта для создания новых вкусов.",
        "В Великобритании открылись новые пивные бары с исторической тематикой.",
        "Сбор урожая хмеля оказался рекордным, что повлияет на цены пива.",
        "Пивоварни адаптируются к цифровым продажам через онлайн-платформы.",
        "В Канаде откроется крупнейшая пивоварня с автоматизированным производством.",
        "Исследование показало рост популярности тёмного пива среди молодёжи.",
        "Фестиваль пива в Чехии установил новый рекорд посещаемости.",
        "Пивные бренды запускают совместные проекты с известными шеф-поварами.",
        "Производство крафтового пива стало популярным хобби среди студентов.",
        "В Австралии открыли пивоварню на солнечной энергии.",
        "Популярное пиво вернулось в старом классическом рецепте.",
        "В Индии начали производство уникального пива с добавлением местных специй."
    ];


    let currentIndex = 0;

    loadButton.addEventListener("click", () =>  {
        if (currentIndex >= newsList.length) {
            alert("Больше новостей нет");
            return;
        }

        let newsDiv = document.createElement("div");
        newsDiv.classList.add("newsItem")
        newsDiv.textContent = newsList[currentIndex]

        newsContainer.appendChild(newsDiv);

        currentIndex++
    }
    
    );

}