<span style="font-size: 2.0em;">FitBody</span>

Мобильное фитнес-приложение для отслеживания тренировок, прогресса и активности пользователя.

Приложение разработано с использованием **Clean Architecture**, а также сочетания паттернов **MVVM + MVI** для управления состоянием.


<span style="font-size: 1.4em;">Дизайн приложения</span>

<span style="font-size: 1.1em;">Главный экран</span>

<span style="font-size: 1.1em;">Профиль пользователя</span>

<span style="font-size: 1.1em;">Тренировки</span>


<span style="font-size: 1.4em;">Возможности</span>
Просмотр и запуск тренировок
Отслеживание прогресса
Подсчет калорий
Профиль пользователя
Разные уровни тренировок (Beginner / Intermediate / Advanced)
Избранные тренировки


<span style="font-size: 1.4em;">Архитектура</span>
```
data/
 ├── datastore/
 ├── repository/

domain/
 ├── models/
 ├── repository/
 ├── usecase/

ui/
 ├── screens/
 ├── uikit/
 ├── utils/
```

<span style="font-size: 1.4em;">Используемые паттерны:</span>
* MVVM (ViewModel)
* MVI (State / Action / SideEffect)


<span style="font-size: 1.4em;">Технологии</span>
**Kotlin**
**Jetpack Compose**
**Coroutines / Flow**
**Firebase Authentication**
**DataStore**


<span style="font-size: 1.4em;">Аутентификация</span>
Для авторизации используется **Firebase Auth**:

* регистрация
* вход пользователя
* управление сессией


<span style="font-size: 1.4em;">Хранение данных</span>
* Локальное хранение: **DataStore**
* Асинхронная работа: **Coroutines + Flow**

<span style="font-size: 1.4em;">Пример структуры экрана (MVI)</span>
```
EditeProfile/
 ├── EditeProfileScreen
 ├── EditeProfileViewModel
 ├── action/
      ├── EditeProfileState
      ├── EditeProfileAction
      ├── EditeProfileSideEffect
```

<span style="font-size: 1.4em;">Дизайн</span>
Приложение реализовано на основе UI Kit для фитнес-приложений:

* 90+ экранов (частично реализованы)
* 50+ UI компонентов
* Современный и интуитивный UX
