package org.proleesh.sendemail.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/my")
@Controller
public class RestController {
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(
            Integer intVal, Long longVal, String strVal
    ){
        var paramsMap = new HashMap<String, Object>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", strVal);
        return paramsMap;
    }
}
