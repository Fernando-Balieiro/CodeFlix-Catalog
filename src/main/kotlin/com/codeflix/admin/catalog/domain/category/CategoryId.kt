package com.codeflix.admin.catalog.domain.category

import com.codeflix.admin.catalog.domain.Identifier
import java.util.Objects
import java.util.UUID

data class CategoryId private constructor(
    private val value: String
) : Identifier{

    init {
        Objects.requireNonNull(value)
    }

    companion object {
        fun unique(): CategoryId {
            return from(UUID.randomUUID())
        }

        fun from(anId : String): CategoryId {
            return CategoryId(anId)
        }

        private fun from(anId: UUID): CategoryId {
            return CategoryId(anId.toString())
        }
    }

    fun getValue(): String {
        return value
    }
}