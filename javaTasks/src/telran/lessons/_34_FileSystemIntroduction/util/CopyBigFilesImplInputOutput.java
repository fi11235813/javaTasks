package telran.lessons._34_FileSystemIntroduction.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import telran.lessons._34_FileSystemIntroduction.performance.CopyBigFilesInterface;

public class CopyBigFilesImplInputOutput implements CopyBigFilesInterface {
	
	private int bufferSize = (int) Runtime.getRuntime().freeMemory();
	
	@Override
	public void copy(Path filePath, Path destPath) {
		try (InputStream input = Files.newInputStream(filePath); OutputStream output =  Files.newOutputStream(destPath)) {
			byte[] buffer = new byte[bufferSize];
			int length = input.read(buffer, 0, bufferSize);
			while(length > 0) {
				output.write(buffer, 0, length);
				length = input.read(buffer, 0, bufferSize);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void copy(Path filePath, Path destPath, int bufferSize) {
		if (bufferSize > 0 && Integer.compare(this.bufferSize, bufferSize) > 0) {
			this.bufferSize = bufferSize;
		}
		
		copy(filePath, destPath);
	}
	
	
}
