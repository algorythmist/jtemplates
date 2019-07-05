package com.tecacet.jtemplates;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class FreemarkerRenderer extends BaseTemplateRenderer {

    private final Configuration configuration = new Configuration(Configuration.getVersion());

    public FreemarkerRenderer() {
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.getVersion()));
    }

    @Override
    public void evaluate(String template, Writer writer) throws RenderException {
        try {
            Template temp = configuration.getTemplate(template);
            temp.process(model, writer);
        } catch (Exception e) {
            throw new RenderException(e);
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public static TemplateRenderer fromFilesystem(String templateDirectory) throws IOException  {
    	FreemarkerRenderer renderer = new FreemarkerRenderer();
    	renderer.configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
    	return renderer;
    }
    
    public static TemplateRenderer fromClasspath(String templateDirectory) {
    	FreemarkerRenderer renderer = new FreemarkerRenderer();
    	renderer.configuration.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), templateDirectory);
    	return renderer;
    }
    
}
