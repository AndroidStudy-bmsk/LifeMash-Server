package org.bmsk.lifemash.repo.db.impl

import org.bmsk.lifemash.repo.db.api.Item
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

object Items : Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 255)
    val originallink = varchar("originallink", 255)
    val link = varchar("link", 255)
    val description = text("description")
    val pubDate = varchar("pubDate", 50)
}

fun initDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/bmsk_test",
        driver = "org.postgresql.Driver",
        user = "bmsk",
        password = "qwer1234!"
    )
    transaction {
        create(Items)
    }
}

fun saveItemsToDatabase(items: List<Item>) {
    transaction {
        items.forEach { item ->
            Items.insert {
                it[title] = item.title ?: ""
                it[originallink] = item.originallink ?: ""
                it[link] = item.link ?: ""
                it[description] = item.description ?: ""
                it[pubDate] = item.pubDate ?: ""
            }
        }
    }
}