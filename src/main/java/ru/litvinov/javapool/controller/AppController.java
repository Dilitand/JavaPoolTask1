package ru.litvinov.javapool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.javapool.exceptions.ResourceNotFoundException;
import ru.litvinov.javapool.model.entity.Auto;
import ru.litvinov.javapool.service.AutoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    private AutoService autoService;

    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String startPage(){
        return "index";
    }

    @GetMapping(value = "auto/listAuto")
    public @ResponseBody List<Auto> listAuto(){
        return autoService.listAuto();
    }

    @GetMapping(value = "auto/listAutoByModel")
    public @ResponseBody List<Auto> listAutoByModel(@RequestParam String model){
        return autoService.listAutoByModel(model);
    }

    @GetMapping(value = "auto/listAutoByParams")
    public @ResponseBody List<Auto> listAutoByParams(HttpServletRequest request){
        String model = request.getParameter("model");
        String minSpeed = request.getParameter("minSpeed");
        String maxSpeed = request.getParameter("maxSpeed");
        String minMileAge = request.getParameter("minMileAge");
        String maxMileAge = request.getParameter("maxMileAge");
        String currentPage = request.getParameter("page");
        String countPage = request.getParameter("countPage");

        List<Auto> result = autoService.listAutoByParams(model,minSpeed,maxSpeed,minMileAge,maxMileAge,currentPage,countPage);
        if (result == null) {
            throw new ResourceNotFoundException();
        } else {
            return result;
        }
    }

    @RequestMapping(value = "auto/add",method = RequestMethod.POST)
    public @ResponseBody String addAuto(Auto auto) {
        if(auto.getId() == 0){
            int id = this.autoService.addAuto(auto);
            return "Auto with id = " + id + " was added" ;
        } else {
            this.autoService.updateAuto(auto);
            return "Auto is updated";
        }
    }

    @RequestMapping(value = "auto/update",method = RequestMethod.POST)
    public @ResponseBody String updateAuto(Auto auto) {
        Auto result =  autoService.getAutoById(auto.getId());
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

    @GetMapping(value = "auto/pagination")
    public @ResponseBody List<Auto> pagination(@RequestParam int pageSize){
        int currentPosition = 0;
        List<Auto> list = autoService.pagination(currentPosition,pageSize);
        currentPosition = currentPosition+pageSize;
        return null;
    }


    @GetMapping(value = "test")
    public @ResponseBody String test(){
        return "test string";
    }


}
