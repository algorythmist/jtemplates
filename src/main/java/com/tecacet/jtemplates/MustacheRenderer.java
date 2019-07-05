package com.tecacet.jtemplates;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.Writer;

public class MustacheRenderer extends BaseTemplateRenderer {

    private final MustacheFactory mustacheFactory = new DefaultMustacheFactory();

    @Override
    public void evaluate(String templateFile, Writer writer) throws RenderException {
        Mustache m = mustacheFactory.compile(templateFile);
        try {
            m.execute(writer, model).flush();
        } catch (IOException e) {
           throw new RenderException(e);
        }
    }

    public MustacheFactory getMustacheFactory() {
        return mustacheFactory;
    }
}
