package com.codeflix.admin.catalog.application.category.retrieve.list

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryGateway
import com.codeflix.admin.catalog.domain.category.CategorySearchQuery
import com.codeflix.admin.catalog.domain.pagination.Pagination

class DefaultListCategoriesUseCase(
    private val categoryGateway: CategoryGateway
): ListCategoriesUseCase {
    override fun execute(input: CategorySearchQuery): Pagination<CategoryListOutput> {
        val output =
            categoryGateway.findAll(input)
            .map { CategoryListOutput.from(it) }

        return output
    }
}