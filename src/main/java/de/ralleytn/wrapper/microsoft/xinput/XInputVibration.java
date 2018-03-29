package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputVibration extends Structure {

	public short wLeftMotorSpeed;
	public short wRightMotorSpeed;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("wLeftMotorSpeed", "wRightMotorSpeed");
	}
}
