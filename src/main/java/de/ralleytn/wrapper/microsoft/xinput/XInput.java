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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.LongByReference;

/**
 * XInput Game Controller API enables applications to receive input from the Xbox 360 Controller for Windows.
 * <p><code>Source: <a href="https://msdn.microsoft.com/de-de/library/windows/desktop/hh405053(v=vs.85)">Microsoft Documentation</a></code></p>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.0
 * @since 1.0.0
 */
public interface XInput extends Library {
	
	/** @since 1.0.0 **/ public static final int ERROR_SUCCESS = 0x00;
	/** @since 1.0.0 **/ public static final int ERROR_EMPTY = 4306;
	/** @since 1.0.0 **/ public static final int ERROR_DEVICE_NOT_CONNECTED = 0x48F;
	
	/** @since 1.0.0 **/ public static final int XINPUT_KEYSTROKE_KEYDOWN = 0x0001;
	/** @since 1.0.0 **/ public static final int XINPUT_KEYSTROKE_KEYUP = 0x0002;
	/** @since 1.0.0 **/ public static final int XINPUT_KEYSTROKE_REPEAT = 0x0004;
	
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_UNKNOWN = 0x00;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_GAMEPAD = 0x01;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_WHEEL = 0x02;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_ARCADE_STICK = 0x03;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_FLIGHT_STICK = 0x04;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_DANCE_PAD = 0x05;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_GUITAR = 0x06;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_GUITAR_ALTERNATE = 0x07;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_DRUM_KIT = 0x08;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_GUITAR_BASS = 0x0B;
    /** @since 1.0.0 **/ public static final int XINPUT_DEVSUBTYPE_ARCADE_PAD = 0x13;
    
    /** @since 1.0.0 **/ public static final int VK_PAD_A = 0x5800;
    /** @since 1.0.0 **/ public static final int VK_PAD_B = 0x5801;
    /** @since 1.0.0 **/ public static final int VK_PAD_X = 0x5802;
    /** @since 1.0.0 **/ public static final int VK_PAD_Y = 0x5803;
    /** @since 1.0.0 **/ public static final int VK_PAD_RSHOULDER = 0x5804;
    /** @since 1.0.0 **/ public static final int VK_PAD_LSHOULDER = 0x5805;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTRIGGER = 0x5806;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTRIGGER = 0x5807;
    /** @since 1.0.0 **/ public static final int VK_PAD_DPAD_UP = 0x5810;
    /** @since 1.0.0 **/ public static final int VK_PAD_DPAD_DOWN = 0x5811;
    /** @since 1.0.0 **/ public static final int VK_PAD_DPAD_LEFT = 0x5812;
    /** @since 1.0.0 **/ public static final int VK_PAD_DPAD_RIGHT = 0x5813;
    /** @since 1.0.0 **/ public static final int VK_PAD_START = 0x5814;
    /** @since 1.0.0 **/ public static final int VK_PAD_BACK = 0x5815;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_PRESS = 0x5816;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_PRESS = 0x5817;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_UP = 0x5820;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_DOWN = 0x5821;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_RIGHT = 0x5822;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_LEFT = 0x5823;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_UPLEFT = 0x5824;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_UPRIGHT = 0x5825;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_DOWNRIGHT = 0x5826;
    /** @since 1.0.0 **/ public static final int VK_PAD_LTHUMB_DOWNLEFT = 0x5827;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_UP = 0x5830;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_DOWN = 0x5831;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_RIGHT = 0x5832;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_LEFT = 0x5833;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_UPLEFT = 0x5834;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_UPRIGHT = 0x5835;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_DOWNRIGHT = 0x5836;
    /** @since 1.0.0 **/ public static final int VK_PAD_RTHUMB_DOWNLEFT = 0x5837;

