package com.codeflix.admin.catalog.domain

abstract class AggregateRoot<ID : Identifier>(id: ID)
    : Entity<ID>(id) {
}