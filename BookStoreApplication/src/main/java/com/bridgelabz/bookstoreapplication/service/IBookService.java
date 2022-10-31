package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.BookDTO;
import com.bridgelabz.bookstoreapplication.entity.BookData;

import java.util.List;

public interface IBookService {
    BookData addBook(BookDTO bookDTO);
    List<BookData> findAll();
    BookData FindById(int bookId);
    String deleteById(int bookId);
    BookData updateBookData(int id, BookDTO bookDTO);
}