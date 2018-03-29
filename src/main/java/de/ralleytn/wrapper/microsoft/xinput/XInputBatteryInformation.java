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
public final class XinputBatteryInformation extends Structure {

	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte BatteryType;
	
	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte BatteryLevel;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("BatteryType", "BatteryLevel");
	}
}
