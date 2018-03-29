package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputCapabilities extends Structure {
	
	public byte Type;
	public byte SubType;
	public short Flags;
	public XInputGamepad Gamepad;
	public XInputVibration Vibration;
	
	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("Type", "SubType", "Flags", "Gamepad", "Vibration");
	}
}
