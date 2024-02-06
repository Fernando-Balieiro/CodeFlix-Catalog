package com.codeflix.admin.catalog.domain.category

@JvmRecord
data class CategorySearchQuery(
    val page: Int,
    val perPage: Int,
    val terms: String,
    val sort: String,
    val direction: String
) { }
