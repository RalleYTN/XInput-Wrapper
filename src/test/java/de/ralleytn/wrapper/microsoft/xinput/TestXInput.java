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
package de.ralleytn.wrapper.microsoft.xinput;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static de.ralleytn.wrapper.microsoft.xinput.XInput.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * The test assumes that a single wired XInput gamepad is connected to a XInput 1.4 environment.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.0
 * @since 1.0.0
 */
class XInputTest {

	private static final XInput XINPUT = XInput.create();
	private static final Gamepad GAMEPAD = new Gamepad(XINPUT, 0);
	
	@Test
	public void testInfo() {
		
		System.out.println("Loaded: " + INFO.getLoadedDLL());
		
		for(Method method : INFO.getAvailableMethods()) {
			
			System.out.println(method);
		}
		
		System.out.println();
	}
	
	@Test
	public void testGetCapabilities() {
		
		XInputCapabilities capabilities = new XInputCapabilities();
		int code = XINPUT.XInputGetCapabilities(GAMEPAD.getUserIndex(), XINPUT_FLAG_GAMEPAD, capabilities);
		
		if(code == ERROR_SUCCESS) {
			
			XInputVibration vibration = capabilities.Vibration;
			XInputGamepad gamepad = capabilities.Gamepad;
			
			System.out.println("\n====");
			System.out.println("Left Motor: " + Short.toUnsignedInt(vibration.wLeftMotorSpeed));
			System.out.println("Right Motor: " + Short.toUnsignedInt(vibration.wRightMotorSpeed));
			System.out.println("Type: " + capabilities.Type);
			System.out.println("Subtype: " + capabilities.SubType);
			System.out.println("Flags: " + Integer.toBinaryString(capabilities.Flags));
			System.out.println("Buttons: " + Integer.toBinaryString(gamepad.wButtons));
			System.out.println("====\n");
			
		} else {
			
			fail();
		}
	}
	
	@Test
	public void testGetKeyStroke() {
		
		// Microsoft did not finish this functionality.
		// Currently the only usable members are UserIndex and VirtualKey.
		
		try {

			System.out.println("Press A");
			
			while(GAMEPAD.isConnected()) {
				
				XInputKeystroke stroke = new XInputKeystroke();
				XINPUT.XInputGetKeystroke(GAMEPAD.getUserIndex(), 0, stroke);

				if(stroke.VirtualKey == VK_PAD_A) {
					
					System.out.println("\n====");
					System.out.println("User Index: " + stroke.UserIndex);
					System.out.println("Flags: " + Integer.toBinaryString(stroke.Flags));
					System.out.println("Unicode: " + stroke.Unicode);
					System.out.println("HID Code: " + stroke.HidCode);
					System.out.println("====\n");
					break;
				}
					
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testGetBatteryInformation() {
		
		XInputBatteryInformation info = new XInputBatteryInformation();
		int code = XINPUT.XInputGetBatteryInformation(GAMEPAD.getUserIndex(), BATTERY_DEVTYPE_GAMEPAD, info);
		
		if(code == ERROR_SUCCESS) {
			
			assertEquals(BATTERY_TYPE_WIRED, info.BatteryType);
			assertEquals(BATTERY_LEVEL_FULL, info.BatteryLevel);
			
		} else {
			
			fail();
		}
	}
	
	@Test
	public void testGetAllConnectedGamepads() {
		
		List<Gamepad> gamepads = new ArrayList<>();
		
		for(int userIndex = 0; userIndex < XUSER_MAX_COUNT; userIndex++) {
			
			int code = XINPUT.XInputGetState(userIndex, new XInputState());
			
			if(code == ERROR_SUCCESS) {
				
				gamepads.add(new Gamepad(XINPUT, userIndex));
			}
		}
		
		assertEquals(1, gamepads.size());
	}
	
	@Test
	public void testAnalogStick() {
		
		try {

			Gamepad.AnalogStick left = GAMEPAD.getLeftStick();
			Gamepad.AnalogStick right = GAMEPAD.getRightStick();
			
			System.out.println("Push the left stick to the right and the right stick down");
			
			while(GAMEPAD.isConnected() && (left.getX() != Short.MAX_VALUE || right.getY() != Short.MIN_VALUE)) {
				
				GAMEPAD.poll();
				left = GAMEPAD.getLeftStick();
				right = GAMEPAD.getRightStick();
				// System.out.println("lx=" + left.getX() + ",ry=" + right.getY());
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testTriggers() {
		
		try {
			
			System.out.println("Push both triggers down");
			
			while(GAMEPAD.isConnected() && (GAMEPAD.getLeftTrigger() != 255 || GAMEPAD.getRightTrigger() != 255)) {
				
				GAMEPAD.poll();
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testPOV() {
		
		try {
			
			System.out.println("Press North East on POV");
			
			while(GAMEPAD.isConnected() && (!GAMEPAD.isButtonDown(XINPUT_GAMEPAD_DPAD_RIGHT) || !GAMEPAD.isButtonDown(XINPUT_GAMEPAD_DPAD_UP))) {
				
				GAMEPAD.poll();
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testButton() {
		
		try {
			
			System.out.println("Press X");
			
			while(GAMEPAD.isConnected() && !GAMEPAD.isButtonDown(XINPUT_GAMEPAD_X)) {
				
				GAMEPAD.poll();
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testRumble() {
		
		try {
			
			GAMEPAD.setVibration(Short.MAX_VALUE, Short.MAX_VALUE); // vibrate on 50%
			Thread.sleep(5000);
			GAMEPAD.setVibration(0, 0); // stop vibrating
			
		} catch(InterruptedException exception) {}
	}
}
