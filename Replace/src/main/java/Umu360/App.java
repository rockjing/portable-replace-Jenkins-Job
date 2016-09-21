package Umu360;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.*;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {

        Options options = buildOptions();
        CommandLine cmd = new BasicParser().parse(options, args);

        displayHelpIfNeeded(options, cmd);

        File targetFolder = new File(cmd.getOptionValue("d"));

        if(targetFolder.isDirectory())
            System.out.println(targetFolder.getAbsolutePath());



//        File target = new File(cmd.getArgs()[0]);
//        File config = new File(cmd.getOptionValue("c"));
//
//        verify(target, config);
//
//        PlexusContainer container = new DefaultPlexusContainer();
//        PortableConfigEngine engine = container.lookup(PortableConfigEngine.class);



    }


    private static void displayHelpIfNeeded(Options options, CommandLine cmd) {
        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar portable-config-maven-plugin-1.0.2-cli.jar", options);
            System.exit(0);
        }
    }



    private static Options buildOptions() {
        Options options = new Options();

        Option d = OptionBuilder.withArgName("JobFolder").hasArg().withDescription("Jenkins Job Folder").create("d");
        Option j = OptionBuilder.withArgName("toReplacedJobs").hasArg().withDescription("the jobs array").create("j");
        Option b = OptionBuilder.withArgName("branch").hasArg().withDescription("the branch").create("b");

        Option h = OptionBuilder.withDescription("display help").create("h");

        options.addOption(d);
        options.addOption(j);
        options.addOption(b);
        options.addOption(h);

        return options;
    }

}
