open class GenderPush(
    textParam: String,
    type: PushTypes,
    protected val gender: Gender
) : Push(textParam, type), FilterableByGender {
    override fun isFilteredByApp(systemApp: SystemApp) = isFilteredByGender(systemApp, gender)
}