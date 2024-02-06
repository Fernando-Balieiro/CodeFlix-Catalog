package com.codeflix.admin.catalog.domain

import java.util.Objects

abstract class Entity<ID : Identifier>(private val id: ID) {

    init {
        Objects.requireNonNull(id, "'id' should not be null")
    }
//    abstract fun validate(handler: ValidationHandler) {}

    public fun getId() : ID {
        return id;
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
