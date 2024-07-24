package org.bmsk.lifemash.repo.db

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Channel(
    val item: List<Item>
)
