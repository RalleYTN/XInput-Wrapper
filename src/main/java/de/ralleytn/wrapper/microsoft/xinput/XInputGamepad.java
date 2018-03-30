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
 * <p>Describes the current state of the Xbox 360 Controller.</p>
 * <h2>Remarks</h2>This structure is used by the {@linkplain XInputState} structure when polling for changes in the state of the controller.
 * The specific mapping of button to game function varies depending on the game type.
 * The constant {@link XInput#XINPUT_GAMEPAD_TRIGGER_THRESHOLD} may be used as the value which {@link #bLeftTrigger} and {@link #bRightTrigger}
 * must be greater than to register as pressed. This is optional, but often desirable. Xbox 360 Controller buttons do not manifest crosstalk.
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputGetState(int, XInputState)
 * @see XInputState
 */
public final class XInputGamepad extends Structure {

	/**
	 * <p>Bitmask of the device digital buttons, as follows. A set bit indicates that the corresponding button is pressed.</p>
	 * <table border=1>
	 *     <tr>
	 *         <th>Device button</th>
	 *         <th>Bitmask</th>
	 *     </tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_DPAD_UP}</td><td>0x0001</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_DPAD_DOWN}</td><td>0x0002</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_DPAD_LEFT}</td><td>0x0004</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_DPAD_RIGHT}</td><td>0x0008</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_START}</td><td>0x0010</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_BACK}</td><td>0x0020</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_LEFT_THUMB}</td><td>0x0040</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_RIGHT_THUMB}</td><td>0x0080</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_LEFT_SHOULDER}</td><td>0x0100</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_RIGHT_SHOULDER}</td><td>0x0200</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_A}</td><td>0x1000</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_B}</td><td>0x2000</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_X}</td><td>0x4000</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_GAMEPAD_Y}</td><td>0x8000</td></tr>
	 * </table>
	 * <p>Bits that are set but not defined above are reserved, and their state is undefined.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short wButtons;
	
	/**
	 * <p>The current value of the left trigger analog control. The value is between {@code 0} and {@code 255}.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte bLeftTrigger;
	
	/**
	 * <p>The current value of the right trigger analog control. The value is between {@code 0} and {@code 255}.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte bRightTrigger;
	
	/**
	 * <p>Left thumbstick x-axis value. Each of the thumbstick axis members is a signed value between {@value Short#MIN_VALUE} and {@value Short#MAX_VALUE}
	 * describing the position of the thumbstick. A value of {@code 0} is centered. Negative values signify down or to the left.
	 * Positive values signify up or to the right. The constants {@link XInput#XINPUT_GAMEPAD_LEFT_THUMB_DEADZONE}
	 * or {@link XInput#XINPUT_GAMEPAD_RIGHT_THUMB_DEADZONE} can be used as a positive and negative value to filter a thumbstick input.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short sThumbLX;
	
	/**
	 * <p>Left thumbstick y-axis value. The value is between {@value Short#MIN_VALUE} and {@value Short#MAX_VALUE}.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short sThumbLY;
	
	/**
	 * <p>Right thumbstick x-axis value. The value is between {@value Short#MIN_VALUE} and {@value Short#MAX_VALUE}.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short sThumbRX;
	
	/**
	 * <p>Right thumbstick y-axis value. The value is between {@value Short#MIN_VALUE} and {@value Short#MAX_VALUE}.</p>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_gamepad(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short sThumbRY;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("wButtons", "bLeftTrigger", "bRightTrigger", "sThumbLX", "sThumbLY", "sThumbRX", "sThumbRY");
	}
}
