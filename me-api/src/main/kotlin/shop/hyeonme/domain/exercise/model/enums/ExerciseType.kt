package shop.hyeonme.domain.exercise.model.enums

enum class ExerciseType(
    val description: String
) {
    WALK("걷기"),
    RUN("달리기"),
    CYCLING("사이클링"),
    ELLIPTICAL("일립티컬"),
    ROWER("로잉운동"),
    STAIR_STEPPER("스텝퍼운동"),
    HIIT("고강도 인터벌 트레이닝"),
    HIKING("하이킹"),
    FUNCTIONAL_STRENGTH_TRAINING("기능성 근력 강화운동"),
    CORE_TRAINING("코어 트레이닝"),
    PILATES("필라테스"),
    SWIMMING("수영")
}
