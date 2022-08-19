package com.lihan.bananacompany.domain.model



fun Employee.toEmployeeEntity() : EmployeeEntity {
    return EmployeeEntity(
        _id = _id,
        about = about,
        address = address,
        age = age,
        balance = balance,
        company = company,
        email = email,
        eyeColor = eyeColor,
        favoriteFruit = favoriteFruit,
//        friends = friends,
        gender = gender,
        greeting = greeting,
        guid = guid,
        index = index,
        isActive = isActive,
        latitude = latitude,
        longitude = longitude,
        name = name,
        phone = phone,
        picture = picture,
        registered = registered,
//        tags = tags
    )
}

fun EmployeeEntity.toEmployee() : Employee{
    return Employee(
        _id = _id,
        about = about,
        address = address,
        age = age,
        balance = balance,
        company = company,
        email = email,
        eyeColor = eyeColor,
        favoriteFruit = favoriteFruit,
//        friends = friends,
        gender = gender,
        greeting = greeting,
        guid = guid,
        index = index,
        isActive = isActive,
        latitude = latitude,
        longitude = longitude,
        name = name,
        phone = phone,
        picture = picture,
        registered = registered,
//        tags = tags
    )
}