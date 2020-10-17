package com.codersee.csvupload.controller

import com.codersee.csvupload.model.User
import com.codersee.csvupload.service.CsvService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/csv")
class CsvController(
    private val csvService: CsvService
) {

    @PostMapping
    fun uploadCsvFile(
        @RequestParam("file") file: MultipartFile
    ): ResponseEntity<List<User>> {
        val importedEntries = csvService.uploadCsvFile(file)

        return ResponseEntity.ok(importedEntries)
    }

}