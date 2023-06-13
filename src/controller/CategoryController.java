package controller;

import modal.Category;
import modal.User;
import service.CategoryService;

public class CategoryController {
   private CategoryService categoryService = new CategoryService();

   public Category[] getAll() {
      return categoryService.getAll();
   }

   public int getSize() {
      return categoryService.getSize();
   }

   public void save(Category category) {
      categoryService.save(category);
   }

   public void delete(int id) {
      categoryService.deleteCategory(id);
   }

   public Category findById(int id) {
      return categoryService.findById(id);
   }

   public int getNewId() {
      return categoryService.getNewId();
   }
}
