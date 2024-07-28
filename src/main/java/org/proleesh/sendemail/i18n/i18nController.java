package org.proleesh.sendemail.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class i18nController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
