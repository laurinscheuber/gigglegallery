//package ch.fhnw.webec.exercise.repository;
//
//import ch.fhnw.webec.exercise.model.Category;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class CategoryRepositoryIntegrationTest {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Test
//    public void testFindCategoryByName() {
//        Category category = new Category();
//        category.setName("integrationTestCategory");
//        categoryRepository.save(category);
//
//        List<Category> foundCategories = categoryRepository.findCategoryByName("integrationTestCategory");
//        assertThat(foundCategories).isNotEmpty();
//        assertThat(foundCategories.get(0).getName()).isEqualTo("integrationTestCategory");
//    }
//}