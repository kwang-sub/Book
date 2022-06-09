package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register/*")
public class RegisterController {

    private MemberRegisterService service;

    public RegisterController(@Autowired MemberRegisterService service) {
        this.service = service;
    }

    @GetMapping("step1")
    public String handleStep1() {
        return "register/step1";
    }

    @GetMapping("step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
        if(!agree){
            return "register/step1";
        }
        return "register/step2";
    }

    @PostMapping("step3")
    public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq) {
        try {
            service.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException e){
            return "register/step2";
        }

    }

}
