package org.bmsk.lifemash

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LifeMashApplication

fun main(args: Array<String>) {
    runApplication<LifeMashApplication>(*args)
}