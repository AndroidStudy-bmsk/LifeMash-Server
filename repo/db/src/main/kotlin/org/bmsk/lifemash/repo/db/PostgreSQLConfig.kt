package org.bmsk.lifemash.repo.db

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

class PostgreSQLConfig(
    private val dataSource: DataSource,
    private val jdbcTemplate: JdbcTemplate
): ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        try {
           println("dataSource class > ${dataSource.javaClass}")
           println("URL > ${dataSource.connection.metaData.url}")
           println("userName > ${dataSource.connection.metaData.userName}")

           val statement = dataSource.connection.createStatement()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}