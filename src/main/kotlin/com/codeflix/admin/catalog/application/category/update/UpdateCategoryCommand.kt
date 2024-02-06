package com.codeflix.admin.catalog.application.category.update

@JvmRecord
data class UpdateCategoryCommand(
    val id: String,
    val name: String,
    val description: String,
    val isActive: Boolean
) {
    companion object {
        fun new(anId: String,
                aName: String,
                aDescription: String,
                isActive: Boolean
        ): UpdateCategoryCommand {
            return UpdateCategoryCommand(anId,
                aName,
                aDescription,
                isActive
            )
        }
    }
}
