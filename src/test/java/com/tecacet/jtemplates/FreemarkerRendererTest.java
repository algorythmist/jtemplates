package com.tecacet.jtemplates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreemarkerRendererTest {

    @Test
    public void testRenderFromFilesystem() throws Exception {
        TemplateRenderer renderer =  FreemarkerRenderer.fromFilesystem("testfiles");
        String str = renderer.render("mytemplate.ftl", "name", "there");
        assertEquals("Hello there!", str);
    }
    
    @Test
    public void testRenderFromClasspath()  {
        TemplateRenderer renderer =  FreemarkerRenderer.fromClasspath("templates");
        String str = renderer.render("mytemplate.ftl", "name", "there");
        assertEquals("Hello there!", str);
    }

}
