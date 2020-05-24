package telran.lessons._34_FileSystemIntroduction.testAppl;

import telran.lessons._34_FileSystemIntroduction.performance.CopyBigFilesPerformance;
import telran.lessons._34_FileSystemIntroduction.util.CopyBigFilesImplBased;
import telran.lessons._34_FileSystemIntroduction.util.CopyBigFilesImplInputOutput;

public class CopyBigFilesPerformanceTestAppl {
	
	private static final String FILE_PATH = "C:\\Users\\fi112\\Downloads\\fileForCopy\\Avatar.mkv";
	private static final String DEST_PETH = "C:\\Users\\fi112\\Downloads\\destination\\copyAvatar.mkv";
	
	public static void main(String[] args) {
		CopyBigFilesPerformance cBFPBased = new CopyBigFilesPerformance("Base", FILE_PATH, DEST_PETH, new CopyBigFilesImplBased());
		cBFPBased.run();
		System.out.println(cBFPBased.toString());
		
//		CopyBigFilesPerformance cBFPInpOutp1 = 
//				new CopyBigFilesPerformance("Input\\Output", FILE_PATH, DEST_PETH, new CopyBigFilesImplInputOutput(), 100);
//		cBFPInpOutp1.run();
//		System.out.println(cBFPInpOutp1.toString());
		
		CopyBigFilesPerformance cBFPInpOutp2 = 
				new CopyBigFilesPerformance("Input\\Output", FILE_PATH, DEST_PETH, new CopyBigFilesImplInputOutput(), 100_000_000);
		cBFPInpOutp2.run();
		System.out.println(cBFPInpOutp2.toString());
		
		CopyBigFilesPerformance cBFPInpOutp3 = 
				new CopyBigFilesPerformance("Input\\Output", FILE_PATH, DEST_PETH, new CopyBigFilesImplInputOutput(), -1);
		cBFPInpOutp3.run();
		System.out.println(cBFPInpOutp3.toString());
	}
}
