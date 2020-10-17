package com.codersee.csvupload.service

import com.codersee.csvupload.exception.BadRequestException
import com.codersee.csvupload.exception.CsvImportException
import com.codersee.csvupload.model.User
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

@Service
class CsvService {

    fun uploadCsvFile(file: MultipartFile): List<User> {
        throwIfFileEmpty(file)
        var fileReader: BufferedReader? = null

        try {
            fileReader = BufferedReader(InputStreamReader(file.inputStream))
            val csvToBean = createCSVToBean(fileReader)

            return csvToBean.parse()
        } catch (ex: Exception) {
            throw CsvImportException("Error during csv import")
        } finally {
            closeFileReader(fileReader)
        }
    }

    private fun throwIfFileEmpty(file: MultipartFile) {
        if (file.isEmpty)
            throw BadRequestException("Empty file")
    }

    private fun createCSVToBean(fileReader: BufferedReader?): CsvToBean<User> =
        CsvToBeanBuilder<User>(fileReader)
            .withType(User::class.java)
            .withIgnoreLeadingWhiteSpace(true)
            .build()

    private fun closeFileReader(fileReader: BufferedReader?) {
        try {
            fileReader!!.close()
        } catch (ex: IOException) {
            throw CsvImportException("Error during csv import")
        }
    }
}
