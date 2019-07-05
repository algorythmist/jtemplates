package com.tecacet.jtemplates.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Example of how to use RenderedTableModel to display a table with velocity
 */
public class VelocityTableMaker {

    private final FormattedTableModel model;

    public VelocityTableMaker(TableModel tableModel) {
        this.model = new FormattedTableModel(tableModel);
        Properties p = new Properties();
        p.put("resource.loader", "file, class, jar");
        p.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // p.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        try {
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String renderModel(String templateFile) {
        Template template = Velocity.getTemplate(templateFile);
        VelocityContext context = new VelocityContext();
        context.put("model", model);
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        return sw.toString();
    }

    public void renderModel(String templateFile, String outputFile) throws IOException {
        String s = renderModel(templateFile);
        PrintStream ps = new PrintStream(new File(outputFile), "UTF-8");
        ps.println(s);
        ps.close();
    }
}
