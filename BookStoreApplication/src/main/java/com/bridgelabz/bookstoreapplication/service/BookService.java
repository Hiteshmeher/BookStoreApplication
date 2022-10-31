package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.BookDTO;
import com.bridgelabz.bookstoreapplication.entity.BookData;
import com.bridgelabz.bookstoreapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private BookRepository bookRepository;

    public BookData addBook(BookDTO bookDTO) {
        BookData addData = new BookData(bookDTO);
        return bookRepository.save(addData);
    }


    @Override
    public List<BookData> findAll() {
        List<BookData> bookList = bookRepository.findAll();
        return bookList;
    }


    @Override
    public BookData FindById(int id) {
        BookData book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return book;
        }
        return null;
    }


    @Override
    public String deleteById(int id) {
        BookData findById = bookRepository.findById(id).orElse(null);
        if (findById != null) {
            bookRepository.deleteById(id);
            return "data is deleted";
        }
        return null;
    }


    @Override
    public BookData updateBookData(int bookId, BookDTO bookdto) {
        BookData update = bookRepository.findById(bookId).orElse(null);
        if (update != null) {
            update.setBookName(bookdto.getBookName());
            update.setAuthorName(bookdto.getAuthorName());
            update.setBookDescription(bookdto.getBookDescription());
            update.setPrice(bookdto.getPrice());
            update.setQuantity(bookdto.getQuantity());

            return bookRepository.save(update);
        }
        return null;
    }
}
