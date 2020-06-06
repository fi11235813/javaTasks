package telran.lessons._34_FileSystemIntroduction.testAppl;

import telran.lessons._34_FileSystemIntroduction.performance.CopyBigFilesPerformance;
import telran.lessons._34_FileSystemIntroduction.util.CopyBigFilesImplBased;
import telran.lessons._34_FileSystemIntroduction.util.CopyBigFilesImplInputOutput;

public class CopyBigFilesPerformanceTestAppl {
	
	private static final String SOURCE_FILE = "C:\\Users\\fi112\\Downloads\\fileForCopy\\AvatarSmall.mkv";
	private static final String DEST_FILE = "C:\\Users\\fi112\\Downloads\\destination\\copyAvatarSmall.mkv";
	
	public static void main(String[] args) {
		
		int[] sizes = {100, 10000, 100_000_000, (int) Runtime.getRuntime().freeMemory()};
		
		new CopyBigFilesPerformance("Base", SOURCE_FILE, DEST_FILE, new CopyBigFilesImplBased()).run();
		
		for (int size: sizes) {
			new CopyBigFilesPerformance("Streams with buffer size = " + size
					, SOURCE_FILE, DEST_FILE, new CopyBigFilesImplInputOutput(), size).run();
		}
	}
}
