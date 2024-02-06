package com.codeflix.admin.catalog.application.category.create

@JvmRecord
data class CreateCategoryCommand(
    val name: String,
    val description: String,
    val isActive: Boolean
) {
    companion object {
        fun new(
            name: String,
            description: String,
            isActive: Boolean
            ): CreateCategoryCommand {
            return CreateCategoryCommand(name, description, isActive)
        }
    }
}
