package org.bmsk.lifemash.repo.db

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.bmsk.lifemash.repo.db.Channel

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rss(
    val channel: Channel
)
