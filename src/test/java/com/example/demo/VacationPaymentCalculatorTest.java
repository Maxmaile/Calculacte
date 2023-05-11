package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class VacationPaymentCalculatorTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCalculateVacationPayment() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("vocation", "10")
						.param("average", "5000"))
				.andExpect(status().isOk())
				.andExpect(content().string("2083.3333333333335"));
	}

	@Test
	public void testCalculateVacationPaymentWithNegativeVacation() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("vocation", "-10")
						.param("average", "5000"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCalculateVacationPaymentWithNegativeAverage() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("vocation", "10")
						.param("average", "-5000"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCalculateVacationPaymentWithZeroAverage() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("vocation", "10")
						.param("average", "0"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCalculateVacationPaymentWithNullVacation() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("average", "5000"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCalculateVacationPaymentWithNullAverage() throws Exception {
		mockMvc.perform(get("/calculacte")
						.param("vocation", "10"))
				.andExpect(status().isBadRequest());
	}
}