	/** @since 1.0.0 **/ public static final int XINPUT_DEVTYPE_GAMEPAD = 1;
	
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_DPAD_UP = 0x0001;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_DPAD_DOWN = 0x0002;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_DPAD_LEFT = 0x0004;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_DPAD_RIGHT = 0x0008;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_START = 0x0010;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_BACK = 0x0020;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_LEFT_THUMB = 0x0040;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_LEFT_THUMB_DEADZONE = 7849;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_RIGHT_THUMB = 0x0080;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_RIGHT_THUMB_DEADZONE = 8689;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_LEFT_SHOULDER = 0x0100;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_RIGHT_SHOULDER = 0x0200;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_A = 0x1000;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_B = 0x2000;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_X = 0x4000;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_Y = 0x8000;
	/** @since 1.0.0 **/ public static final int XINPUT_GAMEPAD_TRIGGER_THRESHOLD = 30;
	
	/** @since 1.0.0 **/ public static final int BATTERY_TYPE_DISCONNECTED = 0x00;
	/** @since 1.0.0 **/ public static final int BATTERY_TYPE_WIRED = 0x01;
	/** @since 1.0.0 **/ public static final int BATTERY_TYPE_ALKALINE = 0x02;
	/** @since 1.0.0 **/ public static final int BATTERY_TYPE_NIMH = 0x03;
	/** @since 1.0.0 **/ public static final int BATTERY_TYPE_UNKNOWN = 0xFF;
	
	/** @since 1.0.0 **/ public static final int BATTERY_DEVTYPE_GAMEPAD = 0x00;
	/** @since 1.0.0 **/ public static final int BATTERY_DEVTYPE_HEADSET = 0x01;
	
	/** @since 1.0.0 **/ public static final int BATTERY_LEVEL_EMPTY = 0x00;
	/** @since 1.0.0 **/ public static final int BATTERY_LEVEL_LOW = 0x01;
	/** @since 1.0.0 **/ public static final int BATTERY_LEVEL_MEDIUM = 0x02;
	/** @since 1.0.0 **/ public static final int BATTERY_LEVEL_FULL = 0x03;
	
	/** @since 1.0.0 **/ public static final int XINPUT_CAPS_FFB_SUPPORTED = 0x0001;
    /** @since 1.0.0 **/ public static final int XINPUT_CAPS_WIRELESS = 0x0002;
    /** @since 1.0.0 **/ public static final int XINPUT_CAPS_VOICE_SUPPORTED = 0x0004;
    /** @since 1.0.0 **/ public static final int XINPUT_CAPS_PMD_SUPPORTED = 0x0008;
    /** @since 1.0.0 **/ public static final int XINPUT_CAPS_NO_NAVIGATION = 0x0010;
	
	/** @since 1.0.0 **/ public static final int XINPUT_FLAG_GAMEPAD = 0x00000001;
	
	/** @since 1.0.0 **/ public static final int XUSER_INDEX_ANY = 255;
	/** @since 1.0.0 **/ public static final int XUSER_MAX_COUNT = 4;
	
	/**
	 * Contains informations about the loaded DLL and the available functions.
	 * All values in it will be {@code null} if the {@link #create()} method wasn't called yet.
	 * @since 1.1.0
	 */
	public static final Info INFO = new Info();
	
	/**
	 * Creates a new instance of {@linkplain XInput}.
	 * It is recommended to call this method only once and save the result in a public constant.
	 * The instance will be destroyed on garbage collection.
	 * @return the created instance or {@code null} if the XInput API is not supported 
	 * @since 1.0.0
	 */
	public static XInput create() {

		// Check if this is Windows
		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			
			// Define all DLLs in fallback order
			final String[] dlls = {
				"xinput1_4.dll",
				"xinput1_3.dll",
				"xinput9_1_0.dll"
			};
			
			// Get Windows directory
			String directory = System.getProperty("os.arch.dir");
			
			if(directory == null) {
				
				directory = "c:\\windows";
			}
			
			// Get path
			String vmType = System.getProperty("sun.arch.data.model");
			Path path = Paths.get(directory, vmType.equals("64") ? "SysWOW64" : "System32");

			// Load Library
			for(String dll : dlls) {
				
				if(Files.exists(path.resolve(dll))) {
					
					System.setProperty("jna.library.path", path.resolve(dll).toString());
					INFO.setLoadedDLL(dll);
					return (XInput)Native.loadLibrary(dll, XInput.class);
				}
			}
		}
		
