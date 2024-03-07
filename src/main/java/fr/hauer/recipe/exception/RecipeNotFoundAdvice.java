package fr.hauer.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RecipeNotFoundAdvice {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecipeNotFoundException.class)
    public Map<String,String> recipeNotFound(RecipeNotFoundException e) {
        Map<String,String> map = new HashMap<>();
        map.put("errorMessage", e.getMessage());
        return map;
    }
}
