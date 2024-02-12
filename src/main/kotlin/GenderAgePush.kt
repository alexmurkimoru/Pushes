class GenderAgePush(
    textParam: String,
    type: PushTypes,
    gender: Gender,
    private val age: Int,
) : GenderPush(textParam, type, gender), FilterableByAge {
    override fun isFilteredByApp(systemApp: SystemApp) = isFilteredByAge(systemApp, age) || isFilteredByGender(systemApp, gender)
}