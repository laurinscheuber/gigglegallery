//package ch.fhnw.webec.exercise.controller;
//
//import ch.fhnw.webec.exercise.model.Category;
//import ch.fhnw.webec.exercise.service.CategoryService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CategoryControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Test
//    public void testAddCategory() throws Exception {
//        Category category = new Category();
//        category.setName("integrationTestCategory");
//
//        mockMvc.perform(post("/categories")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"integrationTestCategory\"}"))
//            .andExpect(status().isOk());
//    }
//}