		return null;
	}

	/**
	 * Sets the reporting state of XInput.
	 * <h2>Remarks</h2>
	 * <p>This function is meant to be called when an application gains or loses focus
	 * (such as via <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ms632614(v=vs.85).aspx">WM_ACTIVATEAPP</a>).
	 * Using this function, you will not have to change the XInput query loop in your application as neutral data will always be reported if
	 * XInput is disabled. In a controller that supports vibration effects:</p>
	 * <ul>
	 *     <li>Passing {@code false} will stop any vibration effects currently playing. In this state, calls to {@link #XInputSetState(int, XInputVibration)} will be registered, but not passed to the device.</li>
	 *     <li>Passing {@code true} will pass the last vibration request (even if it is {@code 0}) sent to {@link #XInputSetState(int, XInputVibration)} to the device.</li>
	 * </ul>
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputenable(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param enable <code><i>[in]</i></code>If enable is {@code false}, XInput will only send neutral data in response to
	 *               {@link #XInputGetState(int, XInputState)} (all buttons up, axes centered, and triggers at {@code 0}).
	 *               {@link #XInputSetState(int, XInputVibration)} calls will be registered but not sent to the device. Sending any value other
	 *               than {@code false} will restore reading and writing functionality to normal.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputGetState(int, XInputState)
	 * @see #XInputSetState(int, XInputVibration)
	 * @see XInputState
	 * @see XInputGamepad
	 */
	public void XInputEnable(boolean enable);
	
	/**
	 * <p>Retrieves the capabilities and features of a connected controller.</p>
	 * <h2>Remarks</h2>
	 * <p>The legacy XINPUT 9.1.0 version (included in Windows Vista and later) always returned a fixed set of capabilities regardless of attached device.</p>
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3), Windows Vista (XInput 9.1.0)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib;<br>Xinput9_1_0.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll;<br>Xinput9_1_0.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetcapabilities(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param dwFlags <code><i>[in]</i></code> Input flags that identify the controller type. If this value is {@code 0}, then the capabilities of all
	 *                controllers connected to the system are returned. Currently, only one value is supported:
	 *                <p><table border=1>
	 *                    <tr><th>Value</th><th>Description</th></tr>
	 *                    <tr><td>{@link #XINPUT_FLAG_GAMEPAD}</td><td>Limit query to devices of Xbox 360 Controller type.</td></tr>
	 *                </table></p>
	 *                Any value of {@code dwFlags} other than the above or {@code 0} is illegal and will result in an error break when debugging.
	 * @param pCapabilities <code><i>[out]</i></code> Pointer to an {@linkplain XInputCapabilities} structure that
	 *                      receives the controller capabilities.
	 * @return If the function succeeds, the return value is {@link XInput#ERROR_SUCCESS}.<br>
	 *         If the controller is not connected, the return value is {@link XInput#ERROR_DEVICE_NOT_CONNECTED}.<br>
	 *         If the function fails, the return value is an error code defined in WinError.h.<br>
	 *         The function does not use {@code SetLastError} to set the calling thread's last-error code.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputGetState(int, XInputState)
	 * @see #XInputSetState(int, XInputVibration)
	 */
	public int XInputGetCapabilities(int dwUserIndex, int dwFlags, XInputCapabilities pCapabilities);
	
	/**
	 * Retrieves the sound rendering and sound capture audio device IDs that are associated with the headset connected to the specified controller.
	 * <h2>Remarks</h2>
	 * <p>Callers must allocate the memory for the buffers passed to {@link #XInputGetAudioDeviceIds(int, char[], LongByReference, char[], LongByReference)}.
	 * The resulting strings can be of arbitrary length.</p>
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetaudiodeviceids(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the gamer associated with the device.
	 * @param pRenderDeviceId <code><i>[out, optional]</i></code> Windows Core Audio device ID string for render (speakers).
	 * @param pRenderCount <code><i>[in, out, optional]</i></code> Size, in wide-chars, of the render device ID string buffer.
	 * @param pCaptureDeviceId <code><i>[out, optional]</i></code> Windows Core Audio device ID string for capture (microphone).
	 * @param pCaptureCount <code><i>[in, out, optional]</i></code> Size, in wide-chars, of capture device ID string buffer.
	 * @return If the function successfully retrieves the device IDs for render and capture, the return code is {@link #ERROR_SUCCESS}.
	 *         If there is no headset connected to the controller, the function will also retrieve {@link #ERROR_SUCCESS} with {@code null}
	 *         as the values for {@code pRenderDeviceId} and {@code pCaptureDeviceId}.
	 *         If the controller port device is not physically connected, the function will return {@link #ERROR_DEVICE_NOT_CONNECTED}.
	 *         If the function fails, it will return a valid Win32 error code.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/dd370802(v=vs.85).aspx">Core Audio APIs</a>
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputGetDSoundAudioDeviceGuids(int, char[], char[])
	 */
	public int XInputGetAudioDeviceIds(int dwUserIndex, char[] pRenderDeviceId, LongByReference pRenderCount, char[] pCaptureDeviceId, LongByReference pCaptureCount);
	
	/**
	 * Retrieves the battery type and charge status of a wireless controller.
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetbatteryinformation(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param devType <code><i>[in]</i></code> Specifies which device associated with this user index should be queried. Must be {@link #BATTERY_DEVTYPE_GAMEPAD} or {@link #BATTERY_DEVTYPE_HEADSET}.
	 * @param pBatteryInformation <code><i>[out]</i></code> Pointer to an {@linkplain XInputBatteryInformation} structure that receives the battery information.
	 * @return If the function succeeds, the return value is {@link #ERROR_SUCCESS}.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 */
	public int XInputGetBatteryInformation(int dwUserIndex, int devType, XInputBatteryInformation pBatteryInformation);
	
	/**
	 * Gets the sound rendering and sound capture device GUIDs that are associated with the headset connected to the specified controller.
	 * <h2>Remarks</h2>
	 * <p>Use of legacy <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee416960(v=vs.85).aspx">DirectSound</a> is not recommended, and DirectSound is not available for Windows Store apps.</p>
	 * <h2>Platform Requirements</h2><p>DirectX SDK (XInput 1.3), Windows Vista (XInput 9.1.0)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib;<br>Xinput9_1_0.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput9_1_0.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetdsoundaudiodeviceguids(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pDSoundRenderGuid <code><i>[out]</i></code> Pointer that receives the GUID of the headset sound rendering device.
	 * @param pdSoundCaptureGuid <code><i>[out]</i></code> Pointer that receives the GUID of the headset sound capture device.
	 * @return If the function successfully retrieves the device IDs for render and capture, the return code is {@link #ERROR_SUCCESS}.
	 *         If there is no headset connected to the controller, the function also retrieves {@link #ERROR_SUCCESS} with {@code GUID_NULL} as the values for
	 *         {@code pDSoundRenderGuid} and {@code pDSoundCaptureGuid}.
	 *         If the controller port device is not physically connected, the function returns {@link #ERROR_DEVICE_NOT_CONNECTED}.
	 *         If the function fails, it returns a valid Win32 error code.
	 * @since 1.0.0
	 * @deprecated {@link #XInputGetDSoundAudioDeviceGuids(int, char[], char[])} is deprecated because it isn't supported by Windows 8 (XInput 1.4).
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputGetState(int, XInputState)
	 */
	@Deprecated
	public int XInputGetDSoundAudioDeviceGuids(int dwUserIndex, char[] pDSoundRenderGuid, char[] pdSoundCaptureGuid);
	
	/**
	 * Retrieves the current state of the specified controller.
	 * <h2>Remarks</h2>
	 * When {@link #XInputGetState(int, XInputState)} is used to retrieve controller data, the left and right triggers are each reported separately.
	 * For legacy reasons, when DirectInput retrieves controller data, the two triggers share the same axis.
	 * The legacy behavior is noticeable in the current Game Device Control Panel, which uses DirectInput for controller state.
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3), Windows Vista (XInput 9.1.0)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib;<br>Xinput9_1_0.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll;<br>Xinput9_1_0.dll;<br>Xinputuap.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetstate(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pState <code><i>[out]</i></code> Pointer to an {@linkplain XInputState} structure that receives the current state of the controller.
	 * @return If the function succeeds, the return value is {@link XInput#ERROR_SUCCESS}.<br>
	 *         If the controller is not connected, the return value is {@link XInput#ERROR_DEVICE_NOT_CONNECTED}.<br>
	 *         If the function fails, the return value is an error code defined in WinError.h.<br>
	 *         The function does not use {@code SetLastError} to set the calling thread's last-error code.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputSetState(int, XInputVibration)
	 * @see XInputState
	 * @see XInputGamepad
	 */
	public int XInputGetState(int dwUserIndex, XInputState pState);
	
	/**
	 * <p>Sends data to a connected controller. This function is used to activate the vibration function of a controller.</p>
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3), Windows Vista (XInput 9.1.0)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib;<br>Xinput9_1_0.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll;<br>Xinput9_1_0.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputsetstate(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pVibration <code><i>[in, out]</i></code> Pointer to an {@linkplain XInputVibration} structure containing the vibration information to send to the controller.
	 * @return If the function succeeds, the return value is {@link XInput#ERROR_SUCCESS}.<br>
	 *         If the controller is not connected, the return value is {@link XInput#ERROR_DEVICE_NOT_CONNECTED}.<br>
	 *         If the function fails, the return value is an error code defined in WinError.h.<br>
	 *         The function does not use {@code SetLastError} to set the calling thread's last-error code.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see #XInputGetState(int, XInputState)
	 * @see XInputVibration
	 */
	public int XInputSetState(int dwUserIndex, XInputVibration pVibration);
	
	/**
	 * Retrieves a gamepad input event.
	 * <h2>Remarks</h2>
	 * <p>Wireless controllers are not considered active upon system startup, and calls to any of the XInput functions before a wireless controller
	 * is made active return {@link #ERROR_DEVICE_NOT_CONNECTED}. Game titles must examine the return code and be prepared to handle this condition.
	 * Wired controllers are automatically activated when they are inserted. Wireless controllers are activated when the user
	 * presses the START or Xbox Guide button to power on the controller.</p>
	 * <h2>Platform Requirements</h2><p>Windows 8 (XInput 1.4), DirectX SDK (XInput 1.3)</p>
	 * <h2>Requirements</h2>
	 * <table border=1>
	 *     <tr><th>Header</th><td>XInput.h</td></tr>
	 *     <tr><th>Library</th><td>Xinput.lib</td></tr>
	 *     <tr><th>DLL</th><td>Xinput1_4.dll</td></tr>
	 * </table>
	 * <p><code>Source: <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/microsoft.directx_sdk.reference.xinputgetkeystroke(v=vs.85).aspx">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param dwReserved <code><i>[in]</i></code> Reserved
	 * @param pKeystroke <code><i>[out]</i></code> Pointer to an {@linkplain XInputKeystroke} structure that receives an input event.
	 * @return If the function succeeds, the return value is {@link XInput#ERROR_SUCCESS}.<br>
	 *         If the controller is not connected, the return value is {@link XInput#ERROR_DEVICE_NOT_CONNECTED}.<br>
	 *         If the function fails, the return value is an error code defined in WinError.h.<br>
	 *         The function does not use {@code SetLastError} to set the calling thread's last-error code.
	 * @since 1.0.0
	 * @see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417007(v=vs.85).aspx">XInput Functions</a>
	 * @see XInputKeystroke
	 */
	public int XInputGetKeystroke(int dwUserIndex, int dwReserved, XInputKeystroke pKeystroke);
}
