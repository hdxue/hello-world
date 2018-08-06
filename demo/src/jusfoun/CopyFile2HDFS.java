package jusfoun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CopyFile2HDFS {

	public static void main(String[] args) throws IOException, URISyntaxException {

		String path = "hdfs://192.168.59.128:8020/user";
		String localfile = "e://demo.txt";
		new CopyFile2HDFS().WriteToHDFS(path, localfile);
	}

	public void WriteToHDFS(String path, String localfile) throws IOException, URISyntaxException {

		Configuration conf = new Configuration();
		File file = new File(localfile);
		try {
			FileSystem localFS = FileSystem.getLocal(conf);
			FileSystem hadoopFS = FileSystem.get(conf);
			Path hadPath = new Path(path);
			FSDataOutputStream fsOut = hadoopFS.create(new Path(path + "/" + file.getName()));
			FSDataInputStream fsIn = localFS.open(new Path(localfile));
			byte[] buf = new byte[1024];
			int readbytes = 0;
			while ((readbytes = fsIn.read(buf)) > 0) {
				fsOut.write(buf, 0, readbytes);
			}
			fsIn.close();
			fsOut.close();
			FileStatus[] hadfiles = hadoopFS.listStatus(hadPath);
			for (FileStatus fs : hadfiles) {
				System.out.println(fs.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFolder(File srcFolder, File destFolder, String[] filterFile) throws Exception {

		File[] files = srcFolder.listFiles();
		// 遍历目标得到文件夹中的文件
		for (File file : files) {
			if (file.isFile()) {
				String pathname = destFolder + File.separator + file.getName();
				for (String suff : filterFile) {
					if (pathname.endsWith(suff)) {
						File dest = new File(pathname);
						File destPar = dest.getParentFile();
						destPar.mkdirs();
						if (!dest.exists()) {
							dest.createNewFile();
						}
						copyFile(file, dest);
					}
				}
			} else {
				copyFolder(file, destFolder, filterFile);
			}
		}
	}

	private void copyFile(File src, File dest) throws Exception {
		FileInputStream input = null;
		FileOutputStream outstrem = null;
		try {
			input = new FileInputStream(src);
			outstrem = new FileOutputStream(dest);

			byte[] buff = new byte[1024];

			int len = 0;

			while ((len = input.read(buff)) != -1) {

				outstrem.write(buff, 0, len);

			}

			String temp = String.format("\ncopy:%s  to: %s ", src, dest);
			System.out.println(temp);
		} catch (Exception e) {
			throw e;
		} finally {
			outstrem.flush();
			outstrem.close();
			input.close();
		}
	}
	

}
