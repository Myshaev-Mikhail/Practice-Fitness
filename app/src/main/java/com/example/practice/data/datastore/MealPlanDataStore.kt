package com.example.practice.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.practice.domain.models.Allergy
import com.example.practice.domain.models.CalorieGoal
import com.example.practice.domain.models.CookingTime
import com.example.practice.domain.models.DietaryPreference
import com.example.practice.domain.models.MealPlanPreferences
import com.example.practice.domain.models.MealType
import com.example.practice.domain.models.ServingsOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MealPlanDataStore(
    private val dataStore: DataStore<Preferences>
) {
    val mealPlanFlow: Flow<MealPlanPreferences> = dataStore.data.map { preferences ->
        MealPlanPreferences(
            dietaryPreferences = preferences[Keys.DIETARY]?.let { ids ->
                ids.map { enumValueOf<DietaryPreference>(it) }.toSet()
            },
            allergens = preferences[Keys.ALLERGENS]?.let { ids ->
                ids.map { enumValueOf<Allergy>(it) }.toSet()
            },
            mealTypes = preferences[Keys.MEALS]?.let { ids ->
                ids.map { enumValueOf<MealType>(it) }.toSet()
            } ?: emptySet(),
            calorieGoal = preferences[Keys.CALORIES]?.let {
                enumValueOf<CalorieGoal>(it)
            },
            cookingTime = preferences[Keys.TIME]?.let {
                enumValueOf<CookingTime>(it)
            },
            servings = preferences[Keys.SERVINGS]?.let {
                enumValueOf<ServingsOption>(it)
            }
        )
    }

    suspend fun save(value: MealPlanPreferences) {
        dataStore.edit { prefs ->
            fun <T> putOrRemove(key: Preferences.Key<T>, value: T?) {
                if (value == null) prefs.remove(key) else prefs[key] = value
            }

            putOrRemove(Keys.DIETARY, value.dietaryPreferences?.map { it.name }?.toSet())
            putOrRemove(Keys.ALLERGENS, value.allergens?.map { it.name }?.toSet())
            prefs[Keys.MEALS] = value.mealTypes.map { it.name }.toSet()
            putOrRemove(Keys.CALORIES, value.calorieGoal?.name)
            putOrRemove(Keys.TIME, value.cookingTime?.name)
            putOrRemove(Keys.SERVINGS, value.servings?.name)
        }
    }

    private object Keys {
        val DIETARY = stringSetPreferencesKey("meal_plan_dietary_ids")
        val ALLERGENS = stringSetPreferencesKey("meal_plan_allergen_ids")
        val MEALS = stringSetPreferencesKey("meal_plan_meal_ids")
        val CALORIES = stringPreferencesKey("meal_plan_calorie_id")
        val TIME = stringPreferencesKey("meal_plan_time_id")
        val SERVINGS = stringPreferencesKey("meal_plan_servings_id")
    }
}