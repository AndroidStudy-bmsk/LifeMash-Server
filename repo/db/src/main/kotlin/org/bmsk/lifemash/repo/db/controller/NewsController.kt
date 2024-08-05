package org.bmsk.lifemash.repo.db.controller

import org.bmsk.lifemash.repo.db.model.News
import org.bmsk.lifemash.repo.db.service.NewsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/news")
class NewsController(
    private val articleService: NewsService,
) {
    @GetMapping("/section/{section}")
    fun getNewsBySection(
        @PathVariable section: String,
    ): List<News> = articleService.getNewsBySection(section)

    @GetMapping("/section/all")
    fun getAllNews(): List<News> = articleService.getNews()
}
