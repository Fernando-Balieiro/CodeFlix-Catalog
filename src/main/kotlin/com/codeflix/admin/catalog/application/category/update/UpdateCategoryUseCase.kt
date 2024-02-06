package com.codeflix.admin.catalog.application.category.update

import arrow.core.Either
import com.codeflix.admin.catalog.application.UseCase
import com.codeflix.admin.catalog.domain.validation.handler.Notification

interface UpdateCategoryUseCase
    : UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}