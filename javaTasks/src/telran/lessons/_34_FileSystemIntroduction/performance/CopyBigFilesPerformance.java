package telran.lessons._34_FileSystemIntroduction.performance;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CopyBigFilesPerformance extends AbstractPerformanceTest {
	private CopyBigFilesInterface tP;
	private final Path filePath;
	private final Path destPath;
	private final int bufferSize;

	public CopyBigFilesPerformance(String name, String filePath, String destPath, CopyBigFilesInterface tP) {
		this(name, filePath, destPath, tP, 0);
	}

	public CopyBigFilesPerformance(String name, String filePath, String destPath, CopyBigFilesInterface tP,
			int bufferSize) {
		super(name);
		this.tP = tP;
		this.filePath = FileSystems.getDefault().getPath(filePath);
		this.destPath = FileSystems.getDefault().getPath(destPath);
		this.bufferSize = bufferSize;
	}

	@Override
	public void runTest() {
		tP.copy(filePath, destPath, bufferSize);
	}

}
