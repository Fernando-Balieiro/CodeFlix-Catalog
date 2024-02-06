package com.codeflix.admin.catalog.application.category.update

import arrow.core.Either
import arrow.core.Ior
import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryGateway
import com.codeflix.admin.catalog.domain.category.CategoryId
import com.codeflix.admin.catalog.domain.exceptions.DomainException
import com.codeflix.admin.catalog.domain.validation.Error
import com.codeflix.admin.catalog.domain.validation.handler.Notification
import org.apache.logging.log4j.util.Supplier

class DefaultUpdateCategoryUseCase(
    private val categoryGateway: CategoryGateway
): UpdateCategoryUseCase {
    override fun execute(input: UpdateCategoryCommand): Either<Notification, UpdateCategoryOutput> {
        val anId = CategoryId.from(input.id)
        val name = input.name
        val description = input.description
        val isActive = input.isActive

        val notification = Notification.new()
        val aCategory = this.categoryGateway.findById(anId)

        when (aCategory) {
            null -> notFound(anId)
            else -> {
                aCategory
                    .update(name, description)
                    .validate(notification)
            }
        }


        return if (notification.hasErrors()) Either.Left(notification) else update(aCategory as Category)

    }


    private fun update(aCategory: Category): Either<Notification, UpdateCategoryOutput> {
        return try {
            val output = categoryGateway.update(aCategory)
            Either.Right(UpdateCategoryOutput.from(aCategory))
        } catch (e: Exception) {
            Either.Left(Notification.new())
        }
    }

    private fun notFound(anId: CategoryId): Supplier<DomainException> {
        return Supplier {
            DomainException.new(
                Error("Category with ID %s was not found".format(anId.getValue()))
            )
        }
    }
}