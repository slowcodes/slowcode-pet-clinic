package ng.com.bitsystems.slowcodepetclinic.controllers;

import ng.com.bitsystems.slowcodepetclinic.services.map.OwnerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerServiceMap ownerServiceMap;

    public OwnerController(OwnerServiceMap ownerServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
    }

    @RequestMapping({"", "/","/index.html", "/index"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerServiceMap.findAll());

        return "owners/index";
    }

}
