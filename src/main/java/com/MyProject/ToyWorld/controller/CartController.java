package com.MyProject.ToyWorld.controller;

import com.MyProject.ToyWorld.entity.CartItem;
import com.MyProject.ToyWorld.service.CartService;
import com.MyProject.ToyWorld.util.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public String showCartPage(Model model){
        List<CartItem> cartItems = cartService.listCartItem(SecurityUtil.getCurrentUser().getCart().getId());
        BigDecimal itemCost  = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        for (CartItem item : cartItems){
            itemCost = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalCost = totalCost.add(itemCost);
        }
        model.addAttribute("total", totalCost);
        model.addAttribute("items", cartItems);
        return "shopping-cart";
    }

    @GetMapping("/clear")
    public String clearCart(){
        cartService.clearCart(SecurityUtil.getCurrentUser().getCart().getId());
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable Long id){
        cartService.deleteCartItem(SecurityUtil.getCurrentUser().getCart().getId(),id);
        return "redirect:/cart";
    }
}
