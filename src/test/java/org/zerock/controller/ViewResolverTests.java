package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.ViewResolverComposite;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { org.zerock.config.ServletConfig.class, org.zerock.config.WebConfig.class })
@Log4j

public class ViewResolverTests {


    @Test
    public void test1(){



    }

}
