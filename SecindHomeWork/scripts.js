let block;
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("beer_fact").textContent = randomFact();
}
);

document.addEventListener("DOMContentLoaded", timer);

document.addEventListener("DOMContentLoaded", picturesCarousel);

function randomFact() {
    let facts = [
        "Пиво – один из старейших алкогольных напитков в мире.",
        "Первое упоминание о пиве относится к Месопотамии около 4000 года до н.э.",
        "В Древнем Египте пиво считалось ежедневным продуктом питания.",
        "Слово 'пиво' произошло от древнеславянского слова 'пиво', означающего напиток.",
        "Хмель используется в пиве для горечи и аромата.",
        "Солод – это пророщенные и высушенные зерна, которые дают пиву вкус и цвет.",
        "Дрожжи превращают сахар в алкоголь и углекислый газ в процессе брожения.",
        "IPA (India Pale Ale) – популярный вид крафтового пива с сильным хмелевым вкусом.",
        "Светлое пиво обычно мягче и легче по вкусу, чем тёмное.",
        "Стауты и портеры – тёмные сорта пива с карамельными и шоколадными нотами.",
        "В Германии действует закон 'О чистоте пива' 1516 года, ограничивающий ингредиенты.",
        "Белое пиво (Witbier) обычно варят с пшеничным солодом и специями.",
        "В Японии популярны лёгкие лагеры с мягким вкусом.",
        "Американские крафтовые пивоварни активно экспериментируют с фруктами и травами.",
        "Существует более 400 сортов хмеля с разными ароматическими свойствами.",
        "Барливайны – крепкие бельгийские эли с высоким содержанием алкоголя.",
        "Крафтовое пиво часто варят малыми партиями для сохранения качества.",
        "Пивные фестивали популярны во многих странах, например, Октоберфест в Германии.",
        "Некоторые виды пива выдерживаются в бочках для придания вкуса.",
        "Пиво может быть нефильтрованным и мутным, например, хефевайцен.",
        "В США пивоварни делятся на микропивоварни, нанопивоварни и крафтовые.",
        "В Чехии среднестатистический человек выпивает больше всего пива в мире.",
        "Пиво раньше использовали как лекарство от многих болезней.",
        "В Англии популярны эли и традиционные бочковые сорта.",
        "Современные IPA возникли для экспорта пива в Индию во времена Британской империи.",
        "Существует даже безалкогольное пиво с минимальным содержанием алкоголя.",
        "Пивные дрожжи содержат витамины группы B и полезные микроэлементы.",
        "Пиво бывает как фильтрованным, так и нефильтрованным.",
        "Сидр и пиво – разные напитки, хотя иногда используют похожие методы брожения.",
        "В Бельгии варят пиво с использованием спонтанного брожения дикими дрожжами.",
        "Портер был популярен среди рабочих Лондона в XVIII веке.",
        "В Средние века монахи активно варили пиво в монастырях.",
        "В Исландии существует ограничение на продажу алкоголя в государственных магазинах.",
        "Существует 'сезонное пиво', варимое для конкретного времени года.",
        "Крафтовое пиво часто имеет уникальные названия и упаковку.",
        "Некоторые сорта пива выдерживают несколько лет для улучшения вкуса.",
        "Пиво содержит антиоксиданты, хотя употреблять его нужно умеренно.",
        "Белое пиво часто подают с долькой апельсина или лимона.",
        "Существует пиво с добавлением кофе, шоколада или специй.",
        "В Мексике популярны светлые лагеры с низким содержанием алкоголя.",
        "Пиво может быть газированным естественным образом или искусственно.",
        "В Австралии популярны лагерные сорта и светлое пиво.",
        "Хмель помогает дольше сохранять пиво свежим.",
        "В Японии есть фестивали сакэ и пива одновременно.",
        "Крафтовые пивоварни часто делают лимитированные серии пива.",
        "Пиво исторически считалось безопаснее воды в некоторых регионах.",
        "Пивные бокалы имеют разную форму для разных сортов пива.",
        "В Финляндии и Швеции алкоголь продаётся только в специальных магазинах.",
        "Пиво иногда используют в кулинарии для маринадов и выпечки.",
        "Существует светлое, тёмное, янтарное и красное пиво.",
        "Некоторые сорта пива выдерживаются с добавлением фруктов и ягод.",
        "Пиво в банках и бутылках может храниться дольше, чем на разлив.",
        "Крафтовое пиво помогает поддерживать местную экономику и малый бизнес."
    ];

    const randomIndex = Math.floor(Math.random() * facts.length);

    return facts[randomIndex];
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

function beatifulInfo() {

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