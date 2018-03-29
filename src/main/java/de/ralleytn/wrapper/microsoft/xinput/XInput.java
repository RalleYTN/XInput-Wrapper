package de.ralleytn.wrapper.microsoft.xinput;

import com.sun.jna.Library;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef.UINT;

public interface XInput extends Library {
	
	public static final int ERROR_SUCCESS = 0x00;
	public static final int ERROR_EMPTY = 4306;
	public static final int ERROR_DEVICE_NOT_CONNECTED = 0x48F;
	
	public static final int XINPUT_KEYSTROKE_KEYDOWN = 0x0001;
	public static final int XINPUT_KEYSTROKE_KEYUP = 0x0002;
	public static final int XINPUT_KEYSTROKE_REPEAT = 0x0004;
	
    public static final int XINPUT_DEVSUBTYPE_UNKNOWN = 0x00;
    public static final int XINPUT_DEVSUBTYPE_GAMEPAD = 0x01;
    public static final int XINPUT_DEVSUBTYPE_WHEEL = 0x02;
    public static final int XINPUT_DEVSUBTYPE_ARCADE_STICK = 0x03;
    public static final int XINPUT_DEVSUBTYPE_FLIGHT_STICK = 0x04;
    public static final int XINPUT_DEVSUBTYPE_DANCE_PAD = 0x05;
    public static final int XINPUT_DEVSUBTYPE_GUITAR = 0x06;
    public static final int XINPUT_DEVSUBTYPE_GUITAR_ALTERNATE = 0x07;
    public static final int XINPUT_DEVSUBTYPE_DRUM_KIT = 0x08;
    public static final int XINPUT_DEVSUBTYPE_GUITAR_BASS = 0x0B;
    public static final int XINPUT_DEVSUBTYPE_ARCADE_PAD = 0x13;

	public static final int XINPUT_DEVTYPE_GAMEPAD = 1;
	
	public static final int XINPUT_GAMEPAD_DPAD_UP = 0x0001;
	public static final int XINPUT_GAMEPAD_DPAD_DOWN = 0x0002;
	public static final int XINPUT_GAMEPAD_DPAD_LEFT = 0x0004;
	public static final int XINPUT_GAMEPAD_DPAD_RIGHT = 0x0008;
	public static final int XINPUT_GAMEPAD_START = 0x0010;
	public static final int XINPUT_GAMEPAD_BACK = 0x0020;
	public static final int XINPUT_GAMEPAD_LEFT_THUMB = 0x0040;
	public static final int XINPUT_GAMEPAD_RIGHT_THUMB = 0x0080;
	public static final int XINPUT_GAMEPAD_LEFT_SHOULDER = 0x0100;
	public static final int XINPUT_GAMEPAD_RIGHT_SHOULDER = 0x0200;
	public static final int XINPUT_GAMEPAD_A = 0x1000;
	public static final int XINPUT_GAMEPAD_B = 0x2000;
	public static final int XINPUT_GAMEPAD_X = 0x4000;
	public static final int XINPUT_GAMEPAD_Y = 0x8000;
	
	public static final int BATTERY_TYPE_DISCONNECTED = 0x00;
	public static final int BATTERY_TYPE_WIRED = 0x01;
	public static final int BATTERY_TYPE_ALKALINE = 0x02;
	public static final int BATTERY_TYPE_NIMH = 0x03;
	public static final int BATTERY_TYPE_UNKNOWN = 0xFF;
	
	public static final int BATTERY_DEVTYPE_GAMEPAD = 0x00;
	public static final int BATTERY_DEVTYPE_HEADSET = 0x01;
	
	public static final int BATTERY_LEVEL_EMPTY = 0x00;
	public static final int BATTERY_LEVEL_LOW = 0x01;
	public static final int BATTERY_LEVEL_MEDIUM = 0x02;
	public static final int BATTERY_LEVEL_FULL = 0x03;
	
	public static final int XINPUT_CAPS_FFB_SUPPORTED = 0x0001;
    public static final int XINPUT_CAPS_WIRELESS = 0x0002;
    public static final int XINPUT_CAPS_VOICE_SUPPORTED = 0x0004;
    public static final int XINPUT_CAPS_PMD_SUPPORTED = 0x0008;
    public static final int XINPUT_CAPS_NO_NAVIGATION = 0x0010;
	
	public static final int XINPUT_VIBRATION_MAX_MOTOR_SPEED = Short.MAX_VALUE;
	
	public static final int XINPUT_FLAG_GAMEPAD = 0x00000001;
	
	public static final int XUSER_INDEX_ANY = 255;
	public static final int XUSER_MAX_COUNT = 4;

	public void XInputEnable(boolean enable);
	public int XInputGetCapabilities(int dwUserIndex, int dwFlags, XInputCapabilities pCapabilities);
	public int XInputGetAudioDeviceIds(int dwUserIndex, char[] pRenderDeviceId, UINT pRenderCount, char[] pCaptureDeviceId, UINT pCaptureCount);
	public int XInputGetBatteryInformation(int dwUserIndex, byte devType, XInputBatteryInformation pBatteryInformation);
	public int XInputGetDSoundAudioDeviceGuids(int dwUserIndex, Guid pDSoundRenderGuid, Guid pdSoundCaptureGuid);
	public int XInputGetState(int dwUserIndex, XInputState pState);
	public int XInputSetState(int dwUserIndex, XInputVibration pVibration);
	public int XInputGetKeystroke(int dwUserIndex, int dwReserved, XInputKeystroke pKeystroke);
}
