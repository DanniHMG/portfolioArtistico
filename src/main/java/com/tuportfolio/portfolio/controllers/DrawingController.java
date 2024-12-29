package com.tuportfolio.portfolio.controllers;

import com.tuportfolio.portfolio.models.Drawing;
import com.tuportfolio.portfolio.services.DrawingService;
import com.tuportfolio.portfolio.services.FileService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/drawings")
public class DrawingController {

    @Autowired
    private DrawingService drawingService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public String listDrawing(Model model) {
        model.addAttribute("drawings", drawingService.getAllDrawings());
        return "drawings/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("drawing", new Drawing());
        return "drawings/form";
    }

    @PostMapping
    public String saveDrawing(@ModelAttribute Drawing drawing,
            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = fileService.saveFile(file);
            drawing.setFileName(fileName);
        }
        drawingService.saveDrawing(drawing);
        return "redirect:/drawings";
    }

    @GetMapping("/{id}")
    public String showDrawing(@PathVariable Long id, Model model) {
        model.addAttribute("drawing", drawingService.getDrawingById(id).orElse(null));
        return "drawings/detail";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Drawing> drawing = drawingService.getDrawingById(id);
        if (drawing.isPresent()) {
            model.addAttribute("drawing", drawing.get());
            return "drawings/form"; // Corregido aquí
        }
        return "redirect:/drawings";
    }

    @PostMapping("/edit/{id}")
    public String updateDrawing(@PathVariable Long id, @ModelAttribute Drawing drawing) {
        drawing.setId(id);
        drawingService.saveDrawing(drawing);
        return "redirect:/drawings";
    }

    @GetMapping("/delete/{id}")
    public String deleteDrawing(@PathVariable Long id) {
        drawingService.deleteDrawing(id);
        return "redirect:/drawings";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "Prueba de Thymeleaf");
        return "drawings/test";
    }

}