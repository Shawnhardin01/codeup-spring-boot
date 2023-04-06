//package com.codeup.codeupspringblog;
//
//import com.codeup.codeupspringblog.repositories.AdRepository;
//import com.codeup.codeupspringblog.repositories.PostRepository;
//import com.codeup.codeupspringblog.repositories.UserRepository;
//import com.codeup.codeupspringblog.repositories.models.Post;
//import com.codeup.codeupspringblog.repositories.models.User;
//import jakarta.servlet.http.HttpSession;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static junit.framework.TestCase.assertNotNull;
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CodeupSpringBlogApplication.class)
//@AutoConfigureMockMvc
//public class AdsIntegrationTests {
//
//    private User testUser;
//    private HttpSession httpSession;
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    UserRepository userDao;
//
//    @Autowired
//    PostRepository postDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Before
//    public void setup() throws Exception {
//
//        testUser = userDao.findByUsername("testUser");
//
//        // Creates the test user if not exists
//        if (testUser == null) {
//            User newUser = new User();
//            newUser.setUsername("craig");
//            newUser.setPassword(passwordEncoder.encode("pass"));
//            newUser.setEmail("testUser@codeup.com");
//            testUser = userDao.save(newUser);
//        }
//
//        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
//        httpSession = this.mvc.perform(
//                        MockMvcRequestBuilders.post("/login").with(csrf())
//                        .param("username", "testUser")
//                        .param("password", "pass"))
//                .andExpect(status().is(HttpStatus.FOUND.value()))
//                .andExpect(redirectedUrl("/ads"))
//                .andReturn()
//                .getRequest()
//                .getSession();
//
//    }
//        @Test
//        public void contextLoads() {
//            // Sanity Test, just to make sure the MVC bean is working
//            assertNotNull(mvc);
//        }
//    @Test
//    public void testAdsIndex() throws Exception {
//        Post existingpost = postDao.findAll().get(0);
//
//        // Makes a Get request to /ads and verifies that we get some of the static text of the ads/index.html template and at least the title from the first Ad is present in the template.
//        this.mvc.perform(MockMvcRequestBuilders.get("/post"))
//                .andExpect(status().isOk())
//                // Test the static content of the page
//                .andExpect((ResultMatcher) content().string(containsString("All ads")))
//                // Test the dynamic content of the page
//                .andExpect((ResultMatcher) content().string(containsString(existingpost.getTitle())));
//    }
//
//
//
//    @Test
//    public void testEditAd() throws Exception {
//        // Gets the first Ad for tests purposes
//        Post existingpost = postDao.findAll().get(1);
//
//        // Makes a Post request to /ads/{id}/edit and expect a redirection to the Ad show page
//        this.mvc.perform(
//                        MockMvcRequestBuilders.post("/post/edit/" + existingpost.getId()).with(csrf())
//                                .session((MockHttpSession) httpSession)
//                                .param("title", "edited the title again")
//                                .param("body", "edited the description again")
//                                .param("id", "1"))
//                .andExpect(status().is3xxRedirection());
//
//        // Makes a GET request to /ads/{id} and expect a redirection to the Ad show page
//        this.mvc.perform(
//                        MockMvcRequestBuilders.get("/post/" + existingpost.getId()).with(csrf()).session((MockHttpSession) httpSession))
//                .andExpect(status().isOk())
//                // Test the dynamic content of the page
//                .andExpect(MockMvcResultMatchers.content().string(containsString("edited the title again")))
//                .andExpect(MockMvcResultMatchers.content().string(containsString("edited the description again")));
//    }
//
//}
