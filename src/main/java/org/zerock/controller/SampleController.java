package org.zerock.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.LocationDTO;
import org.zerock.domain.LoginDTO;

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

}
























