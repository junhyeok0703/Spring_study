package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FristController {

    @GetMapping("/hi")  // 내가 접속할 url을 입력해주면 이 페이지를 반환하겠다! 이거임 브라우저랑 연결해야함
    public String niceToMeetYou(Model model) { //model은 데이터라고 했지? 데이터베이스나 어디서 뭐 내가 설정해도되고
        model.addAttribute("username", "박준혁"); // model을 받아와서 .addAttribute로 뷰템플릿에 있는 데이터를 바꿔서 출력함

        return "greetings"; // 컨트롤러는 static은 알아서 파일명써주면 가는데 뷰템플릿은 컨트롤러안에 메서드로 반환하게 함 templates/greetings.mustache -> 브라우저로 전송!
    }

    @GetMapping("/bye")
    public String goodbye(Model model) { //model은 데이터라고 했지? 데이터베이스나 어디서 뭐 내가 설정해도되고
        model.addAttribute("username", "박준혁"); // model을 받아와서 .addAttribute로 뷰템플릿에 있는 데이터를 바꿔서 출력함
        model.addAttribute("des", "나는 상명대학교 학생입니다.");
        return "byegreetings"; // 컨트롤러는 static은 알아서 파일명써주면 가는데 뷰템플릿은 컨트롤러안에 메서드로 반환하게 함 templates/greetings.mustache -> 브라우저로 전송!
    }
}
