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
//public class CategoryRepositoryTest {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Test
//    public void testFindCategoryByName() {
//        Category category = new Category();
//        category.setName("TestCategory");
//        categoryRepository.save(category);
//
//        List<Category> foundCategories = categoryRepository.findCategoryByName("TestCategory");
//        assertThat(foundCategories).isNotEmpty();
//        assertThat(foundCategories.get(0).getName()).isEqualTo("TestCategory");
//    }
//}