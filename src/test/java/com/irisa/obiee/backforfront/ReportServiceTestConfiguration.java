package com.irisa.obiee.backforfront;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ReportServiceTestConfiguration {
//    @Bean
//    @Primary
//    public ReportService reportService(){
//        return Mockito.mock(ReportService.class);
//    }
}
