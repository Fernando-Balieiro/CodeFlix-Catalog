package com.codeflix.admin.catalog.application.category.create

import arrow.core.Either
import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryGateway
import com.codeflix.admin.catalog.domain.validation.handler.Notification

class DefaultCreateCategoryUseCase(
    private val categoryGateway: CategoryGateway
): CreateCategoryUseCase {
    override fun execute(input: CreateCategoryCommand): Either<Notification, CreateCategoryOutput> {
        val aName = input.name
        val aDescription = input.description
        val isActive = input.isActive

        val notification = Notification.new()

        val aCategory = Category.new(aName, aDescription, isActive)
        aCategory.validate(notification)

        return if (notification.hasErrors()) Either.Left(notification) else create(aCategory)
    }

    private fun create(category: Category): Either<Notification, CreateCategoryOutput> {
        return try {
            val output = categoryGateway.create(category)
            Either.Right(CreateCategoryOutput.from(output))
        } catch (e: Exception) {
            Either.Left(Notification.new())
        }
    }

}