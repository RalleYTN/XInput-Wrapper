package de.ralleytn.wrapper.microsoft.xinput;

import java.io.IOException;

/**
 * If the XInput library was not found on system
 * 
 * @author andrea.fantappie@gmail.com
 *
 */
public class XInputLibraryNotFound extends IOException {

	private static final long serialVersionUID = 1L;

	public XInputLibraryNotFound(String message) {
		super(message);
	}

}
