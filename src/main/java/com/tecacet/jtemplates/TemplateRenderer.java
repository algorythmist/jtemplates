package com.tecacet.jtemplates;

import java.io.Writer;
import java.util.Map;

public interface TemplateRenderer {

    /**
     * Populate the context with a named variable
     * 
     * @param name
     * @param value
     */
    void put(String name, Object value);

    /**
     * Clear the context
     */
    void clear();

    /**
     * Evaluate the given template and output to a writer
     * 
     * @param templateFile
     * @param writer
     * @throws RenderException
     */
    void evaluate(String templateFile, Writer writer) throws RenderException;

    /**
     * Render the template as a string using a named variable
     * 
     * @param templateFile
     * @param name
     * @param model
     * @return
     * @throws RenderException
     */
    String render(String templateFile, String name, Object model) throws RenderException;
    
    /**
     * Render the template as a string using a map for named objects
     * 
     * @param templateFile
     * @param model
     * @return
     * @throws RenderException
     */
    String render(String templateFile, Map<String,?> model) throws RenderException;
    

    /**
     * Render the template as a string
     * 
     * @param templateFile
     * @return
     * @throws RenderException
     */
    String render(String templateFile) throws RenderException;

    void putAll(Map<String, ?> values);

}