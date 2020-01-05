package me.jung.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
    //비동기로 처리

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    //로그에찍히는것을 확인할수있도록

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        when(mockSampleService.getName()).thenReturn("jinwoo");

       mockMvc.perform(get("/hello"))
               .andExpect(content().string("hellojinwoo"));
       assertThat(outputCapture.toString())
               .contains("holoman")
               .contains("skip");
    }
}
