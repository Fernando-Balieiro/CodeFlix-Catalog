package com.codeflix.admin.catalog.application.category.retrieve.list

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryId
import java.time.Instant

@JvmRecord
data class CategoryListOutput(
    val id: CategoryId,
    val name: String,
    val description: String?,
    val isActive: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant?,
) {

    companion object {

        fun from(category: Category): CategoryListOutput {
            return CategoryListOutput(
                category.getId(),
                category.categoryName,
                category.categoryDescription,
                category.categoryIsActive,
                category.categoryCreatedAt,
                category.categoryUpdatedAt,
                category.categoryDeletedAt
            )
        }
    }
}
