package com.codeflix.admin.catalog.domain.pagination

@JvmRecord
data class Pagination<T>(
    val currentPage: Int,
    val perPage: Int,
    val total: Long,
    val items: List<T>
) {

    fun <R> map(mapper: (T) -> R): Pagination<R> {
        val aNewList: MutableList<R> =
            items.stream().map { mapper(it) }.toList()

        return Pagination(currentPage, perPage, total, aNewList)
    }
}