package com.example.chap11.controller;

import com.example.chap11.domain.Member;
import com.example.chap11.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createMemberForm(@ModelAttribute("memberForm") Member member) {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(@ModelAttribute("memberForm") Member member) {
        System.out.println(member);
        memberService.join(member);
        return "redirect:/";
    }
}
