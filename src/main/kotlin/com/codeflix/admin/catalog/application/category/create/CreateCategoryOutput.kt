package com.codeflix.admin.catalog.application.category.create

import com.codeflix.admin.catalog.domain.category.Category

@JvmRecord
data class CreateCategoryOutput(
    val id: String
) {
    companion object {
        fun from(id: String): CreateCategoryOutput {
            return CreateCategoryOutput(id)
        }

        fun from(category: Category): CreateCategoryOutput {
            return CreateCategoryOutput(category.getId().getValue())
        }
    }
}
