package small.woods.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")//默访问根目录下的index这个模板
    public String index(){
        return "index";
    }
}
