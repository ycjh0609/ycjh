package com.ycjh.tmp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class tmpController {

    @Autowired
    tmpRepository tmpRepository;

    @GetMapping("/tmps")
    public ResponseEntity<?> getTmpList(){

        List list = tmpRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @PostMapping("/tmps")
    @ResponseBody
    public  void setTemp(@RequestBody tmpDTO tmpDTO1){
      tmpRepository.save(tmpDTO1);

    }



}
