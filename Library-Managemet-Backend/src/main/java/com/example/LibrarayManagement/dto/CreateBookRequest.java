package com.example.LibrarayManagement.dto;

import com.example.LibrarayManagement.models.Author;
import com.example.LibrarayManagement.models.Book;
import com.example.LibrarayManagement.models.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {

    @NotBlank
    private String name;
    @NotNull
    private Genre genre;
    @NotBlank
    private String authorName;
    @NotBlank
    private String authorEmail;
    private Integer price;

    public Book to() {
        Author author = Author.builder()
                .name(this.authorName)
                .email(this.authorEmail)
                .build();

        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .book_author(author)
                .build();
    }




}