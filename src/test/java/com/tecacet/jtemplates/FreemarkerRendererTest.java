package com.tecacet.jtemplates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreemarkerRendererTest {

    @Test
    public void testRenderFromFilesystem() throws Exception {
        TemplateRenderer renderer =  FreemarkerRenderer.fromFilesystem("testfiles");
        String str = renderer.render("mytemplate.ftl", "name", "soldier");
        assertEquals("Hello soldier!", str);
    }
    
    @Test
    public void testRenderFromClasspath() throws Exception {
        TemplateRenderer renderer =  FreemarkerRenderer.fromClasspath("templates");
        String str = renderer.render("mytemplate.ftl", "name", "soldier");
        assertEquals("Hello soldier!", str);
    }

}
