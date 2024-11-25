package ru.gogogo.glhf.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "x" ,required = false) String x,
                            @RequestParam(value = "y",required = false) String y,
                            @RequestParam(value = "o",required = false) String o , Model model){
        model.addAttribute("x",x);
        model.addAttribute("y",y);
        model.addAttribute("o",o);
        int r = 0;

        if (o.equals("plus")){
            r = Integer.parseInt(x)+Integer.parseInt(y);
        } else if (o.equals("m")) {
            r = Integer.parseInt(x)-Integer.parseInt(y);
        }
        model.addAttribute("r",String.valueOf(r));
        return "first/hello";
    }

    @GetMapping("/googbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
