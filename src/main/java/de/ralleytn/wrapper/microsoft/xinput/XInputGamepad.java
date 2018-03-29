package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputGamepad extends Structure {

	public short wButtons;
	public byte bLeftTrigger;
	public byte bRightTrigger;
	public short sThumbLX;
	public short sThumbLY;
	public short sThumbRX;
	public short sThumbRY;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("wButtons", "bLeftTrigger", "bRightTrigger", "sThumbLX", "sThumbLY", "sThumbRX", "sThumbRY");
	}
	
	public boolean isDown(int button) {
		
		return (this.wButtons & button) != 0;
	}
}
