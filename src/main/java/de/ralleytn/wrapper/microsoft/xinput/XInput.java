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
 * @version 1.0.0
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
	 * Creates a new instance of {@linkplain XInput}.
	 * It is recommended to call this method only once and save the result in a public constant.
	 * The instance will be destroyed on garbage collection.
	 * @return the created instance or {@code null} if the XInput API is not supported 
	 * @since 1.0.0
	 */
	public static XInput create() {

		if(System.getProperty("os.name").toLowerCase().startsWith("win")) {
			
			// Define all DLLs in fallback order
			final String[] dlls = {
				"xinput1_4.dll",
				"xinput1_3.dll",
				"xinput9_1_0.dll"
			};
			
			// Get windows directory
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
					return (XInput)Native.loadLibrary(dll, XInput.class);
				}
			}
		}
		
		return null;
	}

	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param enable
	 * @since 1.0.0
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
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pRenderDeviceId
	 * @param pRenderCount
	 * @param pCaptureDeviceId
	 * @param pCaptureCount
	 * @return
	 * @since 1.0.0
	 */
	public int XInputGetAudioDeviceIds(int dwUserIndex, char[] pRenderDeviceId, LongByReference pRenderCount, char[] pCaptureDeviceId, LongByReference pCaptureCount);
	
	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param devType
	 * @param pBatteryInformation
	 * @return
	 * @since 1.0.0
	 */
	public int XInputGetBatteryInformation(int dwUserIndex, byte devType, XinputBatteryInformation pBatteryInformation);
	
	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pDSoundRenderGuid
	 * @param pdSoundCaptureGuid
	 * @return
	 * @since 1.0.0
	 */
	public int XInputGetDSoundAudioDeviceGuids(int dwUserIndex, char[] pDSoundRenderGuid, char[] pdSoundCaptureGuid);
	
	/**
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param pState
	 * @return
	 * @since 1.0.0
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
	 * <p><code>Source: <a href="">Microsoft Documentation</a></code></p>
	 * @param dwUserIndex <code><i>[in]</i></code> Index of the user's controller. Can be a value from {@code 0} to {@code 3}.
	 *                    For information about how this value is determined and how the value maps to indicators on the controller,
	 *                    see <a href="https://msdn.microsoft.com/en-us/library/windows/desktop/ee417001(v=vs.85).aspx#multiple_controllers">Multiple Controllers</a>.
	 * @param dwReserved
	 * @param pKeystroke
	 * @return
	 * @since 1.0.0
	 */
	public int XInputGetKeystroke(int dwUserIndex, int dwReserved, XInputKeystroke pKeystroke);
}
