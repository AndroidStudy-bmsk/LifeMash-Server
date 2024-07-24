package org.bmsk.lifemash.repo.db.service

import org.bmsk.lifemash.repo.db.model.Article
import org.bmsk.lifemash.repo.db.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    fun getArticlesBySection(section: String): List<Article> {
        return articleRepository.findBySection(section)
    }
}