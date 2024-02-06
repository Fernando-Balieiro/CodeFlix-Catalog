package com.codeflix.admin.catalog.domain.validation.handler

import com.codeflix.admin.catalog.domain.exceptions.DomainException
import com.codeflix.admin.catalog.domain.validation.Error
import com.codeflix.admin.catalog.domain.validation.Validation
import com.codeflix.admin.catalog.domain.validation.ValidationHandler
import com.sun.net.httpserver.Authenticator.Failure
import com.sun.net.httpserver.Authenticator.Success

class ThrowsValidationHandler: ValidationHandler {
    override fun append(error: Error): ValidationHandler {
        throw DomainException.new(error)
    }

    override fun append(validationHandler: ValidationHandler): ValidationHandler {
        throw DomainException.new(validationHandler.getErrors())
    }

    override fun validate(validation: Validation): ValidationHandler {
        try {
            validation.validate()
        } catch (ex: Exception) {
            throw DomainException.new(Error(ex.message.toString()))
        }

        return this
    }

    override fun getErrors(): List<Error> {
        return listOf()
    }
}