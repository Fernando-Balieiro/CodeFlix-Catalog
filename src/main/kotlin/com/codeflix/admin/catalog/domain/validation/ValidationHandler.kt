package com.codeflix.admin.catalog.domain.validation

interface ValidationHandler {
    fun append(error: Error) : ValidationHandler
    fun append(validationHandler: ValidationHandler) : ValidationHandler
    fun validate(validation: Validation) : ValidationHandler

    fun hasErrors() : Boolean {
        return getErrors().isNotEmpty()
    }

    fun firstError() : Error? {
        if (getErrors().isNotEmpty()) {
            return getErrors()[0]
        }
        return null
    }

    fun getErrors() : List<Error>

}