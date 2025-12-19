package com.n1cks.core.domain.model

enum class Genre(val displayName: String) {
    FICTION("Художественная литература"),
    SCIFI("Научная литература"),
    FANTASY("Фантастика"),
    MYSTERY("Мистика"),
    DETECTIVE("Детектив"),
    ROMANCE("Романтика"),
    BIOGRAPHY("Биография"),
    HISTORY("История"),
    SELF_DEVELOPMENT("Саморазвитие"),
    SCIENCE("Наука"),
    POETRY("Поэзия"),
    CHILDREN("Для детей"),
    GRAPHIC_NOVEL("Графический Роман"),
    CLASSIC("Классика");

    companion object{
        val allGenres = entries

        fun fromDisplayName(name : String) : Genre? {
            return allGenres.find { it.displayName == name }
        }
    }
}