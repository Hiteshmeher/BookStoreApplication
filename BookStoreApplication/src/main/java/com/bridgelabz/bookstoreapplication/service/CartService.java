package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.entity.BookData;
import com.bridgelabz.bookstoreapplication.entity.CartData;
import com.bridgelabz.bookstoreapplication.entity.UserRegistrationData;
import com.bridgelabz.bookstoreapplication.repository.BookRepository;
import com.bridgelabz.bookstoreapplication.repository.CartRepository;
import com.bridgelabz.bookstoreapplication.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    IBookService iBookService;
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;


    @Override
    public CartData addToCart(int userId, CartDTO cartDto) {
        UserRegistrationData user = userRegistrationRepository.findById(userId).orElse(null);
        BookData book = iBookService.FindById(cartDto.getBookId());
        if(user != null && book != null){
            int cartPrice = book.getPrice() * cartDto.getQuantity();
            CartData cart = new CartData(user,book,cartPrice,cartDto);
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public String deleteById(int cartid) {
        Optional<CartData> cart = cartRepository.findById(cartid);
        if(cart != null) {
            cartRepository.deleteById(cartid);
            return "Cart Removed";
        }
        return null;
    }

    @Override
    public CartData changeCartQuantity(int userId, int cartId, CartDTO cartDto) {
        UserRegistrationData user = userRegistrationRepository.findById(userId).orElse(null);
        BookData book = bookRepository.findById(cartDto.getBookId()).orElse(null);
        CartData cart = cartRepository.findById(cartId).orElse(null);
        if(cart != null && user != null){
            if(book != null){
                cart.setBook(book);
                cart.setQuantity(cartDto.getQuantity());
                cart.setTotalPrice(book.getPrice() * cartDto.getQuantity());
                return cartRepository.save(cart);
            }
        }
        return null;
    }
    @Override
    public CartData updateCart(int userId, int cartId, int qty) {
        UserRegistrationData user = userRegistrationRepository.findById(userId).orElse(null);
        CartData cart = cartRepository.findById(cartId).orElse(null);
        cart.setQuantity(qty);
        return null;
    }

    @Override
    public List<CartData> findAll() {
        List<CartData> cartList = cartRepository.findAll();
        return cartList;
    }

    @Override
    public List<CartData> getCartDetailsByUserId(int userId) {
        List<CartData> userCartList = cartRepository.getCartListByUserId(userId);
        if(userCartList.isEmpty()){
            return null;
        }else
            return userCartList;
    }

}