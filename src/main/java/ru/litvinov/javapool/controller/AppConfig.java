package ru.litvinov.javapool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.javapool.model.entity.Auto;
import ru.litvinov.javapool.service.AutoService;

import java.util.List;

@Controller
public class AppConfig {

    private AutoService autoService;

    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping(value = "auto/listAuto")
    public @ResponseBody List listAuto(){
        return autoService.listAuto();
    }

    @GetMapping(value = "auto/listAutoByModel")
    public @ResponseBody List<Auto> listAutoByModel(@RequestParam String model){
        return autoService.listAutoByModel(model);
    }

    @RequestMapping(value = "auto/add",method = RequestMethod.POST)
    public @ResponseBody String addAuto(@ModelAttribute("auto") Auto auto) {
        if(auto.getId() == 0){
            this.autoService.addAuto(auto);
        } else {
            this.autoService.updateAuto(auto);
        }
        return "redirect:autos";
    }

    @GetMapping(value = "auto/remove")
    public @ResponseBody String removeAuto(@RequestParam int id){
        autoService.removeAuto(id);
        return "redirect:autos";
    }

    @GetMapping(value = "auto/getAuto")
    public @ResponseBody String getAuto(@RequestParam int id){
        return autoService.getAutoById(id).toString();
    }

    @GetMapping(value = "auto/{idAuto}")
    public @ResponseBody String getAutoByVariable(@PathVariable int idAuto){
        return autoService.getAutoById(idAuto).toString();
    }

    @GetMapping(value = "test")
    public @ResponseBody String test(){
        return "test string";
    }
}
