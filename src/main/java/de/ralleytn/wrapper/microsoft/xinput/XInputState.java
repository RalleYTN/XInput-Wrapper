package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputState extends Structure {

	public int dwPacketNumber;
	public XInputGamepad Gamepad;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("dwPacketNumber", "Gamepad");
	}
}
