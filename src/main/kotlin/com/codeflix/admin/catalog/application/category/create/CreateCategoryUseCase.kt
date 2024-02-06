package com.codeflix.admin.catalog.application.category.create

import arrow.core.Either
import com.codeflix.admin.catalog.application.UseCase
import com.codeflix.admin.catalog.domain.validation.handler.Notification

interface CreateCategoryUseCase: UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}