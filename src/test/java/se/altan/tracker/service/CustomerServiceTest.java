package se.altan.tracker.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.ObjectFactory;
import se.altan.tracker.dao.CustomerDAO;
import se.altan.tracker.exception.ResourceNotFoundException;
import se.altan.tracker.response.Customer;
import se.altan.tracker.util.MockCustomers;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
/**
 * Service to test all customers with vehicles from dataStore
 *@author Parasuram
 **/
public class CustomerServiceTest {

    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerServiceImpl mockCustomerService;

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private ObjectFactory<Customer> customerObjectFactory;

    @Mock
    private Customer mockCustomer;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCustomers() {
        Customer mockResponse = MockCustomers.mockCustomers();
        when(customerService.getCustomers()).thenReturn(mockResponse);
        Assert.assertNotNull(customerService.getCustomers());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testCustomersIfEmpty() {
        when(customerObjectFactory.getObject()).thenReturn(mockCustomer);
        when(customerDAO.getCustomers()).thenReturn(MockCustomers.emptyCustomers());
        mockCustomerService.getCustomers();
    }
}
