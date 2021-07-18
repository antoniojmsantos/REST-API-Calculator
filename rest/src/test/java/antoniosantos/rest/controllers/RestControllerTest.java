package antoniosantos.rest.controllers;

import antoniosantos.calculator.controllers.CalculatorController;
import antoniosantos.calculator.models.OP;
import antoniosantos.calculator.models.Operation;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(RestController.class)
@MockBean(RestController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testSum() throws Exception{

        Operation op = new Operation(OP.SUM, new BigDecimal(1), new BigDecimal(2));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sum?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }

    @Test
    void testSum() throws Exception{

        Operation op = new Operation(OP.SUM, new BigDecimal(1), new BigDecimal(2));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sum?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }


    @Test
    void testDiv() throws Exception{

        Operation op = new Operation(OP.SUM, new BigDecimal(1), new BigDecimal(2));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sum?a=2&b=0"))
                .andExpect(status().is4xxClientError()); //div por 0 retorna erro

    }

    @Test
    void testMul() throws Exception{

        Operation op = new Operation(OP.SUM, new BigDecimal(1), new BigDecimal(2));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sum?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }
}
