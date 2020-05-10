package com.example.blog

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.assertj.core.api.Assertions.*;
import org.springframework.web.client.RestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

  @BeforeAll
  fun setup() {
    println(">> Setup")
  }

  @Test
  fun `Assert blog page title, content and status code`() {
    println(">> Assert blog page title, content and status code")
    val entity = restTemplate.getForEntity("/", String::class.java)
    assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    assertThat(entity.body).contains("<h1>Blog</h1>")
  }

  @Test
  fun `Assert article page title, content and status code`() {
    println(">> TODO")
  }

  @Test
  fun `True equal False`(){
    assertThat(false).isFalse();
  }

  @AfterAll
  fun teardown() {
    println(">> Tear down")
  }

}