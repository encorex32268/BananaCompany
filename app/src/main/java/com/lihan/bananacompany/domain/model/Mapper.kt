package com.lihan.bananacompany.domain.model



fun Employee.toEmployeeEntity() : EmployeeEntity {
    return EmployeeEntity(
        _id, about, address, age, balance, company, email, eyeColor, favoriteFruit,
        friends, gender, greeting, guid, index, isActive, latitude, longitude, name, phone, picture, registered, tags
    )
}

fun EmployeeEntity.toEmployee() : Employee{
    return Employee(
        _id, about, address, age, balance, company, email, eyeColor, favoriteFruit,
        friends, gender, greeting, guid, index, isActive, latitude, longitude, name, phone, picture, registered, tags
    )
}