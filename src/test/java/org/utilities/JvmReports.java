package org.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReports {
	public static void generateJvmReport(String path) {
		File f = new File("C:\\Users\\suren\\eclipse-workspace\\MavenTesting1\\target\\Reports");
		Configuration c = new Configuration(f, "Amazon");
		c.addClassifications("Platform", "Windows");
		c.addClassifications("Browser", "Edge");
		c.addClassifications("version", "12.4.6.8");
		List<String> l = new ArrayList<String>();
		l.add(path);
		ReportBuilder r = new ReportBuilder(l, c);
		r.generateReports();
		}
}
