package com.pluhi.springpostgreSQLslovakia.controller;

import com.pluhi.springpostgreSQLslovakia.model.Village;
import com.pluhi.springpostgreSQLslovakia.service.DistrictService;
import com.pluhi.springpostgreSQLslovakia.service.RegionService;
import com.pluhi.springpostgreSQLslovakia.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DataController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private VillageService villageService;

    @GetMapping("/regionForm")
    public String regionList(Model model) {
        model.addAttribute("listRegions", regionService.getAllRegions());
        return "regions";
    }

    @GetMapping("/districtForm")
    public String districtList(Model model) {
        model.addAttribute("listDistricts", districtService.getAllDistricts());
        return "districts";
    }

    @GetMapping("/villageForm")
    public String villageList(Model model,
                              @Param("keyword") String keyword) {
        List<Village> listVillages = villageService.getAllVillages(keyword);
        model.addAttribute("listVillages", listVillages);
        return "villages";

    }


    @PostMapping("/saveVillage")
    public String saveVillage(@ModelAttribute("village") Village village) {
        // save village to database
        villageService.saveVillage(village);
        return "redirect:/villageForm";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Village village = villageService.getVillageById(id);
        model.addAttribute("village", village);
        return "update_village";
    }

}

