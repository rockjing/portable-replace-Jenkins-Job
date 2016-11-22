package Umu360.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juven
 */
public class PortableConfig
{
  public List<ConfigFile> getConfigFiles()
  {
    return configFiles;
  }

  public void setConfigFiles(List<ConfigFile> configFiles)
  {
    this.configFiles = configFiles;
  }

  private List<ConfigFile> configFiles = new ArrayList<ConfigFile>();

  private boolean replaceAllStrictly = false;

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (!(o instanceof PortableConfig)) return false;

    PortableConfig that = (PortableConfig) o;

    if (!configFiles.equals(that.configFiles)) return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    return configFiles.hashCode();
  }

  public boolean getReplaceAllStrictly() {
    return this.replaceAllStrictly;
  }

  public void setReplaceAllStrictly(boolean replaceAllStrictly) {
    this.replaceAllStrictly = replaceAllStrictly;
    for (ConfigFile myFile : this.getConfigFiles()
         ) {
      myFile.setReplaceAllStrictly(replaceAllStrictly);
    }

  }

}

