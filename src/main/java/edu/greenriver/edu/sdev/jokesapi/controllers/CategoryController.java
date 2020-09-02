package edu.greenriver.edu.sdev.jokesapi.controllers;

import edu.greenriver.edu.sdev.jokesapi.entities.Category;
import edu.greenriver.edu.sdev.jokesapi.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    //GET
    @GetMapping("")
    public ResponseEntity<List<Category>> allCategories() {
        return new ResponseEntity<>(service.getCategories(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> categoryById(@PathVariable int id) {
        if (id < 0) {
            return new ResponseEntity<>("Invalid id",
                    HttpStatus.BAD_REQUEST);
        }
        else if (!service.categoryExists(id)) {
            return new ResponseEntity<>("Category not found",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service.getCategoryById(id),
                HttpStatus.OK);
    }

    //POST
    @PostMapping("")
    public ResponseEntity<Object> addCategory(@RequestBody Category category) {
        if (category.getDescription().isEmpty()) {
            return new ResponseEntity<>("Invalid category submitted",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.addCategory(category),
                HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("{id}")
    public ResponseEntity<Object> editCategory(@PathVariable int id,
                         @RequestBody Category category) {
        if (!service.categoryExists(id)) {
            return new ResponseEntity<>("Category not found",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(service.editCategory(id, category),
                HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        if (!service.categoryExists(id)) {
            return new ResponseEntity<>("Category not found",
                    HttpStatus.NOT_FOUND);
        }

        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> exceptionHandler(Exception ex)
    {
        String message = "Category should be formatted: {\"category\": \"...\"}";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }*/
}
