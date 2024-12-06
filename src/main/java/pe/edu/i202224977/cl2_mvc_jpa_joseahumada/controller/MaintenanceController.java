package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto.*;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    //listar
    @GetMapping("/start")
    public String start(Model model) {

        List<FilmListDto> filmListDtos = maintenanceService.getAllFilms();
        model.addAttribute("films", filmListDtos);

        return "maintenance-list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        FilmEditDto filmEditDto = maintenanceService.getFilmEditById(id);
        model.addAttribute("filmEditDto", filmEditDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit/{id}")
    public String editFilm(@PathVariable Integer id, @ModelAttribute FilmEditDto filmEditDto) {
        maintenanceService.postFilmEditById(id, filmEditDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/create")
    public String create(Model model) {

        FilmCreateDto filmCreateDto = maintenanceService.getFilmCreate();
        model.addAttribute("filmCreateDto", filmCreateDto);
        return "maintenance-create";
    }

    @PostMapping("/create")
    public String createFilm(@ModelAttribute FilmCreateDto filmCreateDto) {
        maintenanceService.postFilmCreate(filmCreateDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        FilmDeleteDto filmDeleteDto = maintenanceService.getFilmDeleteById(id);
        model.addAttribute("filmDeleteDto", filmDeleteDto);
        return "maintenance-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteFilmById(@PathVariable int id, @ModelAttribute FilmDeleteDto filmDeleteDto) {

        maintenanceService.postFilmDeleteById(id, filmDeleteDto);
        return "redirect:/maintenance/start";
    }





}
