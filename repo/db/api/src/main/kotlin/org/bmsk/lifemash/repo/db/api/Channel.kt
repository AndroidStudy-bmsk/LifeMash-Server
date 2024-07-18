package org.bmsk.lifemash.repo.db.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class Channel(
    val item: List<Item>
)
