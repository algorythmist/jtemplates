package com.tecacet.jtemplates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VelocityRendererTest {

    @Test
    public void testRenderFromFilesystem() {
        TemplateRenderer renderer =  new VelocityRenderer();
        String str = renderer.render("mytemplate.vm", "name", "there");
        assertEquals("Hello there!", str);
    }
    
    @Test
    public void testRenderFromClasspath() {
        TemplateRenderer renderer =  new VelocityRenderer();
        String str = renderer.render("mytemplate.vm", "name", "there");
        assertEquals("Hello there!", str);
    }

    @Test
    public void testException() {
        TemplateRenderer renderer =  new VelocityRenderer();
        assertThrows(RenderException.class, () -> renderer.render("bad.vm", "name", "there"));
    }
}
