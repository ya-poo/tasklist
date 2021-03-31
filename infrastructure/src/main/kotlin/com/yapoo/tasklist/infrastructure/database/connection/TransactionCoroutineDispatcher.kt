package com.yapoo.tasklist.infrastructure.database.connection

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction as exposedTransaction

interface TransactionCoroutineDispatcher {

    suspend fun <T> newSuspendedTransaction(
        statement: suspend Transaction.() -> T
    ): T

    interface Dependencies {
        val database: Database
    }
}

class TransactionCoroutineDispatcherImpl(d: TransactionCoroutineDispatcher.Dependencies) :
    TransactionCoroutineDispatcher,
    TransactionCoroutineDispatcher.Dependencies by d {

    override suspend fun <T> newSuspendedTransaction(
        statement: suspend Transaction.() -> T
    ): T {
        return exposedTransaction(Dispatchers.IO, database, statement)
    }

}
