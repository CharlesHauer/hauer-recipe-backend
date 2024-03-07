package fr.hauer.recipe.service;

import fr.hauer.recipe.exception.RecipeNotFoundException;
import fr.hauer.recipe.model.Recipe;
import fr.hauer.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public String delete(Long id) {
        recipeRepository.deleteById(id);
        return "Recipe with id " + id + " has been delete";
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id));
    }

    public Recipe update(Recipe recipe, Long id) {
        return recipeRepository.findById(id).map(recipe1 -> {
            recipe1.setName(recipe.getName());
            recipe1.setDescription(recipe.getDescription());
            recipe1.setImageUrl(recipe.getImageUrl());
            recipe1.setCookTime(recipe.getCookTime());
            recipe1.setCookTime(recipe.getCookTime());
            return recipeRepository.save(recipe1);
        }).orElse(null);
    }
}
