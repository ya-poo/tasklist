package com.yapoo.tasklist.infrastructure.database.connection

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

interface TransactionCoroutineDispatcher {

    suspend fun <T> transaction(
        statement: suspend Transaction.() -> T
    ): T

    interface Dependencies {
        val database: Database
    }
}

internal class TransactionCoroutineDispatcherImpl(private val d: TransactionCoroutineDispatcher.Dependencies) :
    TransactionCoroutineDispatcher,
    TransactionCoroutineDispatcher.Dependencies by d {

    override suspend fun <T> transaction(
        statement: suspend Transaction.() -> T
    ): T {
        val currentTransaction = TransactionManager.currentOrNull()

        return if (currentTransaction == null) {
            newSuspendedTransaction(Dispatchers.IO, database, statement)
        } else {
            currentTransaction.statement()
        }
    }
}
