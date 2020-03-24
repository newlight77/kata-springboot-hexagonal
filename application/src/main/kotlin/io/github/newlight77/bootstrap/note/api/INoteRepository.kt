package io.github.newlight77.bootstrap.note.api

interface INoteRepository<T, U> {
    fun save(note: T)
    fun findAll(): List<T>
    fun findAllByUser(name: String): List<T>
}