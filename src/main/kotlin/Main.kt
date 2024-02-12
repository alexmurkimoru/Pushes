
fun main(args: Array<String>) {
    val systemApp: SystemApp = identifySystemParams()
    val pushesCount = readln().toInt()
    val pushes = mutableListOf<Push?>()
    var pushIsFiltered = true
    var shownPushesCount = 0
    repeat(pushesCount) {
        pushes.add(identifyPushParams())
    }
    for (i in pushes){
        pushIsFiltered = systemApp.showPush(i)
        if(!pushIsFiltered){
            shownPushesCount += 1
        }
    }
    if(shownPushesCount == 0){
        println(-1)
    }
}

fun identifySystemParams(): SystemApp {
    var timeParam: Long = -1
    var ageParam: Int = -1
    var genderParam: Gender = Gender.MALE
    var osVersionParam: Int = -1
    var xCoordParam: Float = -1F
    var yCoordParam: Float = -1F
    repeat(6)
    {
        val str = readln().split(" ")
        when (str[0]) {
            SystemApp.TIME -> timeParam = str[1].toLong()
            SystemApp.GENDER -> {
                genderParam = if (str[1] == Gender.MALE.sign) {
                    Gender.MALE
                } else if (str[1] == Gender.FEMALE.sign) {
                    Gender.FEMALE
                } else {
                    //throw IllegalArgumentException("Unexpected gender")
                    Gender.FEMALE
                }
            }
            SystemApp.AGE -> ageParam = str[1].toInt()
            SystemApp.OS_VERSION -> osVersionParam = str[1].toInt()
            SystemApp.X_COORD -> xCoordParam = str[1].toFloat()
            SystemApp.Y_COORD -> yCoordParam = str[1].toFloat()
        }
    }
    return SystemApp(timeParam, ageParam, genderParam, osVersionParam, xCoordParam, yCoordParam)
}

fun identifyPushParams(): Push? {
    var push: Push? = null
    val paramsCount = readln().toInt()
    var typeParam = ""
    var textParam = ""
    var ageParam: Int = -1
    var genderParam: Gender = Gender.MALE
    var osVersionParam: Int = -1
    var xCoordParam: Float = -1F
    var yCoordParam: Float = -1F
    var expireDateParam: Long = -1
    var radiusParam: Int = -1
    repeat(paramsCount){
        val str = readln().split(" ")
        when (str[0]){
            SystemApp.TEXT -> textParam = str[1]
            SystemApp.TYPE -> typeParam = str[1]
            SystemApp.GENDER -> {
                genderParam = if (str[1] == Gender.MALE.sign) {
                    Gender.MALE
                } else if (str[1] == Gender.FEMALE.sign) {
                    Gender.FEMALE
                } else {
                    throw IllegalArgumentException("Unexpected gender")
                }
            }
            SystemApp.AGE -> ageParam = str[1].toInt()
            SystemApp.OS_VERSION -> osVersionParam = str[1].toInt()
            SystemApp.X_COORD -> xCoordParam = str[1].toFloat()
            SystemApp.Y_COORD -> yCoordParam = str[1].toFloat()
            SystemApp.EXPIRE_DATE -> expireDateParam = str[1].toLong()
            SystemApp.RADIUS -> radiusParam = str[1].toInt()
            }
        }
    when(typeParam){
        PushTypes.LOCATION_PUSH.type ->{
            push = LocationPush(
                textParam,
                PushTypes.LOCATION_PUSH,
                xCoordParam,
                yCoordParam,
                radiusParam,
                expireDateParam
                )
        }
        PushTypes.LOCATION_AGE_PUSH.type ->{
            push = LocationAgePush(
                textParam,
                PushTypes.LOCATION_AGE_PUSH,
                xCoordParam,
                yCoordParam,
                radiusParam,
                ageParam
            )
        }
        PushTypes.GENDER_PUSH.type ->{
            push = GenderPush(
                textParam,
                PushTypes.GENDER_PUSH,
                genderParam
            )
        }
        PushTypes.GENDER_AGE_PUSH.type ->{
            push = GenderAgePush(
                textParam,
                PushTypes.GENDER_AGE_PUSH,
                genderParam,
                ageParam
            )
        }
        PushTypes.AGE_SPECIFIC_PUSH.type ->{
            push = AgeSpecificPush(
                textParam,
                PushTypes.AGE_SPECIFIC_PUSH,
                ageParam,
                expireDateParam
            )
        }
       PushTypes.TECH_PUSH.type ->{
            push = TechPush(
                textParam,
                PushTypes.TECH_PUSH,
                osVersionParam
            )
        }
        else -> throw IllegalArgumentException("Unexpected type")
    }
    return push
}

