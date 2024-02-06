package com.codeflix.admin.catalog.application

interface UnitUseCase<INPUT> {
    fun execute(input: INPUT)
}