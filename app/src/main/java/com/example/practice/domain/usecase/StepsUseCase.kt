package com.example.practice.domain.usecase

import com.example.practice.domain.models.Gender
import com.example.practice.domain.models.StepsActivityStats
import com.example.practice.domain.models.StepsRecord
import com.example.practice.domain.models.StepsType
import com.example.practice.domain.models.UserProfile
import com.example.practice.domain.repository.StepsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlin.math.roundToInt

class StepsUseCase(
    private val repository: StepsRepository,
    private val getUserProfile: GetUserProfileUseCase
) {
    suspend fun saveAndUpdateSteps(steps: StepsType) {
        repository.saveAndUpdateSteps(steps)
    }

    fun getStepsForAPeriod(fromMillis: Long, toMillis: Long): Flow<List<StepsType>> {
        return repository.getStepsForAPeriod(
            fromMillis = fromMillis,
            toMillis = toMillis
        )
    }

    fun getStepsSumForAPeriod(fromMillis: Long, toMillis: Long): Flow<Int> {
        return repository.getStepsSumForAPeriod(
            fromMillis = fromMillis,
            toMillis = toMillis
        )
    }

    fun getStepsActivityStatsForAPeriod(fromMillis: Long, toMillis: Long): Flow<StepsActivityStats> {
        return getStepsSumForAPeriod(
            fromMillis = fromMillis,
            toMillis = toMillis
        ).withActivityStatsFromSteps()
    }

    private fun calculateDistanceMeters(
        steps: Int,
        profile: UserProfile
    ): Float {
        if (profile.height <= 0) return 0f

        val coefficient = when (profile.gender) {
            Gender.MALE -> 0.415f
            Gender.FEMALE -> 0.413f
        }

        val stepLengthMeters = profile.height / 100f * coefficient
        return steps * stepLengthMeters
    }

    private fun calculateCalories(
        distanceMeters: Float,
        profile: UserProfile
    ): Int {
        if (distanceMeters <= 0f) return 0

        val weightKg = profile.weight.takeIf { it > 0f } ?: DEFAULT_WEIGHT_KG
        val distanceKm = distanceMeters / METERS_IN_KILOMETER

        return (distanceKm * weightKg * WALKING_CALORIES_PER_KG_PER_KM).roundToInt()
    }

    private fun Flow<Int>.withActivityStatsFromSteps(): Flow<StepsActivityStats> {
        return combine(getUserProfile()) { steps, profile ->
            val distanceMeters = calculateDistanceMeters(
                steps = steps,
                profile = profile
            )

            StepsActivityStats(
                steps = steps,
                distanceMeters = distanceMeters,
                calories = calculateCalories(
                    distanceMeters = distanceMeters,
                    profile = profile
                )
            )
        }
    }

    private fun Flow<StepsRecord>.withActivityStatsFromRecord(): Flow<StepsRecord> {
        return combine(getUserProfile()) { record, profile ->
            val distanceMeters = calculateDistanceMeters(
                steps = record.steps,
                profile = profile
            )

            record.copy(
                distanceMeters = distanceMeters,
                calories = calculateCalories(
                    distanceMeters = distanceMeters,
                    profile = profile
                )
            )
        }
    }

    fun getRecordDay(): Flow<StepsRecord> = repository.getRecordDay().withActivityStatsFromRecord()
    fun getRecordWeek(): Flow<StepsRecord> = repository.getRecordWeek().withActivityStatsFromRecord()
    fun getRecordMonth(): Flow<StepsRecord> = repository.getRecordMonth().withActivityStatsFromRecord()
    fun getRecordYear(): Flow<StepsRecord> = repository.getRecordYear().withActivityStatsFromRecord()

    fun getPermissionSteps(): Flow<Boolean> {
        return repository.getPermissionSteps()
    }

    suspend fun setPermissionSteps(permission: Boolean) {
        repository.setPermissionSteps(permission)
    }

    private companion object {
        const val METERS_IN_KILOMETER = 1000f
        const val DEFAULT_WEIGHT_KG = 70f
        const val WALKING_CALORIES_PER_KG_PER_KM = 0.5f
    }
}
