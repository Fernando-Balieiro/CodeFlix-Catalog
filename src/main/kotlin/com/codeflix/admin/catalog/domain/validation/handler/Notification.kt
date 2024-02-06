package com.codeflix.admin.catalog.domain.validation.handler

import com.codeflix.admin.catalog.domain.exceptions.DomainException
import com.codeflix.admin.catalog.domain.validation.Error
import com.codeflix.admin.catalog.domain.validation.Validation
import com.codeflix.admin.catalog.domain.validation.ValidationHandler

class Notification private constructor(
    private val errors: MutableList<Error>
): ValidationHandler {

    override fun append(error: Error): ValidationHandler {
        this.errors.add(error)
        return this
    }

    override fun append(validationHandler: ValidationHandler): Notification {
        this.errors.addAll(validationHandler.getErrors())
        return this
    }

    override fun validate(validation: Validation): ValidationHandler {
        try {
            validation.validate()
        } catch (de: DomainException) {
            this.errors.addAll(de.getErrors())
        } catch (t: Throwable) {
            this.errors.add(Error(t.message.toString()))
        }

        return this
    }

    override fun getErrors(): List<Error> {
        return this.errors
    }

    companion object {
        fun new(t: Throwable): Notification {
            return new(Error(t.message))
        }

        fun new(): Notification {
            return Notification(arrayListOf())
        }

        fun new(error: Error): Notification {
            val notification = Notification(mutableListOf())
            notification.append(error)
            return notification
        }
    }
}