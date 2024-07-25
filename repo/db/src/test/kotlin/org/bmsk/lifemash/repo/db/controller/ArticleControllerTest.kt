package org.bmsk.lifemash.repo.db.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.bmsk.lifemash.repo.db.model.Article
import org.bmsk.lifemash.repo.db.repository.ArticleRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@DataJpaTest
class ArticleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var articleRepository: ArticleRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `test getArticlesBySection`() {
        // Given
        val article = Article(
            id = 0L,
            title = "Test Article",
            imageUrl = "http://example.com/image.jpg",
            section = "Test",
            link = "http://example.com",
            pubDate = Date()
        )
        articleRepository.save(article)

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/section/Test"))
            .andExpect(status().isOk)
            .andExpect { result ->
                val articles = objectMapper.readValue(result.response.contentAsString, Array<Article>::class.java)
                assertEquals(1, articles.size)
                assertEquals("Test Article", articles[0].title)
            }
    }

    @Test
    fun `test saveArticle`() {
        // Given
        val article = Article(
            id = 1L,
            title = "New Article",
            imageUrl = "http://example.com/image.jpg",
            section = "News",
            link = "http://example.com",
            pubDate = Date()
        )

        // When & Then
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(article))
        )
            .andExpect(status().isOk)

        val savedArticles = articleRepository.findBySection("News")
        assertEquals(1, savedArticles.size)
        assertEquals("New Article", savedArticles[0].title)
    }
}