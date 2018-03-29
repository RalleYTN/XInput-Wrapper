package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class XInputState extends Structure {

	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public int dwPacketNumber;
	
	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public XInputGamepad Gamepad;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("dwPacketNumber", "Gamepad");
	}
}
