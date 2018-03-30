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
 * Specifies keystroke data returned by {@link XInput#XInputGetKeystroke(int, int, XInputKeystroke)}.
 * <h2>Remarks</h2>
 * <p>Future devices may return HID codes and virtual key values that are not supported on current devices, and are currently undefined.
 * Applications should ignore these unexpected values. A virtual-key code is a byte value that represents a particular physical key on the keyboard,
 * not the character or characters (possibly none) that the key can be mapped to based on keyboard state. The keyboard state at the time a virtual
 * key is pressed modifies the character reported. For example, VK_4 might represent a "4" or a "$", depending on the state of the SHIFT key.
 * A reported keyboard event includes the virtual key that caused the event, whether the key was pressed or released (or is repeating),
 * and the state of the keyboard at the time of the event. The keyboard state includes information about whether any CTRL, ALT,
 * or SHIFT keys are down. If the keyboard event represents an {@link #Unicode} character (for example, pressing the "A" key),
 * the {@link #Unicode} member will contain that character. Otherwise, {@link #Unicode} will contain the value zero.
 * The valid virtual-key (VK_xxx) codes are defined in XInput.h. In addition to codes that indicate key presses, the following codes indicate controller input.</p>
 * <table border=1>
 *     <tr><th>Value</th><th>Description</th></tr>
 *     <tr><td>{@link XInput#VK_PAD_A}}</td><td><b>A</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_B}}</td><td><b>B</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_X}}</td><td><b>X</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_Y}}</td><td><b>Y</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RSHOULDER}}</td><td>Right shoulder button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LSHOULDER}}</td><td>Left shoulder button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTRIGGER}}</td><td>Left trigger</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTRIGGER}}</td><td>Right trigger</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_DPAD_UP}}</td><td>Directional pad up</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_DPAD_DOWN}}</td><td>Directional pad down</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_DPAD_LEFT}}</td><td>Directional pad left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_DPAD_RIGHT}}</td><td>Directional pad right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_START}}</td><td><b>START</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_BACK}}</td><td><b>BACK</b> button</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_PRESS}}</td><td>Left thumbstick click</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_PRESS}}</td><td>Right thumbstick click</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_UP}}</td><td>Left thumbstick up</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_DOWN}}</td><td>Left thumbstick down</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_RIGHT}}</td><td>Left thumbstick right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_LEFT}}</td><td>Left thumbstick left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_UPLEFT}}</td><td>Left thumbstick up and left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_UPRIGHT}}</td><td>Left thumbstick up and right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_DOWNRIGHT}}</td><td>Left thumbstick down and right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_LTHUMB_DOWNLEFT}}</td><td>Left thumbstick down and left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_UP}}</td><td>Right thumbstick up</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_DOWN}}</td><td>Right thumbstick down</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_RIGHT}}</td><td>Right thumbstick right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_LEFT}}</td><td>Right thumbstick left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_UPLEFT}}</td><td>Right thumbstick up and left</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_UPRIGHT}}</td><td>Right thumbstick up and right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_DOWNRIGHT}}</td><td>Right thumbstick down and right</td></tr>
 *     <tr><td>{@link XInput#VK_PAD_RTHUMB_DOWNLEFT}}</td><td>Right thumbstick down and left</td></tr>
 * </table>
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputGetKeystroke(int, int, XInputKeystroke)
 */
public final class XInputKeystroke extends Structure {

	/**
	 * Virtual-key code of the key, button, or stick movement. See XInput.h for a list of valid virtual-key (VK_xxx) codes. Also, see Remarks.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short VirtualKey;
	
	/**
	 * This member is unused and the value is zero.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public String Unicode;
	
	/**
	 * <p>Flags that indicate the keyboard state at the time of the input event. This member can be any combination of the following flags:</p>
	 * <table border=1>
	 *     <tr><th>Value</th><th>Description</th></tr>
	 *     <tr><td>{@link XInput#XINPUT_KEYSTROKE_KEYDOWN}}</td><td>The key was pressed.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_KEYSTROKE_KEYUP}}</td><td>The key was released.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_KEYSTROKE_REPEAT}}</td><td>A repeat of a held key.</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short Flags;
	
	/**
	 * Index of the signed-in gamer associated with the device. Can be a value in the range {@code 0} – {@code 3}.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte UserIndex;
	
	/**
	 * HID code corresponding to the input. If there is no corresponding HID code, this value is zero.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_keystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte HidCode;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("VirtualKey", "Unicode", "Flags", "UserIndex", "HidCode");
	}
}
