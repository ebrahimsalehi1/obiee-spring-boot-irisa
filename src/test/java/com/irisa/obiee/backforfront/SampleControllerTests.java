package com.irisa.obiee.backforfront;

import com.irisa.obiee.backforfront.samples.SampleController;
import com.irisa.obiee.backforfront.samples.SampleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class SampleControllerTests {

    @Autowired
    SampleController sampleController;

    @Autowired
    SampleService sampleService;

    @BeforeEach
    public void create(){
        //sampleService = new SampleService();
    }

    @Test
    public void doTestSample(){

//        SampleService sampleServiceMock = Mockito.mock(SampleService.class);
//        Mockito.when(sampleServiceMock.getType("1")).thenReturn("1");

//        Assert.assertEquals(sampleService.getType(sampleServiceMock.getType("1")),"1");

        //ArgumentCaptor<String> stringArgumentCaptor=
    }
}
