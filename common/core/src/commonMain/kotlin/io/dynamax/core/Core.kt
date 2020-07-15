package io.dynamax.core

import io.dynamax.core.utils.CoroutinesDispatcher
import io.dynamax.repository.TodoRepository

class Core {
    suspend fun getTodo(): String {
        return TodoRepository().getTodo(CoroutinesDispatcher().ioDispatcher)
    }
}