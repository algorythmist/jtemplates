package com.tecacet.jtemplates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelocityRendererTest {

    @Test
    public void testRenderFromFilesystem() {
        TemplateRenderer renderer =  new VelocityRenderer();
        String str = renderer.render("mytemplate.vm", "name", "soldier");
        assertEquals("Hello soldier!", str);
    }
    
    @Test
    public void testRenderFromClasspath() {
        TemplateRenderer renderer =  new VelocityRenderer();
        String str = renderer.render("mytemplate.vm", "name", "soldier");
        assertEquals("Hello soldier!", str);
    }

    @Test(expected = RenderException.class)
    public void testException() {
        TemplateRenderer renderer =  new VelocityRenderer();
        renderer.render("bad.vm", "name", "soldier");
    }
}
