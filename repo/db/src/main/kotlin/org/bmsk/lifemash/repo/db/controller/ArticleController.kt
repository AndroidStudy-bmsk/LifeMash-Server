package org.bmsk.lifemash.repo.db.controller

import org.bmsk.lifemash.repo.db.model.Article
import org.bmsk.lifemash.repo.db.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/articles")
class ArticleController(
    private val articleService: ArticleService
) {

    @GetMapping("/section/{section}")
    fun getArticlesBySection(
        @PathVariable section: String
    ): List<Article> {
        return articleService.getArticlesBySection(section)
    }
}