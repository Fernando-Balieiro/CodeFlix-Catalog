package com.codeflix.admin.catalog.domain.category

import com.codeflix.admin.catalog.domain.AggregateRoot
import com.codeflix.admin.catalog.domain.validation.ValidationHandler
import java.time.Instant

data class Category private constructor(
    private val id: CategoryId,
    private var name: String,
    private var description: String?,
    private var isActive: Boolean,
    private val createdAt: Instant,
    private var updatedAt: Instant,
    private var deletedAt: Instant?
) : AggregateRoot<CategoryId>(id){

    var categoryName: String
        get() = this.name
        set(value) {
            name = value
        }

    var categoryDescription: String?
        get() = description
        set(value) {
            description = value
        }

    var categoryIsActive
        get() = isActive
        set(value) {
            isActive = value
        }

    val categoryCreatedAt
        get() = createdAt

    val categoryUpdatedAt
        get() = updatedAt

    val categoryDeletedAt
        get() = deletedAt


    companion object {
        fun new(name: String, description: String, isActive: Boolean): Category {
            val id = CategoryId.unique()
            val now = Instant.now()
            val deletedAt = if (isActive) null else now
            return Category(id, name, description, isActive, now, now, deletedAt)
        }

        fun new(id: CategoryId,
                name: String,
                description: String?,
                isActive: Boolean,
                createdAt: Instant,
                updatedAt: Instant,
                deletedAt: Instant?,
        ) : Category {
            return Category(id, name, description, isActive, createdAt, updatedAt, deletedAt)
        }

        fun new(aCategory: Category): Category {
            return new(
                aCategory.id,
                aCategory.name,
                aCategory.description,
                aCategory.isActive,
                aCategory.createdAt,
                aCategory.updatedAt,
                aCategory.deletedAt,
            )
        }

        fun with(from: CategoryId,
                 categoryJpaName: String,
                 categoryJpaDescription: String?,
                 categoryJpaIsActive: Boolean,
                 categoryJpaCreatedAt: Instant,
                 categoryJpaUpdatedAt: Instant,
                 categoryJpaDeletedAt: Instant?
        ): Category {
            return Category(
                from,
                categoryJpaName,
                categoryJpaDescription,
                categoryJpaIsActive,
                categoryJpaCreatedAt,
                categoryJpaUpdatedAt,
                categoryJpaDeletedAt
            )
        }
    }

    fun validate(validationHandler: ValidationHandler) {
        CategoryValidator(this, validationHandler).validate()
    }

    fun activate(): Category {
        this.deletedAt = null
        this.isActive = true
        this.updatedAt = Instant.now()

        return this
    }

    fun deactivate(): Category {
        if (this.deletedAt == null) {
            this.deletedAt = Instant.now()
        }
        this.isActive = false
        this.updatedAt = Instant.now()

        return this
    }

    fun update(
        name: String,
        description: String,
    ): Category {

        when (this.isActive) {
            true -> activate()
            false -> deactivate()
        }

        this.name = name
        this.description = description
        this.updatedAt = Instant.now()

        return this
    }
}