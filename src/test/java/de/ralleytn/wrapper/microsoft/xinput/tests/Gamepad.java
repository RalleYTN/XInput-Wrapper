package de.ralleytn.wrapper.microsoft.xinput.tests;

import de.ralleytn.wrapper.microsoft.xinput.XInput;
import de.ralleytn.wrapper.microsoft.xinput.XInputGamepad;
import de.ralleytn.wrapper.microsoft.xinput.XInputState;
import de.ralleytn.wrapper.microsoft.xinput.XInputVibration;

public class Gamepad {

	private int userIndex;
	private XInput api;
	private boolean connected;
	private XInputState pollData;
	
	public Gamepad(XInput api, int userIndex) {
		
		this.userIndex = userIndex;
		this.api = api;
		this.pollData = new XInputState();
		this.poll();
	}
	
	public void setVibration(int leftMotorSpeed, int rightMotorSpeed) {
		
		XInputVibration vibration = new XInputVibration();
		vibration.wLeftMotorSpeed = (short)leftMotorSpeed;
		vibration.wRightMotorSpeed = (short)rightMotorSpeed;
		int code = this.api.XInputSetState(this.userIndex, vibration);
		this.connected = (code == XInput.ERROR_SUCCESS);
	}
	
	public void poll() {
		
		XInputState state = new XInputState();
		int code = this.api.XInputGetState(this.userIndex, state);
		this.connected = (code == XInput.ERROR_SUCCESS);
		
		if(this.connected && state.dwPacketNumber != this.pollData.dwPacketNumber) {
			
			this.pollData = state;
		}
	}
	
	public boolean isButtonDown(int button) {
		
		return (this.pollData.Gamepad.wButtons & button) != 0;
	}
	
	public int getLeftTrigger() {
		
		return Byte.toUnsignedInt(this.pollData.Gamepad.bLeftTrigger);
	}
	
	public int getRightTrigger() {
		
		return Byte.toUnsignedInt(this.pollData.Gamepad.bRightTrigger);
	}
	
	public AnalogStick getLeftStick() {
		
		XInputGamepad gamepad = this.pollData.Gamepad;
		return new AnalogStick(gamepad.sThumbLX, gamepad.sThumbLY);
	}
	
	public AnalogStick getRightStick() {
		
		XInputGamepad gamepad = this.pollData.Gamepad;
		return new AnalogStick(gamepad.sThumbRX, gamepad.sThumbRY);
	}
	
	public int getUserIndex() {
		
		return this.userIndex;
	}
	
	public boolean isConnected() {
		
		return this.connected;
	}
	
	public static final class AnalogStick {
		
		private final short x;
		private final short y;
		
		AnalogStick(short x, short y) {
			
			this.x = x;
			this.y = y;
		}
		
		public short getX() {
			
			return this.x;
		}
		
		public short getY() {
			
			return this.y;
		}
	}
}
