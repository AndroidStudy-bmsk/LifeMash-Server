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

    // 모든 아티클을 가져오는 메서드 추가
    fun getAllArticles(): List<Article> {
        return articleRepository.findAll()
    }
}