package se.ecutb.hala.mvc_excersice_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeverController {


    @GetMapping("/temperature")
    public String temperatureFever(@RequestParam(value = "fever" ,required = false) Double temperature, Model model){
        String message = "Enter your temperature";
       if(temperature != null){
           if(temperature >=25.0 && temperature <35){
               message = "You have " + temperature + " , Oh! you freezing.";
           }else if (temperature >=35 && temperature < 38){
               message = "You have " + temperature + " , Normal temperature.";
           }else if (temperature >=38 && temperature < 40){
           message = "You have " + temperature + " ,  hyperthermia  temperature, you have to see a doctor.";
           }else if (temperature >=40 ){
           message = "You have " + temperature + " ,  hyperthermia  temperature, you need emergency. ";
       }else{
               message = "You have " + temperature + " no way, something is wrong, you can't be alive.";
           }
       }
       model.addAttribute("fever", message);
        return "temp-view";
    }

    @PostMapping("temperature/")
    public String process(@RequestParam(value = "fever", required = false) Double fever,Model model){
       model.addAttribute("fever", fever);
        return "redirect:/temperature";
    }

}
