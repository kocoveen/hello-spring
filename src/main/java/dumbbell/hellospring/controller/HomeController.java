package dumbbell.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 홈화면의 컨트롤러가 없을 땐 index.html이 호출되지만 '/'라는 홈 컨트롤러가 있기 때문에 이게 호출된다.
    public String home() {
        return "home"; // home.html 호출
    }
}
