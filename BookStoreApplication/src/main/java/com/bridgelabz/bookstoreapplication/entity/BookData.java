package com.bridgelabz.bookstoreapplication.entity;

import com.bridgelabz.bookstoreapplication.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "BookData")
public class BookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String authorName;
    private String bookDescription;
    private int price;
    private int quantity;


    public BookData(BookDTO bookDTO) {
        this.bookName=bookDTO.getBookName();
        this.authorName=bookDTO.getAuthorName();
        this.bookDescription=bookDTO.getBookDescription();
        this.price=bookDTO.getPrice();
        this.quantity=bookDTO.getQuantity();
    }
}
