class SystemApp(
    val time: Long,
    val age: Int,
    val gender: Gender,
    val osVersion: Int,
    val xCoord: Float,
    val yCoord: Float,
) {
    fun showPush(push: Push?): Boolean {
        var pushIsFiltered = true
        push?.let {
            if (!push.isFilteredByApp(this)) {
                println(push.text)
                pushIsFiltered = false
            }
        }
        return pushIsFiltered
    }

    companion object {
        const val TIME = "time"
        const val AGE = "age"
        const val GENDER = "gender"
        const val OS_VERSION = "os_version"
        const val X_COORD = "x_coord"
        const val Y_COORD = "y_coord"
        const val RADIUS = "radius"
        const val EXPIRE_DATE = "expiry_date"
        const val TYPE = "type"
        const val TEXT = "text"
    }
}