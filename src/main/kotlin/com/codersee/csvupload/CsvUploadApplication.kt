package com.codersee.csvupload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CsvUploadApplication

fun main(args: Array<String>) {
	runApplication<CsvUploadApplication>(*args)
}