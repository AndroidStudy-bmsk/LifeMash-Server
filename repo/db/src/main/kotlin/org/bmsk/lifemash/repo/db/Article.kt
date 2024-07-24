package org.bmsk.lifemash.repo.db

import java.util.Date

data class Article(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val pubDate: Date,
)