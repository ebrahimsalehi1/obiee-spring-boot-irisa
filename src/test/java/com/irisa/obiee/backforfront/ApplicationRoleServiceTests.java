package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.obieeservices.ApplicationRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationRoleServiceTests {

    @Mock
    ApplicationRoleService applicationRoleService;

    @Test
    public void serviceHHasAdminRole(){
        when(applicationRoleService.hasAdminRole("z.omidvar")).thenReturn(false);

    }

}
