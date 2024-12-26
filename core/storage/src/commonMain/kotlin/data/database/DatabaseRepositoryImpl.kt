package data.database

import data.domain.DatabaseRepository
import models.CheckIn

internal class DatabaseRepositoryImpl(
    private val database: Database,
) : DatabaseRepository {

    override suspend fun getAllCheckIns(): List<CheckIn> {
        return database.getAllCheckIns()
    }

    override suspend fun insertCheckIn(checkIn: CheckIn) {
        TODO("Not yet implemented")
    }

    override suspend fun getCheckInForPeriod(startPeriod: Long, endPeriod: Long): List<CheckIn> {
        TODO("Not yet implemented")
    }

    override suspend fun getCheckInForPeriodByFactorId(startPeriod: Long, endPeriod: Long, factorId: Int): List<CheckIn> {
        TODO("Not yet implemented")
    }

    override suspend fun insertListOfCheckIns(list: List<CheckIn>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteListOfCheckIns(checkIns: List<CheckIn>) {
        TODO("Not yet implemented")
    }

    override suspend fun getCountCheckIns(): Long {
        TODO("Not yet implemented")
    }

    override suspend fun getCountCheckInsByFactor(factorId: Int): Long {
        TODO("Not yet implemented")
    }
}