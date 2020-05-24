package telran.lessons._34_FileSystemIntroduction.performance;

import java.nio.file.Path;

public interface CopyBigFilesInterface {
	public void copy(Path filePath, Path destPath);
	public default void copy(Path filePath, Path destPath, int bufferSize) {
		copy(filePath, destPath);
	}
}
