package com.codersee.csvupload.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException(msg: String) : RuntimeException(msg)