package br.com.dojo.project.interactor.model

sealed class ValidationError {
    object AmountWrongRange : ValidationError()
}