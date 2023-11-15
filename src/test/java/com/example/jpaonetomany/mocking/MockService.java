package com.example.jpaonetomany.mocking;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.service.ServiceKommuner;
import com.example.jpaonetomany.service.ServiceKommunerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MockService {

    @Test
    void getKommunerStartsWith() {
        ServiceKommuner mockserv = mock(ServiceKommuner.class);
        List<Kommune> lst = new ArrayList<>();
        lst.add(new Kommune("1085", "Roskilde"));
        when(mockserv.getKommunerStartsWith('R')).thenReturn(lst);
        lst = mockserv.getKommunerStartsWith('R');
        assertEquals(1, lst.size());


        //mockserv.getKommunerStartsWith()
    }

}
