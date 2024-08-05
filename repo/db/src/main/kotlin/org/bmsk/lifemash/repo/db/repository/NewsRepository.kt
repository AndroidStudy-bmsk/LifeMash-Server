package org.bmsk.lifemash.repo.db.repository

import org.bmsk.lifemash.repo.db.model.News
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository : JpaRepository<News, Long> {
    fun findBySection(section: String): List<News>
}
