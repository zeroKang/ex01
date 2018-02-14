package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")

public class SampleController {

    @GetMapping("/doA")
    public void doA(){
        System.out.println("/sample/doA.............called");
    }

}
