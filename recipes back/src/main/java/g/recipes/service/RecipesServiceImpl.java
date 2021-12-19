package g.recipes.service;


import g.recipes.model.Recipes;
import g.recipes.repository.RecipesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Service
public class RecipesServiceImpl implements IRecipesService {

    @Autowired
    RecipesRepository recipesRepository;


//    @Override
//    public PageDto<Recipes> getPageableCategory(Pageable pageable, HttpServletRequest request) {
//
//        Map<String, String> links = new HashMap<>();
//
//        PageDto<Recipes> pageDto = new PageDto<>();
//
//        Page<Recipes> pageList = recipesRepository.findAll(pageable);
//
//        List<Recipes> responseDto = new ArrayList<>();
////        pageList.getContent().forEach(element -> responseDto.add
////                (mapper.map(element,CategoryListRespDto.class)));
//
//        links.put("next", pageList.hasNext() ? makePaginationLink(request, pageable.getPageNumber() + 1) : "");
//        links.put("previous", pageList.hasPrevious() ? makePaginationLink(request, pageable.getPageNumber() - 1) : "");
//
//        pageDto.setLinks(links);
//        pageDto.setContent(pageList);
//        return pageDto;
//
//
//    }

//    @Override
//    public Recipes updateEmployee(Recipes recipes, Long id) {
//        Recipes updatedEmployee = recipesRepository.findById(id).orElseThrow(null);
//        log.error("empleado"+updatedEmployee);
//        updatedEmployee.setFirstName(recipes.getFirstName());
//        updatedEmployee.setLastName(recipes.getLastName());
//        updatedEmployee.setEmailId(recipes.getEmailId());
//
//        return recipesRepository.save(updatedEmployee);
//    }


    private String makePaginationLink(HttpServletRequest request, int page) {
        return String.format("%s?page=%d", request.getRequestURI(), page);
    }


    @Override
    public Optional<Recipes> getRecipesById(Long recipesId) {

        Optional<Recipes> recipes = recipesRepository.findById(recipesId);

        return recipes;
    }
}

