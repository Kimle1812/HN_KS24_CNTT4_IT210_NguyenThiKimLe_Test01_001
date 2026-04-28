package org.example.artworkmanagement.controller;

import jakarta.validation.Valid;
import org.example.artworkmanagement.model.Artwork;
import org.example.artworkmanagement.repository.IArtworkRepository;
import org.example.artworkmanagement.service.IArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {
    @Autowired
    private IArtworkService artworkService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("list", artworkService.getAllArtwork());
        return "list";
    }

    //Thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("artwork", new Artwork());
        return "add";
    }

    @PostMapping("/add")
    public String addArtwork(
            @Valid
            @ModelAttribute("artwork")
            Artwork artwork,
            BindingResult result
    ){
        if (result.hasErrors() ) {
            return "add";
        }
        artworkService.save(artwork);
        return "redirect:/artworks";
    }

    //Sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("artwork", artworkService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editAddwork(
            @Valid
            @ModelAttribute("artwork")
            Artwork artwork,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "edit";
        }
        artworkService.save(artwork);
        return "redirect:/artworks";
    }
    //Xóa
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable Long id
    ){
        artworkService.delete(id);
        return "redirect:/artworks";
    }
}
