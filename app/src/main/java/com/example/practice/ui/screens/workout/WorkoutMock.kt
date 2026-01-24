package com.example.practice.ui.screens.workout


import com.example.practice.R
import com.example.practice.ui.screens.workout.intents.Workout
import com.example.practice.ui.screens.workout.intents.WorkoutFilter
import com.example.practice.ui.screens.workoutrounddetail.intents.WorkoutDetails
import com.example.practice.ui.screens.workoutrounds.intents.WorkoutBadgeItem
import io.github.composegears.valkyrie.Icons
import io.github.composegears.valkyrie.PlayOff
import io.github.composegears.valkyrie.PlayOn
import io.github.composegears.valkyrie.TimeDefault

val workouts = listOf(

    /* -------------------- BEGINNER -------------------- */

    Workout(
        id = 1,
        filter = WorkoutFilter.BEGINNER,
        title = "Upper Body",
        duration = "60 Minutes",
        calories = "1320 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.woman_helping_man_gym_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Dumbbell Rows", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Russian Twists", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOn,  "Squats", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Tabata Intervals", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Bicycle Crunches", Icons.TimeDefault, "00:10", "4x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 2,
        filter = WorkoutFilter.BEGINNER,
        title = "Full Body Stretching",
        duration = "45 Minutes",
        calories = "1450 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.woman_helping_man_gym_3,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Dumbbell Rows", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Russian Twists", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOn,  "Squats", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Tabata Intervals", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Bicycle Crunches", Icons.TimeDefault, "00:10", "4x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 3,
        filter = WorkoutFilter.BEGINNER,
        title = "Glutes & Abs",
        duration = "12 Minutes",
        calories = "120 Cal",
        exercises = "3 Exercises",
        imageRes = R.mipmap.woman_working_out_gym_2_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Dumbbell Rows", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Russian Twists", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOn,  "Squats", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Tabata Intervals", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Bicycle Crunches", Icons.TimeDefault, "00:10", "4x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    /* -------------------- INTERMEDIATE -------------------- */

    Workout(
        id = 4,
        filter = WorkoutFilter.INTERMEDIATE,
        title = "Circuit Training",
        duration = "50 Minutes",
        calories = "1300 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Kettlebell Swing", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Shoulder Press", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Bicep Curls", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Barbell deadlift", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 5,
        filter = WorkoutFilter.INTERMEDIATE,
        title = "Split Strength Training",
        duration = "12 Minutes",
        calories = "1250 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Kettlebell Swing", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Shoulder Press", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Bicep Curls", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Barbell deadlift", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 6,
        filter = WorkoutFilter.INTERMEDIATE,
        title = "Resistance Training",
        duration = "12 Minutes",
        calories = "120 Kcal",
        exercises = "3 Exercises",
        imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Kettlebell Swing", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Shoulder Press", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Bicep Curls", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Barbell deadlift", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Hamstring Curls", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),


    /* -------------------- ADVANCED -------------------- */

    Workout(
        id = 7,
        filter = WorkoutFilter.ADVANCED,
        title = "Upper Body Strength",
        duration = "60 Minutes",
        calories = "1450 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.woman_helping_man_gym_5,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Barbell Bench Press", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Tricep Dips", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Romanian Deadlifts", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Foam Rolling", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 8,
        filter = WorkoutFilter.ADVANCED,
        title = "Hypertrophy – Legs",
        duration = "12 Minutes",
        calories = "1250 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Barbell Bench Press", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Tricep Dips", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Romanian Deadlifts", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Foam Rolling", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    ),

    Workout(
        id = 9,
        filter = WorkoutFilter.ADVANCED,
        title = "Rest or Active Recovery",
        duration = "12 Minutes",
        calories = "120 Kcal",
        exercises = "5 Exercises",
        imageRes = R.mipmap.full_shot_woman_lifting_her_leg_1,
        rounds = listOf(
            WorkoutBadgeItem.Item(1, Icons.PlayOff, "Barbell Bench Press", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(2, Icons.PlayOff, "Tricep Dips", Icons.TimeDefault, "00:15", "2x"),
            WorkoutBadgeItem.Item(3, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x"),
            WorkoutBadgeItem.Item(4, Icons.PlayOff, "Romanian Deadlifts", Icons.TimeDefault, "00:10", "2x"),
            WorkoutBadgeItem.Item(5, Icons.PlayOff, "Foam Rolling", Icons.TimeDefault, "00:10", "4x"),
            WorkoutBadgeItem.Item(6, Icons.PlayOff, "Incline Bench Sit Up", Icons.TimeDefault, "00:30", "3x")
        ),
        details = listOf(
            WorkoutDetails.Item(1, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(2, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(3, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(4, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
            WorkoutDetails.Item(5, R.mipmap.woman_helping_man_gym_1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus libero eget.", "30 Second", "3"),
        )
    )
)