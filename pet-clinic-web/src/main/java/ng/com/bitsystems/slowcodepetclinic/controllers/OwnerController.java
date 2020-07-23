package ng.com.bitsystems.slowcodepetclinic.controllers;

import ng.com.bitsystems.slowcodepetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/","/index.html", "/index"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());

        return "owners/index";
    }

}
