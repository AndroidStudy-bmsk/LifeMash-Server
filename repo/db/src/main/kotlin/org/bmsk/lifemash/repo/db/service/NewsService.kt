package org.bmsk.lifemash.repo.db.service

import org.bmsk.lifemash.repo.db.model.News
import org.bmsk.lifemash.repo.db.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository,
) {
    fun getNewsBySection(section: String): List<News> = newsRepository.findBySection(section)

    // 모든 아티클을 가져오는 메서드 추가
    fun getNews(): List<News> = newsRepository.findAll()
}
