package com.pluhi.springpostgreSQLslovakia.controller;


import com.pluhi.springpostgreSQLslovakia.model.Village;
import com.pluhi.springpostgreSQLslovakia.service.DistrictService;
import com.pluhi.springpostgreSQLslovakia.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DataController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private VillageService villageService;

    @GetMapping("/districtForm")
    public String districtList(Model model) {
        model.addAttribute("listDistricts", districtService.getAllDistricts());
        return "districts";
    }

    @GetMapping("/villageForm")
    public String villageList(Model model) {
        return findPaginated(1, "id", "asc", model);
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

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5000;

        Page<Village> page = villageService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Village> listVillages = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listVillages", listVillages);
        return "villages";
    }
}

