package io.github.newlight77.bootstrap

import io.github.newlight77.bootstrap.note.api.INoteRepository
import io.github.newlight77.bootstrap.note.model.NoteDomain
import io.github.newlight77.bootstrap.note.model.NoteModel
import io.github.newlight77.bootstrap.note.model.toDomain
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val repository: INoteRepository<NoteDomain, Long>) : ApplicationRunner {
    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        modelData().map { toDomain(it) }
              .forEach() {
            repository.save(it)
        }
        repository.findAll().forEach { println(it) }
    }
}

fun modelData(): List<NoteModel> {
    return listOf(
            NoteModel(title = "Note 1", text = "empty", author = "user"),
            NoteModel(title = "Note 2", text = "empty", author = "user"),
            NoteModel(title = "Note 3", text = "empty", author = "user")
    )
}