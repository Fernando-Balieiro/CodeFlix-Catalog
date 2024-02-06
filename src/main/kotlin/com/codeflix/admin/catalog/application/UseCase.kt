package com.codeflix.admin.catalog.application

interface UseCase<INPUT, OUTPUT> {
    fun execute(input: INPUT): OUTPUT
}