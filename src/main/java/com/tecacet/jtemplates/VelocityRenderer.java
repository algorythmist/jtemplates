package com.tecacet.jtemplates;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.Writer;
import java.util.Properties;

public class VelocityRenderer extends BaseTemplateRenderer {

    private final VelocityContext velocityContext;

    public VelocityRenderer() {
        Properties p = new Properties();
        p.put("resource.loader", "file, class, jar");
        p.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        try {
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        velocityContext = new VelocityContext();
    }

    @Override
    public void put(String name, Object value) {
        velocityContext.put(name, value);
    }

    @Override
    public void clear() {
        for (Object key : velocityContext.getKeys()) {
            velocityContext.remove(key);
        }
    }

    @Override
    public void evaluate(String templateFile, Writer writer) throws RenderException {
        try {
            Template template = Velocity.getTemplate(templateFile);
            template.merge(velocityContext, writer);
        } catch (Exception e) {
            throw new RenderException(e);
        }
    }

    public VelocityContext getVelocityContext() {
        return velocityContext;
    }
}
