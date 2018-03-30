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
 * Contains information on battery type and charge state.
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_battery_information(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputSetState(int, XInputVibration)
 * @see XInputGamepad
 * @see XInput#XInputGetCapabilities(int, int, XInputCapabilities)
 */
public final class XInputBatteryInformation extends Structure {

	/**
	 * <p>The type of battery. {@link XInputBatteryInformation#BatteryType} will be one of the following values.</p>
	 * <table border=1>
	 *     <tr><th>Value</th><th>Description</th></tr>
	 *     <tr><td>{@link XInput#BATTERY_TYPE_DISCONNECTED}}</td><td>The device is not connected.</td></tr>
	 *     <tr><td>{@link XInput#BATTERY_TYPE_WIRED}}</td><td>The device is a wired device and does not have a battery.</td></tr>
	 *     <tr><td>{@link XInput#BATTERY_TYPE_ALKALINE}}</td><td>The device has an alkaline battery.</td></tr>
	 *     <tr><td>{@link XInput#BATTERY_TYPE_NIMH}}</td><td>The device has a nickel metal hydride battery.</td></tr>
	 *     <tr><td>{@link XInput#BATTERY_TYPE_UNKNOWN}}</td><td>The device has an unknown battery type.</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_battery_information(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte BatteryType;
	
	/**
	 * <p>The charge state of the battery. This value is only valid for wireless devices with a known battery type. BatteryLevel will be one of the following values.</p>
	 * <ul>
	 *     <li>{@link XInput#BATTERY_LEVEL_EMPTY}</li>
	 *     <li>{@link XInput#BATTERY_LEVEL_LOW}</li>
	 *     <li>{@link XInput#BATTERY_LEVEL_MEDIUM}</li>
	 *     <li>{@link XInput#BATTERY_LEVEL_FULL}</li>
	 * </ul>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_battery_information(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte BatteryLevel;

	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("BatteryType", "BatteryLevel");
	}
}
