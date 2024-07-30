package org.proleesh.sendemail.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(
            @RequestParam(value = "int_val", required = false) Integer intVal,
            @RequestParam("long_val") Long longVal,
            @RequestParam("str_val") String strVal
    ){
        var paramsMap = new HashMap<String, Object>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("strVal", strVal);
        return paramsMap;
    }

    @GetMapping("/request/array")
    @ResponseBody
    public Map<String, Object> requestArray(
            int[] intArr, Long[] longArr, String[] strArr
    ){
        var paramsMap = new HashMap<String, Object>();
        paramsMap.put("intArr", intArr);
        paramsMap.put("longArr", longArr);
        paramsMap.put("strArr", strArr);
        return paramsMap;
    }
}
