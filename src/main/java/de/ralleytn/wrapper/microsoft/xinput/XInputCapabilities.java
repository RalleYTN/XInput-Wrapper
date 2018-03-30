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
 * <p>Describes the capabilities of a connected controller. The {@link XInput#XInputGetCapabilities(int, int, XInputCapabilities)}
 * function returns {@linkplain XInputCapabilities}.</p>
 * <h2>Remarks</h2>
 * <p> {@link XInput#XInputGetCapabilities(int, int, XInputCapabilities)} returns {@linkplain XInputCapabilities} to indicate the characteristics
 * and available functionality of a specified controller. {@link XInput#XInputGetCapabilities(int, int, XInputCapabilities)} sets the structure
 * members to indicate which inputs the device supports. For binary state controls, such as digital buttons, the corresponding bit reflects whether
 * or not the control is supported by the device. For proportional controls, such as thumbsticks, the value indicates the resolution for that
 * control. Some number of the least significant bits may not be set, indicating that the control does not provide resolution to that level.
 * The {@code SubType} member indicates the specific subtype of controller present. Games may detect the controller subtype and tune their handling
 * of controller input or output based on subtypes that are well suited to their game genre. For example, a car racing game might check for the
 * presence of a wheel controller to provide finer control of the car being driven. However, titles must not disable or ignore a device based on
 * its subtype. Subtypes not recognized by the game or for which the game is not specifically tuned should be treated as a standard
 * Xbox 360 Controller ({@link XInput#XINPUT_DEVSUBTYPE_GAMEPAD}). Older XUSB Windows drivers report incomplete capabilities information,
 * particularly for wireless devices. The latest XUSB Windows driver provides full support for wired and wireless devices, and more complete and
 * accurate capabilties flags.</p>
 * <h2>Requirements</h2>
 * <table border=1>
 *     <tr><th>Header</th><td>XInput.h</td></tr>
 * </table>
 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417009(v=vs.85).aspx">XInput Structures</a>
 * @see XInput#XInputGetCapabilities(int, int, XInputCapabilities)
 * @see XInputGamepad
 * @see XInputVibration
 */
public final class XInputCapabilities extends Structure {
	
	/**
	 * <p>Controller type. It must be one of the following values.</p>
	 * <table border=1>
	 *     <tr><th>Value</th><th>Description</th></tr>
	 *     <tr><td>{@link XInput#XINPUT_DEVTYPE_GAMEPAD}}</td><td>The device is a game controller.</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte Type;
	
	/**
	 * <p>Subtype of the game controller.
	 * See <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/hh405050(v=vs.85).aspx">XINPUT and Controller Subtypes</a>
	 * for a list of allowed subtypes.</p>
	 * <i><b>Note: </b>For restrictions on the use of this subtype value, see Remarks. More subtypes may be added in the future.</i>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public byte SubType;
	
	/**
	 * <p>Features of the controller.</p>
	 * <table border=1>
	 *     <tr><th>Value</th><th>Description</th></tr>
	 *     <tr><td>{@link XInput#XINPUT_CAPS_VOICE_SUPPORTED}}</td><td>Device has an integrated voice device.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_CAPS_FFB_SUPPORTED}}</td><td>Device supports force feedback functionality. Note that these force-feedback features beyond rumble are not currently supported through XINPUT on Windows.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_CAPS_WIRELESS}}</td><td>Device is wireless.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_CAPS_PMD_SUPPORTED}}</td><td>Device supports plug-in modules. Note that plug-in modules like the text input device (TID) are not supported currently through XINPUT on Windows.</td></tr>
	 *     <tr><td>{@link XInput#XINPUT_CAPS_NO_NAVIGATION}}</td><td>Device lacks menu navigation buttons (START, BACK, DPAD).</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public short Flags;
	
	/**
	 * {@linkplain XInputGamepad} structure that describes available controller features and control resolutions. 
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public XInputGamepad Gamepad;
	
	/**
	 * {@linkplain XInputVibration} structure that describes available vibration functionality and resolutions.
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinput_capabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @since 1.0.0
	 */
	public XInputVibration Vibration;
	
	@Override
	protected List<String> getFieldOrder() {
		
		return Arrays.asList("Type", "SubType", "Flags", "Gamepad", "Vibration");
	}
}
