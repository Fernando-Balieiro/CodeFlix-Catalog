package com.codeflix.admin.catalog.domain.category

import com.codeflix.admin.catalog.domain.validation.Error
import com.codeflix.admin.catalog.domain.validation.ValidationHandler
import com.codeflix.admin.catalog.domain.validation.Validator

class CategoryValidator(
    private val category: Category,
    handler: ValidationHandler
    ): Validator(handler) {

    companion object {
        const val NAME_MAX_LENGTH = 255
        const val NAME_MIN_LENGTH = 3
    }

    private fun checkNameConstraint() {
        val name = category.categoryName
        if (name.isBlank()) {
            validationHandler().append(Error("'Name' should not be empty"))
        }

        val length = name.trim().length
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            validationHandler().append(Error("'name' must be between 3 and 255 characters"))
        }
    }

    override fun validate() {
        checkNameConstraint()
    }
}