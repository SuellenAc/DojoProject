package br.com.dojo.project.model

enum class Gender {
    FEMALE,
    MALE;

    companion object {
        fun fromString(name: String) = values().find { it.name == name }
    }
}