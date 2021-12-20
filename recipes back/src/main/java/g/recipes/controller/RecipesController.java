package g.recipes.controller;

import g.recipes.model.Recipes;
import g.recipes.repository.RecipesRepository;
import g.recipes.service.IRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/recipes")
public class RecipesController {

    @Autowired
    IRecipesService iRecipesService;
    @Autowired
    private RecipesRepository recipesRepository;


    @GetMapping
    public List<Recipes> getRecipes() {
        return recipesRepository.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipes>> getCategoryByName(@RequestParam(value = "q")@PathVariable String name)  {

        return ResponseEntity.ok(iRecipesService.getRecipesByTitle(name));
    }

    @PostMapping
    public Recipes createEmployee(@RequestBody Recipes recipes) {
        return recipesRepository.save(recipes);
    }


    @GetMapping("/{recipesId}")
    public ResponseEntity<Optional<Recipes>> getCategoryById(@PathVariable Long recipesId) throws ChangeSetPersister.NotFoundException {

        return ResponseEntity.ok(iRecipesService.getRecipesById(recipesId));
    }



    //    @GetMapping("/page")
//    ResponseEntity<?> getRecipesPageable(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 6) Pageable pageable,
//                                            @RequestParam(value = "page", defaultValue = "0") int page, HttpServletRequest request) {
//
//        PageDto<Recipes> r = iRecipesService.getPageableRecipes(pageable, request);
//        return ResponseEntity.status(HttpStatus.OK).body(r);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<?> updateCategory(@RequestBody Recipes recipes, @PathVariable(name = "id") long id) {
//        return new ResponseEntity<>(iRecipesService.updateEmployee(recipes, id), HttpStatus.OK);
//    }

}
