package com.tecacet.jtemplates.util;

import org.junit.Ignore;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;

@Ignore //TODO: does not work on travis
public class VelocityTableMakerTest {

    @Test
    public void testRenderModel() throws Exception {
        String[] columnNames = {"Volatility", "Risk"};
        TableModel model = new DefaultTableModel(new String[][] { { "3", "2" }, { "1", "0" } },
                columnNames);

        VelocityTableMaker tableMaker = new VelocityTableMaker(model);
        // Html table
        tableMaker.renderModel("HtmlTable.vm", "output/table.html");
        TestUtil.compareLineByLine("table.html");

        // LaTex table
        tableMaker.renderModel("LaTexTable.vm", "output/table.tex");
        TestUtil.compareLineByLine("table.tex");

        new File("output/table.html").delete();
        new File("output/table.tex").delete();
    }

}
