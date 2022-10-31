package com.bridgelabz.bookstoreapplication.controller;

import com.bridgelabz.bookstoreapplication.dto.BookDTO;
import com.bridgelabz.bookstoreapplication.dto.ResponseDTO;
import com.bridgelabz.bookstoreapplication.entity.BookData;
import com.bridgelabz.bookstoreapplication.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;


    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDTO bookDTO) {
        BookData book = bookService.addBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Added", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<ResponseDTO> findAllDetail() {
        List<BookData> userList = bookService.findAll();
        ResponseDTO responseDTO = new ResponseDTO("All books", userList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> FindById(@PathVariable int bookId) {
        BookData response = bookService.FindById(bookId);
        ResponseDTO responseDto = new ResponseDTO("Book Details by Id", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Book Data", "book deleted by id " + bookId);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }


    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> editData(@PathVariable int bookId, @RequestBody BookDTO bookDTO) {
        BookData bookData = bookService.updateBookData(bookId, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Details Updated", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}