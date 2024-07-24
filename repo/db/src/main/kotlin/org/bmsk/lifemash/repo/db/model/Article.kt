package org.bmsk.lifemash.repo.db.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "articles")
data class Article(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val section: String,
    val pubDate: Date,
)