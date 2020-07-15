package ng.com.bitsystems.slowcodepetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"", "/","/index.html", "/index"})
    public String listOwners(Model model){

        return "owners/index";
    }

}
