package de.ralleytn.wrapper.microsoft.xinput;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.jna.Native;

public final class XInputFactory {

	private static final String XINPUT_DLL_9_1_0 = "xinput9_1_0.dll";
	private static final String XINPUT_DLL_1_3 = "xinput1_3.dll";
	private static final String XINPUT_DLL_1_4 = "xinput1_4.dll";
	
	private static final String DEFAULT_WINDOWS_PATH = "c:\\windows";
	private static final String WINDOWS_PATH_PROPERTY = "os.arch.dir";
	
	private static final String WIN32 = "System32";
	private static final String WIN64 = "SysWOW64";

	public static XInput getInstance() throws XInputLibraryNotFound {

		String vmType = System.getProperty("sun.arch.data.model");
		Path dll = Paths.get(getDirectory(), vmType.equals("64") ? WIN64 : WIN32);

		       if(Files.exists(dll.resolve(XINPUT_DLL_1_4))) {return createInstance(dll, XINPUT_DLL_1_4);
		} else if(Files.exists(dll.resolve(XINPUT_DLL_1_3))) {return createInstance(dll, XINPUT_DLL_1_3);
		} else if(Files.exists(dll.resolve(XINPUT_DLL_9_1_0))) {return createInstance(dll, XINPUT_DLL_9_1_0);
		} else {
			
			throw new XInputLibraryNotFound("XInput library not found in " + dll.toString());
		}
	}

	private static final XInput createInstance(Path dll, String libName) {
		
		System.setProperty("jna.library.path", dll.resolve(libName).toString());
		return (XInput)Native.loadLibrary(libName, XInput.class);
	}
	
	private static final String getDirectory() {
		
		String dir = System.getProperty(WINDOWS_PATH_PROPERTY);
		
		if(dir == null) {
			
			dir = DEFAULT_WINDOWS_PATH;
		}
		
		return dir;
	}
}
