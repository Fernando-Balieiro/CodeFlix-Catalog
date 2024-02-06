package com.codeflix.admin.catalog.application.category.retrieve.get

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryGateway
import com.codeflix.admin.catalog.domain.category.CategoryId
import com.codeflix.admin.catalog.domain.exceptions.DomainException
import com.codeflix.admin.catalog.domain.validation.Error
import org.apache.logging.log4j.util.Supplier

class DefaultGetCategoryByIdUseCase(
    private val categoryGateway: CategoryGateway
): GetCategoryByIdUseCase {
    override fun execute(input: String): CategoryOutput {
        val aCategoryId = CategoryId.from(input)
        val aCategory = categoryGateway.findById(aCategoryId)
        if (aCategory == null) {
            notFound(aCategoryId)
        }
        return CategoryOutput.from(aCategory as Category)
    }
    private fun notFound(anId: CategoryId): () -> DomainException {
        return {
            DomainException.new(
                Error("Category with ID %s was not found".format(anId.getValue()))
            )
        }
    }
}