package com.codeflix.admin.catalog.domain.exceptions

import com.codeflix.admin.catalog.domain.validation.Error

class DomainException private constructor(
    message: String,
    private val errors: List<Error>
) : NoStackTraceException(message) {

    fun getErrors(): List<Error> {
        return errors
    }

    companion object {
        fun new(error: Error): DomainException {
            return DomainException(error.message, listOf(error))
        }

        fun new(errorList: List<Error>): DomainException {
            return DomainException("", errorList)
        }

    }
}