package org.bmsk.lifemash.repo.db.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
@Table(name = "news")
data class News(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "title")
    val title: String = "",
    @Column(name = "image_url")
    val imageUrl: String = "",
    @Column(name = "section")
    val section: String = "",
    @Column(name = "pub_date")
    @Temporal(TemporalType.TIMESTAMP)
    val pubDate: Date = Date(),
    @Column(name = "link")
    val link: String = "",
)
