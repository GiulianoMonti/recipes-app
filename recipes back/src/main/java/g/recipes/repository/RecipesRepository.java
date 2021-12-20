package g.recipes.repository;


import g.recipes.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {

    List<Recipes> findByTitle(String name);

}
