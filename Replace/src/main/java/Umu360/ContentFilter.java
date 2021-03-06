package Umu360;



import Umu360.model.Replace;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author juven
 */
public interface ContentFilter
{
  boolean accept(String contentType);

  void filter(InputStream fileIS, OutputStream tmpOS, List<Replace> replaces) throws IOException;
}
