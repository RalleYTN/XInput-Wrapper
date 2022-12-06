@SuppressWarnings({"requires-transitive-automatic"}) // shows a warning in Eclipse but prevents warning during Maven build
module de.ralleytn.wrapper.microsoft.xinput {
	
	requires transitive com.sun.jna;
	
	exports de.ralleytn.wrapper.microsoft.xinput;
}