package com.reborn.bookstore.cart.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.reborn.bookstore.book.service.BookService;
import com.reborn.bookstore.cart.domain.Cart;
import com.reborn.bookstore.cart.domain.CartItem;
import com.reborn.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/28.
 */
@WebServlet(name = "CartServlet",urlPatterns = {"/CartServlet"})
public class CartServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = (Cart) request.getSession().getAttribute("session_cart");
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(CommonUtils.uuid());
        cartItem.setQuantity(quantity);
        cartItem.setBook(new BookService().load(bid));
        cartItem.setUser((User) request.getSession().getAttribute("session_user"));
        cart.add(cartItem);
        return "f:/jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Cart cart = (Cart) request.getSession().getAttribute("session_cart");
        cart.delete(bid);
        return "f:/jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("session_cart");
        cart.clear();
        return "f:/jsps/cart/list.jsp";
    }
}
