package com.codeflix.admin.catalog.domain.category

import com.codeflix.admin.catalog.domain.pagination.Pagination

interface CategoryGateway {
    fun create(category: Category): Category
    fun deleteById(categoryId: CategoryId)
    fun findById(categoryId: CategoryId): Category?
    fun update(category: Category): Category
    fun findAll(categorySearchQuery: CategorySearchQuery): Pagination<Category>
}