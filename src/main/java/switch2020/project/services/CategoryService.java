package switch2020.project.services;

import switch2020.project.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private List<Category> categories;

    public CategoryService(){
        this.categories = new ArrayList<>();
    }

    /**
     * Method to add a Standard Category to the list of Categories in the application
     * @param categoryName String - name of the category to be added to the list
     * @return true if the category was created and added successful, false otherwise
     */

    public boolean addStandardCategory (String categoryName){
        if (isCategoryAlreadyPresent(categoryName)) return false;
        try {
            Category newCategory = new Category(categoryName);
            categories.add(newCategory);
            return true;
        } catch (IllegalArgumentException nameException) {
            return false;
        }
    }

    /**
     * Method to determine if a new category is present in the list of categories
     * @param categoryName String with the name of the category
     * @return true if a category with the same name already exists in the list, false otherwise
     */

    private boolean isCategoryAlreadyPresent(String categoryName){
        int size = this.categories.size();
        boolean categoryPresent = false;
        for (int index = 0; index < size; index++) {
            if(this.categories.get(index).getName().compareToIgnoreCase(categoryName)==0) {
                categoryPresent = true;
                index = size;
            }
        }
        return categoryPresent;
    }


}