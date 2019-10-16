package com.tecacet.jtemplates;

import java.io.Writer;
import java.util.Map;

public interface TemplateRenderer {

    /**
     * Populate the context with a named variable
     * 
     * @param name unique key for this value as it appears on the template
     * @param value the value
     */
    void put(String name, Object value);

    /**
     * Populate all values
     * @param values
     */
    void putAll(Map<String, ?> values);

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
     * @param templateFile the template file
     * @param name the identifier for the value
     * @param model the value
     * @return a String representation of the filled in template
     * @throws RenderException
     */
    String render(String templateFile, String name, Object model) throws RenderException;
    
    /**
     * Render the template as a string using a map for named objects
     * 
     * @param templateFile the template file
     * @param model the model
     * @throws RenderException if something fails
     */
    void render(String templateFile, Map<String,?> model, Writer writer) throws RenderException;
    

    /**
     * Render the template as a string
     * 
     * @param templateFile the template file
     * @return a string containing the final output
     * @throws RenderException if something fails
     */
    String render(String templateFile) throws RenderException;



}