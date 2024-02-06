package com.codeflix.admin.catalog.application.category.retrieve.get

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryId
import java.time.Instant

@JvmRecord
data class CategoryOutput(
    val id: CategoryId,
    val name: String,
    val description: String,
    val isActive: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant?,
) {
    companion object {
        fun from(aCategory: Category): CategoryOutput {
            return CategoryOutput(
                aCategory.getId(),
                aCategory.categoryName,
                aCategory.categoryDescription,
                aCategory.categoryIsActive,
                aCategory.categoryCreatedAt,
                aCategory.categoryUpdatedAt,
                aCategory.categoryDeletedAt,
            )
        }
    }
}
