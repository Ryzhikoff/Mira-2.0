package data.database

import site.pnpl.mira.data.database.AppDatabase
import site.pnpl.mira.data.database.DatabaseDriverFactory

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

//    internal
}