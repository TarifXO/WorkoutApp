package com.example.workout

object Constants {
    fun defaultExerciseList() : ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJacks = ExerciseModel(1, "Jumping Jacks", R.drawable.ic_jumping_jacks)
        exerciseList.add(jumpingJacks)

        val lunge = ExerciseModel(2,"Lunge",R.drawable.ic_lunge)
        exerciseList.add(lunge)

        val highKneesRunning = ExerciseModel(3,"High Knees Running In Place",R.drawable.ic_high_knees_running_in_place)
        exerciseList.add(highKneesRunning)

        val stepUpOnChair = ExerciseModel(4,"Step Up On Chair",R.drawable.ic_step_up_onto_chair)
        exerciseList.add(stepUpOnChair)

        val pushUp = ExerciseModel(5,"Push Up",R.drawable.ic_push_up)
        exerciseList.add(pushUp)

        val abdominalCrunch = ExerciseModel(6,"Abdominal Crunch",R.drawable.ic_abdominal_crunch)
        exerciseList.add(abdominalCrunch)

        val tricepsDipOnChair = ExerciseModel(7,"Triceps Dip On Char",R.drawable.ic_triceps_dip_on_chair)
        exerciseList.add(tricepsDipOnChair)

        val wallSit = ExerciseModel(8,"Wall Sit",R.drawable.ic_wall_sit)
        exerciseList.add(wallSit)

        val squats = ExerciseModel(9,"Squats",R.drawable.ic_squat)
        exerciseList.add(squats)

        val rotationPushUp = ExerciseModel(10,"Rotation Push Up",R.drawable.ic_push_up_and_rotation)
        exerciseList.add(rotationPushUp)

        val plank = ExerciseModel(11,"Plank",R.drawable.ic_plank)
        exerciseList.add(plank)

        val sidePlank = ExerciseModel(12,"Side Plank",R.drawable.ic_side_plank)
        exerciseList.add(sidePlank)

        return exerciseList
    }
}