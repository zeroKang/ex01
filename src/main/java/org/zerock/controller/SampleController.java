package org.zerock.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.LocationDTO;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.ProductVO;

import java.awt.*;
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

    @GetMapping("/login")
    public void loginGET(){
        log.info("GET /sample/login.....");
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

    @GetMapping("/checkUser")
    public String checkUser(String id){

        if(id == null){
            return "/sample/login";
        }
        return "/sample/home";
    }

    @GetMapping("/move")
    public String movePage(){

        return "redirect:/sample/login";

    }

    @GetMapping("/moveForward1")
    public String moveForward1( @ModelAttribute("login") LoginDTO loginDTO ){

        log.info("===========================");
        log.info("move forward");

        return "forward:/sample/moveResult1";

    }

    @GetMapping("/moveResult1")
    public void moveResult1( Model model ){

        log.info("===========================");
        log.info("move result 1");
        log.info(model);
    }

    @GetMapping("/move2")
    public String move2( String id, RedirectAttributes rttr ){

        log.info("===========================");
        log.info("move2  redirect");
        rttr.addAttribute("id", id);

        return "redirect:/sample/moveResult2";

    }

    @GetMapping("/moveResult2")
    public void moveResult2(String id ){

        log.info("===========================");
        log.info("move result 2");
        log.info(id);
    }

    @GetMapping("/moveFlash")
    public String moveFlash(RedirectAttributes rttr ){

        log.info("===========================");
        log.info("move flash  redirect");

        rttr.addFlashAttribute("result","SUCCESS");

        return "redirect:/sample/moveFlashResult";

    }

    @GetMapping("/moveFlashResult")
    public void moveResult3( String result ){

        log.info("===========================");
        log.info("move result 3");
        log.info(result);
    }

    @PostMapping("/uploadEx")
    public void uploadEx(MultipartFile[] files){

        Arrays.stream(files).forEach(file -> {
            log.info(file.getOriginalFilename());
            log.info(file.getSize());
        });

    }


    @GetMapping(value ="/getJSON", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public LoginDTO jsonTest( ){

        LoginDTO dto = new LoginDTO();
        dto.setId("user00");
        dto.setPw("pass00");

        return dto;
    }


}
























