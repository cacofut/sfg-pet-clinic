/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cristianoca
 */
@Controller
public class VetController {
    
    @RequestMapping( {"/vets", "/vets/index", "/vets/index.html"} )
    public String index(){
        return "vets/index";
    }
}
