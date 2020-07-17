package ng.com.bitsystems.slowcodepetclinic.controllers;

import ng.com.bitsystems.slowcodepetclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetServiceMap vetServiceMap;

    public VetController(VetServiceMap vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"/vets","/vets/index", "/vets/index.html"})
    public String index(Model model){

        model.addAttribute("vets", vetServiceMap.findAll());
        return "vets/index";
    }
}
