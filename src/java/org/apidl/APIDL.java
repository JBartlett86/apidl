package org.apidl;

import java.io.File;
import java.io.FilenameFilter;

import org.apidl.builder.DeclaredInterfaceBuilder;
import org.apidl.builder.impl.DeclaredInterfaceBuilderImpl;

public class APIDL implements FilenameFilter {

	public static void main(String args[]) {

		APIDL apidl = new APIDL();

		if (args.length > 0) {
			// Assume only argument is file/directory path...
			String pathOrFilename = args[0];
			DeclaredInterfaceBuilder builder = new DeclaredInterfaceBuilderImpl();
			try {
				if (pathOrFilename.endsWith(".apidl")) {
					// single file...
					builder.build(pathOrFilename);
				} else {
					// directory...
					File directory = new File(args[0]);
					String[] filePaths = directory.list(apidl);

					for (String filePath : filePaths) {
						builder.build(filePath);
					}

				}
			} catch (Exception ioe) {
				ioe.printStackTrace();
			}
		} else {
			System.out.println("Usage: APIDL <path to file(s)>");
		}
	}

	public boolean accept(File file, String name) {
		if (name.endsWith(".apidl")) {
			return true;
		}
		return false;
	}
}