package com.example.todoapp

class ToDoPlan {
    var name: String = ""
    var description: String = ""
    var degree: User? = null
    var createData:String = ""
    var dedline = ""
    var level: String = ""

    constructor(
        name: String,
        description: String,
        degree: User,
        createData: String,
        dedline: String
    ) {
        this.name = name
        this.description = description
        this.degree = degree
        this.createData = createData
        this.dedline = dedline
    }

    constructor(
        name: String,
        description: String,
        degree: User,
        createData: String,
        dedline: String,
        level: String
    ) {
        this.name = name
        this.description = description
        this.degree = degree
        this.createData = createData
        this.dedline = dedline
        this.level = level
    }

    constructor()

    override fun toString(): String {
        return "TodoPlan(name='$name', description='$description', degree='$degree', createData='$createData', dedline='$dedline', level='$level')"
    }

}
object PlanObject {
    var toDoPlanList = ArrayList<ToDoPlan>()
}
