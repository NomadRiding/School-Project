package com.example.The.Big.Project.controller.impl;


import com.example.The.Big.Project.model.Author;
import com.example.The.Big.Project.service.interfaces.IAuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAuthorService authorService;

    @Test
    public void getAllAuthorsTest() throws Exception {
        Author author1 = new Author(1, "Author One");
        Author author2 = new Author(2, "Author Two");
        List<Author> authors = Arrays.asList(author1, author2);

        given(authorService.getAllAuthors()).willReturn(authors);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/authors")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Author One"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Author Two"));
    }

    @Test
    public void updateAuthorTest() throws Exception {
        Author updatedAuthor = new Author(1, "Updated Author");

        doNothing().when(authorService).updateAuthor(Mockito.any(Author.class), Mockito.anyInt());

        mockMvc.perform(put("/api/authors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"name\":\"Updated Author\"}"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAuthorTest() throws Exception {
        doNothing().when(authorService).deleteAuthor(1);

        mockMvc.perform(delete("/api/authors/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}