package org.w3.activity.streams;

import java.net.URI;

public interface IPage {
   public URI getPartOf();

   public void setPartOf(URI partOf);
}