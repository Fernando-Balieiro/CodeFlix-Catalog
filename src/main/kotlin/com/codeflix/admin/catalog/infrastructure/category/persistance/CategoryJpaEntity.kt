package com.codeflix.admin.catalog.infrastructure.category.persistance

import com.codeflix.admin.catalog.domain.category.Category
import com.codeflix.admin.catalog.domain.category.CategoryId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "category")
class CategoryJpaEntity private constructor(
    @Id
    private var id: String,
    @Column(name = "name", nullable = false)
    private var name: String,

    @Column(name = "description", length = 4000, nullable = true)
    private var description: String?,

    @Column(name = "active", nullable = false)
    private var active: Boolean,

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
    private var createdAt: Instant,


    @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
    private var updatedAt: Instant,

    @Column(name = "deleted_at", nullable = true, columnDefinition = "DATETIME(6)")
    private var deletedAt: Instant?
) {

    constructor(): this("", "", null, true, Instant.now(), Instant.now(), null)


    companion object {
        fun from(category: Category): CategoryJpaEntity {
            return CategoryJpaEntity(
                category.getId().getValue(),
                category.categoryName,
                category.categoryDescription,
                category.categoryIsActive,
                category.categoryCreatedAt,
                category.categoryUpdatedAt,
                category.categoryDeletedAt
            )
        }
    }

    fun toAggregate(): Category {
        return Category.with(
            CategoryId.from(id),
            name,
            description,
            active,
            createdAt,
            updatedAt,
            deletedAt,
        )
    }
}