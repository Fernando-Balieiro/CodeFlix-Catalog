package com.codeflix.admin.catalog.application.category.retrieve.get

import com.codeflix.admin.catalog.application.UseCase

interface GetCategoryByIdUseCase: UseCase<String, CategoryOutput> {
}