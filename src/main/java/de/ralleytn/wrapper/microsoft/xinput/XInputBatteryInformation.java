package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputBatteryInformation extends Structure {

	public byte BatteryType;
	public byte BatteryLevel;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("BatteryType", "BatteryLevel");
	}
}
