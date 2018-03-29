package de.ralleytn.wrapper.microsoft.xinput.tests;

import org.junit.jupiter.api.Test;

import de.ralleytn.wrapper.microsoft.xinput.XInput;

class XInputTest {

	private static final XInput XINPUT = XInput.create();
	private static final Gamepad GAMEPAD = new Gamepad(XINPUT, 0);
	
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
			
			while(GAMEPAD.isConnected() && (!GAMEPAD.isButtonDown(XInput.XINPUT_GAMEPAD_DPAD_RIGHT) || !GAMEPAD.isButtonDown(XInput.XINPUT_GAMEPAD_DPAD_UP))) {
				
				GAMEPAD.poll();
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testButton() {
		
		try {
			
			System.out.println("Press X");
			
			while(GAMEPAD.isConnected() && !GAMEPAD.isButtonDown(XInput.XINPUT_GAMEPAD_X)) {
				
				GAMEPAD.poll();
				Thread.sleep(10);
			}
			
		} catch(InterruptedException exception) {}
	}
	
	@Test
	public void testRumble() {
		
		try {
			
			GAMEPAD.setVibration(Short.MAX_VALUE, Short.MAX_VALUE);
			Thread.sleep(5000);
			GAMEPAD.setVibration(0, 0);
			
		} catch(InterruptedException exception) {}
	}
}
