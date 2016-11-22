package Umu360;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.*;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;

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



        String fileName = cmd.getOptionValue("d");
        if(fileName == null || fileName.length() == 0)
            throw new MissingArgumentException("can't find Jenkins Job Folder, please check param d! ");


        File targetFolder = new File(fileName);


        if(!targetFolder.isDirectory()) {

            throw new MissingArgumentException("can't find Jenkins Job Folder" + fileName);
        }


        PlexusContainer container = new DefaultPlexusContainer();



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
            formatter.printHelp("java -jar  xxx.jar -d [JobFolder] -j [part name of ] -b [branchName]", options);
            System.exit(0);
        }
    }



    private static Options buildOptions() {
        Options options = new Options();

        Option d = OptionBuilder.withArgName("JobFolder").hasArg().withDescription("Jenkins Job Folder").create("d");
        Option j = OptionBuilder.withArgName("toReplacedJobs").hasArg().withDescription("The part of Job Name").create("j");
        Option b = OptionBuilder.withArgName("branch").hasArg().withDescription("the branch").create("b");

        Option h = OptionBuilder.withDescription("display help").create("h");

        options.addOption(d);
        options.addOption(j);
        options.addOption(b);
        options.addOption(h);

        return options;
    }

}
