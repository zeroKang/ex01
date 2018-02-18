package org.zerock.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.LocationDTO;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.ProductVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @GetMapping("/doA")
    public void doA(){
        log.info("/sample/doA.............called");
    }

    @PostMapping("/login")
    public void login(LoginDTO loginDTO){
        log.info("--------------------");
        log.info(loginDTO);
    }

    @PostMapping("/dateEx")
    public void dateEx( @DateTimeFormat(pattern = "yyyy/MM/dd") Date date ){
        log.info("--------------------");
        log.info(date);
    }

    @PostMapping("/dateEx2")
    public void dateEx2(LocationDTO locationDTO){
        log.info("--------------------");
        log.info(locationDTO);
    }

    @PostMapping("/arrayEx")
    public void arrayEx(@RequestParam("text") String[] arr){

        log.info("--------------------");
        log.info(Arrays.toString(arr));

    }
    @PostMapping("/listEx")
    public void listEx(@RequestParam("text") ArrayList<String> list){

        log.info("--------------------");
        log.info(list);

    }

    @GetMapping("/modelEx1")
    public void model1Ex(Model model){

        ProductVO vo = new ProductVO();
        vo.setName("Test Product");
        vo.setPrice(123.456);
        model.addAttribute("product", vo);

    }

    @GetMapping("/withoutModel")
    public void withoutModel( @ModelAttribute("login") LoginDTO loginDTO){

        log.info("-----------------------");

    }

}
























