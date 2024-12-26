package data.database

import data.domain.DatabaseRepository
import models.CheckIn

internal class DatabaseRepositoryImpl(
    private val database: Database,
) : DatabaseRepository {

    override suspend fun getAllCheckIns(): List<CheckIn> =
        database.getAllCheckIns()

    override suspend fun insertCheckIn(checkIn: CheckIn) {
        database.insertCheckIn(checkIn)
    }

    override suspend fun getCheckInForPeriod(
        startPeriod: Long,
        endPeriod: Long
    ): List<CheckIn> = database.getCheckInForPeriod(startPeriod, endPeriod)

    override suspend fun getCheckInForPeriodByFactorId(
        startPeriod: Long,
        endPeriod: Long,
        factorId: Int
    ): List<CheckIn> =
        database.getCheckInForPeriodByFactorId(
            startPeriod.toString(), endPeriod.toString(), factorId.toLong()
        )

    override suspend fun insertListOfCheckIns(checkIns: List<CheckIn>) {
        checkIns.forEach {
            insertCheckIn(it)
        }
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