package data

import data.database.Database
import domain.CheckInRepository
import models.CheckIn

internal class CheckInRepositoryImpl(
    private val database: Database,
) : CheckInRepository {

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