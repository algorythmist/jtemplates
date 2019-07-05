package com.tecacet.jtemplates;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTemplateRenderer implements TemplateRenderer {
	
    protected Map<String, Object> model = new HashMap<>();

    @Override
    public void put(String name, Object value) {
        model.put(name, value);
    }

    @Override
    public void putAll(Map<String, ?> values) {
        for (Map.Entry<String, ?> e : values.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }
    
    @Override
    public void clear() {
        model.clear();
    }
    

    @Override
    public String render(String templateFile, String name, Object model) throws RenderException {
        put(name, model);
        StringWriter sw = new StringWriter();
        evaluate(templateFile, sw);
        return sw.toString();
    }

    @Override
    public String render(String templateFile) throws RenderException {
        StringWriter sw = new StringWriter();
        evaluate(templateFile, sw);
        return sw.toString();
    }
}
