package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.userprofile.UserProfile;
import com.irisa.obiee.backforfront.userprofile.UserProfileService;
import com.irisa.obiee.backforfront.userprofile.UserProfileServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceTests {

    @InjectMocks
    UserProfileServiceImpl userProfileService = new UserProfileServiceImpl();

    @Mock
    UserProfileService userProfileServiceMock;

    @Test
    public void addSomething(){
        UserProfile userProfile = new UserProfile("90007","{'theme':'light'}");
        when(userProfileServiceMock.add(userProfile)).thenReturn(1);
        Assert.assertEquals(userProfileService.add(userProfile),1,1);

        //verify(userProfileServiceMock).add(userProfile);
    }
}
