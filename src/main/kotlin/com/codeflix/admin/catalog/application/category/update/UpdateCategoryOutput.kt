package com.codeflix.admin.catalog.application.category.update

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryId

@JvmRecord
data class UpdateCategoryOutput(
    val id: CategoryId
) {
    companion object {
        fun from(aCategory: Category): UpdateCategoryOutput {
            return UpdateCategoryOutput(aCategory.getId())
        }
    }
}
