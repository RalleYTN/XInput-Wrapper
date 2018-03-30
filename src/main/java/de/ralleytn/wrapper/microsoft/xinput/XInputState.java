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
 * Represents the state of a controller.
 * <h2>Remarks</h2>
 * <p>The {@link #dwPacketNumber} member is incremented only if the status of the controller has changed since the controller was last polled.</p>
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputGetState(int, XInputState)
 * @see XInputGamepad
 */
public final class XInputState extends Structure {

	/**
	 * State packet number. The packet number indicates whether there have been any changes in the state of the controller.
	 * If the {@link #dwPacketNumber} member is the same in sequentially returned {@linkplain XInputState} structures,
	 * the controller state has not changed.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public int dwPacketNumber;
	
	/**
	 * {@linkplain XInputGamepad} structure containing the current state of an Xbox 360 Controller.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public XInputGamepad Gamepad;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("dwPacketNumber", "Gamepad");
	}
}
