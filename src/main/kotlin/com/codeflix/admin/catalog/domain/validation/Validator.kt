package com.codeflix.admin.catalog.domain.validation

abstract class Validator(
    private val handler: ValidationHandler
) {
    abstract fun validate()
    protected fun validationHandler() : ValidationHandler = handler
}