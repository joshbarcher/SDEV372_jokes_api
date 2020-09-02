package edu.greenriver.edu.sdev.jokesapi.services;

import edu.greenriver.edu.sdev.jokesapi.entities.Category;
import edu.greenriver.edu.sdev.jokesapi.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    private ICategoryRepository repo;

    public CategoryService(ICategoryRepository repo) {
        this.repo = repo;
    }

    //GET
    public List<Category> getCategories() {
        return repo.findAll();
    }

    public Category getCategoryById(int id) {
        return repo.findById(id).get();
    }

    public boolean categoryExists(int id) {
        return repo.findById(id).isPresent();
    }

    //POST
    public Category addCategory(Category category) {
        return repo.save(category);
    }

    //PUT
    public Category editCategory(int id, Category category) {
        Category toEdit = repo.findById(id).get();
        toEdit.setDescription(category.getDescription());
        return repo.save(toEdit);
    }

    //DELETE
    public void deleteCategory(int id) {
        repo.deleteById(id);
    }
}
