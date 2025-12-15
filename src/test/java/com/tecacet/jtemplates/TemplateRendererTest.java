package com.tecacet.jtemplates;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateRendererTest {

	@Test
	public void testVelocity() throws RenderException {
		TemplateRenderer renderer = new VelocityRenderer();
		testRenderString(renderer, "testfiles/mytemplate.vm");
	}

	@Test
	public void testFreemarker() throws RenderException, IOException {
		TemplateRenderer renderer = FreemarkerRenderer.fromFilesystem("testfiles");
		testRenderString(renderer, "mytemplate.ftl");
	}

	@Test
	public void testRythm() throws RenderException {
		TemplateRenderer renderer = new RythmTemplateRenderer();
		testRenderString(renderer, "testfiles/mytemplate.rm");
	}

	@Test
	public void testMustache() {
		TemplateRenderer renderer = new MustacheRenderer();
		testRenderString(renderer, "templates/mytemplate.mustache");
	}

	private void testRenderString(TemplateRenderer renderer, String template) throws RenderException {
		renderer.put("name", "sailor");
		long start = System.currentTimeMillis();
		String str = renderer.render(template);
		long stop = System.currentTimeMillis();
		String message = String.format("Time to render for %s = %d ms", renderer.getClass().getName(), (stop - start));
		assertEquals("Hello sailor!", str);

	}

}
