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
import java.util.Arrays;

import com.sun.jna.ptr.LongByReference;

/**
 * Contains informations about the loaded DLL and the available functions.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.0
 * @since 1.1.0
 */
public final class Info {
	
	private Method[] availableMethods;
	private String loadedDLL;
	
	Info() {}
	
	protected final void setLoadedDLL(String loadedDLL) {
		
		this.loadedDLL = loadedDLL;
		this.availableMethods = this.createAvailableMethodsArray();
	}
	
	private final Method[] createAvailableMethodsArray() {
		
		try {
			
			switch(this.loadedDLL) {
			
				case "xinput1_4.dll": return this.createAvailableMethodsFor14();
				case "xinput1_3.dll": return this.createAvailableMethodsFor13();
				case "xinput9_1_0.dll": return this.createAvailableMethodsFor910();
			}
			
		} catch(Exception exception) {
			
			// WILL NOT HAPPEN!
		}
		
		return null;
	}
	
	private final Method[] createAvailableMethodsFor14() throws NoSuchMethodException, SecurityException {
		
		return new Method[] {
			XInput.class.getDeclaredMethod("XInputEnable", boolean.class),
			XInput.class.getDeclaredMethod("XInputGetCapabilities", int.class, int.class, XInputCapabilities.class),
			XInput.class.getDeclaredMethod("XInputGetAudioDeviceIds", int.class, char[].class, LongByReference.class, char[].class, LongByReference.class),
			XInput.class.getDeclaredMethod("XInputGetBatteryInformation", int.class, int.class, XInputBatteryInformation.class),
			XInput.class.getDeclaredMethod("XInputGetState", int.class, XInputState.class),
			XInput.class.getDeclaredMethod("XInputSetState", int.class, XInputVibration.class),
			XInput.class.getDeclaredMethod("XInputGetKeystroke", int.class, int.class, XInputKeystroke.class)
		};
	}
	
	private final Method[] createAvailableMethodsFor13() throws NoSuchMethodException, SecurityException {
		
		return new Method[] {
				
			XInput.class.getDeclaredMethod("XInputEnable", boolean.class),
			XInput.class.getDeclaredMethod("XInputGetCapabilities", int.class, int.class, XInputCapabilities.class),
			XInput.class.getDeclaredMethod("XInputGetBatteryInformation", int.class, int.class, XInputBatteryInformation.class),
			XInput.class.getDeclaredMethod("XInputGetDSoundAudioDeviceGuids", int.class, char[].class, char[].class),
			XInput.class.getDeclaredMethod("XInputGetState", int.class, XInputState.class),
			XInput.class.getDeclaredMethod("XInputSetState", int.class, XInputVibration.class),
			XInput.class.getDeclaredMethod("XInputGetKeystroke", int.class, int.class, XInputKeystroke.class)
		};
	}
	
	private final Method[] createAvailableMethodsFor910() throws NoSuchMethodException, SecurityException {
		
		return new Method[] {
			XInput.class.getDeclaredMethod("XInputGetCapabilities", int.class, int.class, XInputCapabilities.class),
			XInput.class.getDeclaredMethod("XInputGetDSoundAudioDeviceGuids", int.class, char[].class, char[].class),
			XInput.class.getDeclaredMethod("XInputGetState", int.class, XInputState.class),
			XInput.class.getDeclaredMethod("XInputSetState", int.class, XInputVibration.class)
		};
	}
	
	/**
	 * Checks if the method with the given name is available.
	 * @param func the method name
	 * @return {@code true} if the method is available, else {@code false}
	 * @since 1.0.0
	 */
	public final boolean isAvailable(String func) {
		
		for(Method method : this.availableMethods) {
			
			if(method.getName().equals(func)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return an array containing all the available methods
	 * @since 1.0.0
	 */
	public final Method[] getAvailableMethods() {
		
		return Arrays.copyOf(this.availableMethods, this.availableMethods.length);
	}
	
	/**
	 * @return the name of the loaded DLL
	 * @since 1.0.0
	 */
	public final String getLoadedDLL() {
		
		return this.loadedDLL;
	}
}
