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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

        Operation op = new Operation(OP.SUM, new BigDecimal(2), new BigDecimal(1));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sum?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }

    @Test
    void testSub() throws Exception{

        Operation op = new Operation(OP.SUB, new BigDecimal(2), new BigDecimal(1));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/sub?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }


    @Test
    void testDiv() throws Exception{

        mvc.perform(get("/div?a=2&b=0"))
                .andExpect(status().is4xxClientError()); //div por 0 retorna erro

    }

    @Test
    void testMul() throws Exception{

        Operation op = new Operation(OP.MUL, new BigDecimal(2), new BigDecimal(1));
        BigDecimal opResult = CalculatorController.calculate(op);

        mvc.perform(get("/mul?a=2&b=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value(opResult));

    }
}
