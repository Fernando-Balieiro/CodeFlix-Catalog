package com.codeflix.admin.catalog.application.category.delete

import com.codeflix.admin.catalog.domain.category.CategoryGateway
import com.codeflix.admin.catalog.domain.category.CategoryId

class DefaultDeleteCategoryUseCase(
    private val categoryGateway: CategoryGateway
): DeleteCategoryUseCase {

    override fun execute(input: String) {
        this.categoryGateway
            .deleteById(CategoryId.Companion.from(input))
    }
}