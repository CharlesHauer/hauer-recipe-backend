package fr.hauer.recipe.controller;

import fr.hauer.recipe.model.Recipe;
import fr.hauer.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return recipe;
    }

    @DeleteMapping("/recipe/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        return recipeService.delete(id);
    }

    @PutMapping("/recipe/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        return recipeService.update(recipe, id);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.findById(id);
    }


}
