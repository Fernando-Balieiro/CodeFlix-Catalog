package com.codeflix.admin.catalog.application

interface NullaryUseCase<OUTPUT> {
    fun execute(): OUTPUT
}