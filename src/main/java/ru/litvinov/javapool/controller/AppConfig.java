package ru.litvinov.javapool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        List<Auto> result = autoService.listAutoByModel(model);
        if (result == null || result.size() == 0) {
            throw new ResourceNotFoundException();
        } else {
            return result;
        }
    }

    @RequestMapping(value = "auto/add",method = RequestMethod.POST)
    public @ResponseBody String addAuto(@ModelAttribute("auto") Auto auto) {
        if(auto.getId() == 0){
            this.autoService.addAuto(auto);
            return "Auto was added";
        } else {
            this.autoService.updateAuto(auto);
            return "Auto is updated";
        }
    }

    @RequestMapping(value = "auto/update",method = RequestMethod.POST)
    public @ResponseBody String updateAuto(@ModelAttribute("auto") Auto auto) {
        Auto result =  autoService.getAutoById(auto.getId());
        System.out.println("");
        if(result == null){
            throw new ResourceNotFoundException();
        } else {
            this.autoService.updateAuto(auto);
            return "Auto is updated";
        }
    }

    @GetMapping(value = "auto/remove")
    public @ResponseBody String removeAuto(@RequestParam int id){
        String result = autoService.removeAuto(id);
        if (result == null){
            throw new ResourceNotFoundException();
        } else {
            return result;
        }
    }

    @GetMapping(value = "auto/getAuto")
    public @ResponseBody Auto getAuto(@RequestParam int id){
        Auto auto = autoService.getAutoById(id);
        if (auto == null){
            throw new ResourceNotFoundException();
        } else {
            return auto;
        }
    }

    @GetMapping(value = "auto/{idAuto}")
    public @ResponseBody Auto getAutoByVariable(@PathVariable int idAuto){
           Auto result =  autoService.getAutoById(idAuto);
           if(result == null) {
               throw new ResourceNotFoundException();
           } else {
               return result;
           }
    }

    @GetMapping(value = "test")
    public @ResponseBody String test(){
        return "test string";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final class ResourceNotFoundException extends RuntimeException {
        //  class definition
    }
}
