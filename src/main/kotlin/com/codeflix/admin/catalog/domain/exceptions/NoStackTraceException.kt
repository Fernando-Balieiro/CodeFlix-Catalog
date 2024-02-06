package com.codeflix.admin.catalog.domain.exceptions

import com.codeflix.admin.catalog.domain.validation.Error

open class NoStackTraceException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause, true, false) {
    companion object {
        fun fromError(error: Error) : DomainException {
            return DomainException.new(error)
        }
    }
}