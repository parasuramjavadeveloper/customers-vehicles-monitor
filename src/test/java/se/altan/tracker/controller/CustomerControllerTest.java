package se.altan.tracker.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.altan.tracker.service.CustomerService;
import se.altan.tracker.util.MockCustomers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
/**
 * Controller to test all customers with vehicles rest service
 *@author Parasuram
 **/
public class CustomerControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CustomerService customerService;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * This method used to test the customers service using mockMvc
     * and check actual data from expected results
     *
     * @author Parasuram
     **/
    @Test
    public void testCustomers() throws Exception {
        when(customerService.getCustomers()).thenReturn(MockCustomers.mockCustomers());
        MvcResult mvcResult = mockMvc
                .perform(get("http://localhost:8097/api/v1/customers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customerList[0].customerName").value("Kalles Grustransporter AB"))
                .andExpect(jsonPath("$.customerList[0].address").value("Cementvägen 8"))
                .andExpect(jsonPath("$.customerList[0].pinCode").value("111 11"))
                .andExpect(jsonPath("$.customerList[0].city").value("Södertälje"))
                .andExpect(jsonPath("$.customerList[0].vehicleList[0].vehicleId").value("YS2R4X20005399401"))
                .andExpect(jsonPath("$.customerList[0].vehicleList[0].regNo").value("ABC123"))
                .andExpect(jsonPath("$.customerList[0].vehicleList[0].status").value("CONNECTED"))
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), 200);
    }

}
