package de.ralleytn.wrapper.microsoft.xinput;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public final class XInputKeystroke extends Structure {

	public short VirtualKey;
	public String Unicode;
	public short Flags;
	public byte UserIndex;
	public byte HidCode;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("VirtualKey", "Unicode", "Flags", "UserIndex", "HidCode");
	}
}
