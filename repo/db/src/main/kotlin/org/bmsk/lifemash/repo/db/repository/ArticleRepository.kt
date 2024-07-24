package org.bmsk.lifemash.repo.db.repository

import org.bmsk.lifemash.repo.db.model.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {
    fun findBySection(section: String): List<Article>
}