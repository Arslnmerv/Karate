package tests;


import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;


//@CucumberOptions(tags = {"~@tag"})
public class TestRunner {

//    @Karate.Test
//    Karate testAll() {
//
//        return Karate.run().relativeTo(getClass());
//    }


//    @Test
//    public void testParallel() {
//        KarateStats stats = CucumberRunner.parallel(getClass(), 5, "target/surefire-reports");
//        assertTrue("scenarios failed", stats.getFailCount() == 0);
//    }


//    @Test
//    public void testParallel() {
//        Results results = Runner.path("classpath:tests")
//                .outputCucumberJson(true)
//                .karateEnv("demo")
//                .parallel(5);
//        generateReport(results.getReportDir());
//        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
//    }

    @Test
    public void testParallel(){
        Results results = Runner.path("C:\\Users\\Administrator\\IdeaProjects\\Karate-Beginner\\src\\test\\java\\tests\\TestRunner.java")
                .tags("@tag").parallel(1);

        generateReport(results.getReportDir());
    }
    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}
