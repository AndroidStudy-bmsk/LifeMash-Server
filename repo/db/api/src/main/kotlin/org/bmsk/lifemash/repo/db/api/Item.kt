package org.bmsk.lifemash.repo.db.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
    val title: String?,
    val originallink: String?,
    val link: String?,
    val description: String?,
    val pubDate: String?
)