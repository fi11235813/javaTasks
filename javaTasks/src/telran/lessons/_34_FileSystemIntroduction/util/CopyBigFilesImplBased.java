package telran.lessons._34_FileSystemIntroduction.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import telran.lessons._34_FileSystemIntroduction.performance.CopyBigFilesInterface;

public class CopyBigFilesImplBased implements CopyBigFilesInterface {

	@Override
	public void copy(Path filePath, Path destPath) {
		try {
			Files.copy(filePath, destPath, StandardCopyOption.REPLACE_EXISTING);
			Files.delete(destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
