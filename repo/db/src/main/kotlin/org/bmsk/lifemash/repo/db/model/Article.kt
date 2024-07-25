package org.bmsk.lifemash.repo.db.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "articles")
data class Article(
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
    val link: String = ""
)
