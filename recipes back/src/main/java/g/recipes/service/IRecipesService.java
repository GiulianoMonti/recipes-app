package g.recipes.service;

import g.recipes.model.Recipes;

import java.util.List;
import java.util.Optional;

public interface IRecipesService {
//    PageDto<Recipes> getPageableCategory(Pageable pageable, HttpServletRequest request);

    //    Recipes updateEmployee(Recipes dto, Long id);
    Optional<Recipes> getRecipesById(Long recipesId);

    List<Recipes> getRecipesByTitle(String name);


}
