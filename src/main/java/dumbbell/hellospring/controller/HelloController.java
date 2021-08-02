package dumbbell.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // <- URL이름이 hello라는 것
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
        /* resources:templates에 hello라는 파일로 들어가서
         resources:templates에 리턴 값이 문자이면
         파일명이 문자.html으로 model 키를 넘기면서 실행
         */
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    } // requestParam은 URL 뒤에 ?name=어쩌구 처럼 어쩌구라는 값을 리턴값과 같은 이름의 templates 파일의 파일명으로 넘기면서 실행

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; /*
         http://localhost:8080/hello-string?name=dragoon
         "hello dragoon" 리턴값을 그대로 넘김
         */
    }

    @GetMapping("hello-api") // URL 이름
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    /*
         http://localhost:8080/hello-api?name=dragoon
         "hello dragoon" 리턴값을 json {key : value} 형태로 넘김
         */
}


