package domain

import models.CheckIn

interface CheckInRepository {

    suspend fun getAllCheckIns() : List<CheckIn>

    suspend fun insertCheckIn(checkIn: CheckIn)

    suspend fun getCheckInForPeriod(startPeriod: Long, endPeriod: Long): List<CheckIn>

    suspend fun getCheckInForPeriodByFactorId(startPeriod: Long, endPeriod: Long, factorId: Int): List<CheckIn>

    suspend fun insertListOfCheckIns(list: List<CheckIn>)

    suspend fun deleteListOfCheckIns(checkIns: List<CheckIn>)

    suspend fun getCountCheckIns(): Long

    suspend fun getCountCheckInsByFactor(factorId: Int): Long

}