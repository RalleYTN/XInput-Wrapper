/*
 * MIT License
 * 
 * Copyright (c) 2018 Ralph Niemitz
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.ralleytn.wrapper.microsoft.xinput.tests;

import de.ralleytn.wrapper.microsoft.xinput.XInput;
import de.ralleytn.wrapper.microsoft.xinput.XInputGamepad;
import de.ralleytn.wrapper.microsoft.xinput.XInputState;
import de.ralleytn.wrapper.microsoft.xinput.XInputVibration;
import static de.ralleytn.wrapper.microsoft.xinput.XInput.*;

/**
 * A minimalistic implementation of a XInput gamepad.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class Gamepad {

	private int userIndex;
	private XInput api;
	private boolean connected;
	private XInputState pollData;
	
	/**
	 * Will call {@link #poll()} to initialize the state.
	 * @param api the {@linkplain XInput} interface
	 * @param userIndex the user index of this gamepad
	 * @since 1.0.0
	 */
	public Gamepad(XInput api, int userIndex) {
		
		this.userIndex = userIndex;
		this.api = api;
		this.pollData = new XInputState();
		this.poll();
	}
	
	/**
	 * Sets the vibration.
	 * @param leftMotorSpeed left motor speed
	 * @param rightMotorSpeed right motor speed
	 * @since 1.0.0
	 */
	public void setVibration(int leftMotorSpeed, int rightMotorSpeed) {
		
		XInputVibration vibration = new XInputVibration();
		vibration.wLeftMotorSpeed = (short)leftMotorSpeed;
		vibration.wRightMotorSpeed = (short)rightMotorSpeed;
		int code = this.api.XInputSetState(this.userIndex, vibration);
		this.connected = (code == ERROR_SUCCESS);
	}
	
	/**
	 * Polls the gamepad.
	 * @since 1.0.0
	 */
	public void poll() {
		
		XInputState state = new XInputState();
		int code = this.api.XInputGetState(this.userIndex, state);
		this.connected = (code == ERROR_SUCCESS);
		
		if(this.connected && state.dwPacketNumber != this.pollData.dwPacketNumber) {
			
			this.pollData = state;
		}
	}
	
	/**
	 * Checks if the given button is down.
	 * @param button the button
	 * @return {@code true} if the button is down, else {@code false}
	 * @since 1.0.0
	 */
	public boolean isButtonDown(int button) {
		
		return (this.pollData.Gamepad.wButtons & button) != 0;
	}
	
	/**
	 * @return the value of LT
	 * @since 1.0.0
	 */
	public int getLeftTrigger() {
		
		return Byte.toUnsignedInt(this.pollData.Gamepad.bLeftTrigger);
	}
	
	/**
	 * @return the value of RT
	 * @since 1.0.0
	 */
	public int getRightTrigger() {
		
		return Byte.toUnsignedInt(this.pollData.Gamepad.bRightTrigger);
	}
	
	/**
	 * @return the current state of the left stick
	 * @since 1.0.0
	 */
	public AnalogStick getLeftStick() {
		
		XInputGamepad gamepad = this.pollData.Gamepad;
		return new AnalogStick(gamepad.sThumbLX, gamepad.sThumbLY);
	}
	
	/**
	 * @return the current state of the right stick
	 * @since 1.0.0
	 */
	public AnalogStick getRightStick() {
		
		XInputGamepad gamepad = this.pollData.Gamepad;
		return new AnalogStick(gamepad.sThumbRX, gamepad.sThumbRY);
	}
	
	/**
	 * @return this gamepad's user index
	 * @since 1.0.0
	 */
	public int getUserIndex() {
		
		return this.userIndex;
	}
	
	/**
	 * @return {@code true} if the device is still connected, else {@code false}
	 * @since 1.0.0
	 */
	public boolean isConnected() {
		
		return this.connected;
	}
	
	/**
	 * Represents the state of an analog stick.
	 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	public static final class AnalogStick {
		
		private final short x;
		private final short y;
		
		AnalogStick(short x, short y) {
			
			this.x = x;
			this.y = y;
		}
		
		/**
		 * @return the value for the X axis
		 * @since 1.0.0
		 */
		public short getX() {
			
			return this.x;
		}
		
		/**
		 * @return the value for the Y axis
		 * @since 1.0.0
		 */
		public short getY() {
			
			return this.y;
		}
	}
}
