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

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * <p>specifies motor speed levels for the vibration function of a controller.</p>
 * <h2>Remarks</h2>
 * <p>The left motor is the low-frequency rumble motor. The right motor is the high-frequency rumble motor.
 * The two motors are not the same, and they create different vibration effects.</p>
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_vibration(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputSetState(int, XInputVibration)
 * @see XInputGamepad
 * @see XInput#XInputGetCapabilities(int, int, XInputCapabilities)
 */
public final class XInputVibration extends Structure {

	/**
	 * <p>Speed of the left motor. Valid values are in the range {@code 0} to {@code 65535}. Zero signifies no motor use; {@code 65535} signifies 100 percent motor use.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_vibration(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short wLeftMotorSpeed;
	
	/**
	 * <p>Speed of the right motor. Valid values are in the range {@code 0} to {@code 65535}. Zero signifies no motor use; {@code 65535} signifies 100 percent motor use.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_vibration(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short wRightMotorSpeed;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("wLeftMotorSpeed", "wRightMotorSpeed");
	}
}
