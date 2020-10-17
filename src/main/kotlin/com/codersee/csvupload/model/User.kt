package com.codersee.csvupload.model

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvBindByPosition

data class User(
    @CsvBindByName(column = "Id")
    var id: Long? = null,
    @CsvBindByName(column = "First Name")
    var firstName: String? = null,
    @CsvBindByName(column = "Last Name")
    var lastName: String? = null,
    @CsvBindByName(column = "Email")
    var email: String? = null,
    @CsvBindByName(column = "Phone number")
    var phoneNumber: String? = null,
    @CsvBindByName(column = "Age")
    var age: Int? = null
)

data class UserWithCsvBindByPosition(
    @CsvBindByPosition(position = 0)
    var id: Long? = null,
    @CsvBindByPosition(position = 1)
    var firstName: String? = null,
    @CsvBindByPosition(position = 2)
    var lastName: String? = null,
    @CsvBindByPosition(position = 3)
    var email: String? = null,
    @CsvBindByPosition(position = 4)
    var phoneNumber: String? = null,
    @CsvBindByPosition(position = 5)
    var age: Int? = null
)

