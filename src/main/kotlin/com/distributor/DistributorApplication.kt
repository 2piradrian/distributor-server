package com.distributor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DistributorApplication

fun main(args: Array<String>) {
	runApplication<DistributorApplication>(*args)
}
