package com.tecacet.jtemplates;

import org.rythmengine.RythmEngine;

import java.io.File;
import java.io.Writer;
import java.util.HashMap;

public class RythmTemplateRenderer extends BaseTemplateRenderer {

    private final RythmEngine rythmEngine = new RythmEngine(new HashMap<>());

    @Override
    public void evaluate(String template, Writer writer) throws RenderException {
        // TODO figure out how to get template from other sources
        File templateFile = new File(template);
        if (!templateFile.exists()) {
            throw new RenderException("Template does not exist: " + template);
        }
        rythmEngine.render(writer, templateFile, model);

    }

    public RythmEngine getRythmEngine() {
        return rythmEngine;
    }
}
