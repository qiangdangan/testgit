package com.gwzd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.UUID;
import java.util.zip.ZipInputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

/**
 * @文件名称: FileUtil.java
 * @包: com.gwzd.gwzdapi
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：操作文件常用工具类
 * 
 */
public class FileUtil
{
    // 默认设置文件缓存大小 5M
    private static final int BUFFER_SIZE = 5 * 1024;

    /**
     * @功能简介：获取文件大小
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:56:12
     * @param f
     *            ：文件对象File对象
     * @return：long型的字节数
     * @throws Exception
     *             ：
     */
    public static long getFileSizes(File f) throws Exception
    {
        long s = 0;
        if (f.exists())
        {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
            fis.close();
        }
        else
        {
            f.createNewFile();
            System.out.println("文件不存在");
        }
        return s;
    }

    /**
     * @功能简介：判断是否存在该目录，不存在则创建
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:57:56
     * @param path
     *            ：
     */
    public static void createDirectiory(String path)
    {
        File dir = new File(path);
        if (!dir.exists() && !dir.isDirectory())
        {
            dir.mkdirs();
        }
    }

    /**
     * @功能简介：获取文件夹里面所有文件的大小
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:58:33
     * @param f
     * @return
     * @throws Exception
     *             ：
     */
    public static long getFileSize(File f) throws Exception
    {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++)
        {
            if (flist[i].isDirectory())
            {
                size = size + getFileSize(flist[i]);
            }
            else
            {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    /**
     * @功能简介：根据字节数转换文件大小
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午6:59:20
     * @param fileS
     * @return：
     */
    public static String formatFileSize(long fileS)
    {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024)
        {
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576)
        {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else if (fileS < 1073741824)
        {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
        else
        {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    /**
     * @功能简介：递归求取目录文件个数
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:00:05
     * @param f
     * @return：
     */
    public static long getFileListCount(File f)
    {
        long size = 0;
        File flist[] = f.listFiles();
        size = flist.length;
        for (int i = 0; i < flist.length; i++)
        {
            if (flist[i].isDirectory())
            {
                size = size + getFileListCount(flist[i]);
                size--;
            }
        }
        return size;
    }
    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：文件复制
     * @param sourceFile源文件
     * @param targetFile目标文件
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException
    {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try
        {
            String tagetFilePath = targetFile.getPath();
            String tagetFileName = targetFile.getName();
            File targetFileMl = new File(tagetFilePath.replaceAll(tagetFileName, ""));
            if (!targetFileMl.exists())
            {
                targetFileMl.mkdirs();
            }
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[BUFFER_SIZE];
            int len;
            while ((len = inBuff.read(b)) != -1)
            {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        }
        finally
        {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：目录复制
     * @param sourceDir源目录
     * @param targetDir目标目录
     * @throws IOException
     */
    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException
    {
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++)
        {
            if (file[i].isFile())
            {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory())
            {
                // 准备复制的源文件夹
                String dir1 = sourceDir + "/" + file[i].getName();
                // 准备复制的目标文件夹
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：文件复制并转换文件的编码方式
     * @param srcFileName
     * @param destFileName
     * @param srcCoding
     * @param destCoding
     * @throws IOException
     */
    public static void copyFile(File srcFileName, File destFileName, String srcCoding, String destCoding) throws IOException
    {// 把文件转换为GBK文件
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName), srcCoding));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName), destCoding));
            char[] cbuf = new char[BUFFER_SIZE];
            int len = cbuf.length;
            int off = 0;
            int ret = 0;
            while ((ret = br.read(cbuf, off, len)) > 0)
            {
                off += ret;
                len -= ret;
            }
            bw.write(cbuf, 0, off);
            bw.flush();
        }
        finally
        {
            if (br != null)
                br.close();
            if (bw != null)
                bw.close();
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：删除文件，如果是文件，则直接删除；
     * @param filepath
     * @throws IOException
     */
    public static void deleteFile(String filepath) throws IOException
    {
        File f = new File(filepath);// 定义文件路径\
        if (f.exists() && f.isFile())
        {
            f.delete();
        }
    }
    /**
     * @功能简介：删除文件夹，如果是文件夹，则直接删除；
     * @作者姓名：强当安
     * @创建时间：2015年9月17日 上午11:48:53
     * @param folderpath：
     */
    public static void deleteFolder(String folderpath)
    {
        File f = new File(folderpath);// 定义文件路径\
        if (f.exists() && f.isDirectory())
        {
            File[] fs = f.listFiles();
            if (fs.length > 0)
            {
                for (File ftmp : fs)
                {
                    if (ftmp.isFile())
                    {
                        ftmp.delete();
                    }
                    else
                    {
                        deleteFolder(ftmp.getPath());
                    }
                }
            }
            f.delete();
        }

    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：删除文件或文件夹，如果是文件，则直接删除，如果是文件夹，则删除该文件夹；
     * @param filepath
     * @throws IOException
     */
    // public static void deleteFiles(String filepath) throws IOException
    // {
    // File f = new File(filepath);// 定义文件路径\
    // if (f.exists())
    // {
    // if (f.isDirectory())
    // {// 判断是文件还是目录
    // if (f.listFiles().length > 0)
    // {// 若目录下没有文件则直接删除
    // // 若有则把文件放进数组，并判断是否有下级目录
    // File delFile[] = f.listFiles();
    // int i = f.listFiles().length;
    // for (int j = 0; j < i; j++)
    // {
    // if (delFile[j].isFile())
    // {
    // delFile[j].delete();// 删除文件
    // }
    // }
    // }
    // }
    // }
    // }
    /**
     * @功能简介：文件重命名
     * @作者姓名：强当安
     * @创建时间：2015年8月26日 下午4:16:38
     * @param sourceFileName
     *            ：原文件名
     * @param targetFileName
     *            ：重命名后的文件名
     */
    public static void renameFile(String sourceFileName, String targetFileName)
    {
        File file = new File(sourceFileName);
        if (file.isFile())
        {
            // 文件分隔符
            String newFileName = targetFileName;
            file.renameTo(new File(newFileName));
        }
    }
    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：将源文件夹中的文件复制到另一个文件夹中，若目标文件夹不存在，则创建一个
     * @param sourceDir源文件夹
     * @param targetDir目标文件夹
     * @throws IOException
     */
    public static void copyDirToDir(String sourceDir, String targetDir) throws IOException
    {
        // 创建目标文件夹
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++)
        {
            if (file[i].isFile())
            {
                // 复制文件
                if (!targetDir.endsWith("/"))
                {
                    targetDir += "/";
                }
                copyFile(file[i], new File(targetDir + file[i].getName()));
            }
            if (file[i].isDirectory())
            {
                // 复制目录
                copyDirectiory(sourceDir + File.separator + file[i].getName(), targetDir + File.separator + file[i].getName());
            }
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：将文件复制到目标文件夹中，若目标文件夹不存在，则新建一个目标文件夹
     * @param filePath
     *            ：文件路径
     * @param targetDir
     *            ：目标文件夹路径
     * @throws IOException
     */
    public static void copyFileToDir(String sourceFilePath, String targetDir) throws IOException
    {
        (new File(targetDir)).mkdirs();
        File file = new File(sourceFilePath);
        if (!targetDir.endsWith("/"))
        {
            targetDir += "/";
        }
        copyFile(file, new File(targetDir + file.getName()));
    }

    /**
     * @功能简介：将文件复制到目标文件夹中，若目标文件夹不存在，则新建一个目标文件夹
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:02:13
     * @param file
     *            ：文件对象
     * @param targetDir
     *            ：目标文件夹路径
     * @throws IOException
     *             ：
     */
    public static void copyFileToDir(File file, String targetDir) throws IOException
    {
        (new File(targetDir)).mkdirs();
        if (!targetDir.endsWith("/"))
        {
            targetDir += "/";
        }
        copyFile(file, new File(targetDir + file.getName()));
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-7-13
     * @功能说明：根据文件路径进行文件复制
     * @param sourceFilePath源文件路径
     * @param targetFilePath目标文件路径
     * @throws IOException
     */
    public static void copyFile(String sourceFilePath, String targetFilePath) throws IOException
    {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        copyFile(sourceFile, targetFile);
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-9-26
     * @功能说明：压缩
     * @param out
     * @param f
     * @param base
     * @throws Exception
     */
    public static void zip(String zipFileName, String inputPath)
    {
        File inputFile = new File(inputPath);
        ZipOutputStream out;
        try
        {
            out = new ZipOutputStream(new FileOutputStream(zipFileName));
            out.setEncoding("UTF-8");
            // 解决linux乱码 根据linux系统的实际编码设置,可以使用命令 vi/etc/sysconfig/i18n 查看linux的系统编码
            zip(out, inputFile, inputFile.getName());
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception
    {
        InputStream is = null;

        try
        {
            // System.out.println("正在压缩：" + f.getName() + "... ...");
            if (f.isDirectory())
            {
                File[] fs = f.listFiles();
                if (!base.endsWith("/"))
                {
                    base += "/";
                }
                ZipEntry zipEntry = new ZipEntry(base);
                zipEntry.setUnixMode(755);// 解决linux乱码
                out.putNextEntry(zipEntry); // 生成相应的目录
                for (int i = 0; i < fs.length; i++)
                {
                    // 对本目录下的所有文件对象递归调用本方法
                    zip(out, fs[i], base + fs[i].getName());
                }
            }
            else
            {
                // System.out.println("新增文件条目：" + f.getName());
                ZipEntry zipEntry = new ZipEntry(base);
                zipEntry.setUnixMode(644);// 解决linux乱码
                out.putNextEntry(zipEntry);
                is = new FileInputStream(f);
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = is.read(buf)) != -1)
                {
                    out.write(buf, 0, len);
                }
                is.close();
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            if (is != null)
            {
                is.close();
            }
        }
    }

    /**
     * 
     * 解压缩zip文件到指定的路径,但是不能解决文件名中文乱码问题
     * 
     * 
     * 
     * @param zipfile
     * 
     *            zip格式压缩文件
     * 
     * @param desPath
     * 
     *            目标路径
     * @throws IOException
     */
    @Deprecated
    public static void unzip(File zipFile, String desPath) throws IOException
    {
        if (!desPath.endsWith("/"))
        {
            desPath += "/";
        }
        // 新建文件夹，如果存在，则不创建；
        (new File(desPath)).mkdirs();
        // 建立输出流，用于将从压缩文件中读出的文件流写入到磁盘
        OutputStream out = null;
        // 建立输入流，用于从压缩文件中读出文件
        ZipInputStream is = null;
        try
        {
            is = new ZipInputStream(new FileInputStream(zipFile));
            java.util.zip.ZipEntry entry = null;
            while ((entry = is.getNextEntry()) != null)
            {
                File f = new File(desPath + entry.getName());
                if (entry.isDirectory())
                {
                    // System.out.println("新建目录：" + f.getName());
                    f.mkdir();
                }
                else
                {
                    // System.out.println("新增文件：" + f.getName());
                    // 根据压缩文件中读出的文件名称新建文件
                    out = new FileOutputStream(f);
                    byte[] buf = new byte[1024];
                    int len = 0;
                    while ((len = is.read(buf)) != -1)
                    {
                        out.write(buf, 0, len);
                    }
                    out.close();
                }
            }
            is.close();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
            if (is != null)
            {
                is.close();
            }
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-11-15
     * @功能说明：解压zip格式压缩包
     * @param unZipFileName
     * @param unZipPath
     * @throws Exception
     */
    public static void unZipGBKFile(String unZipFileName, String unZipPath) throws Exception
    {
        ZipFile zipFile = new ZipFile(unZipFileName, "gbk");
        unZipFileByOpache(zipFile, unZipPath);
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-11-15
     * @功能说明：解压zip格式压缩包
     * @param zipFile
     * @param unZipRoot
     * @throws Exception
     * @throws IOException
     */
    public static void unZipFileByOpache(ZipFile zipFile, String unZipRoot) throws Exception, IOException
    {
        @SuppressWarnings("rawtypes")
        Enumeration e = zipFile.getEntries();
        System.out.println(zipFile.getEncoding());
        org.apache.tools.zip.ZipEntry zipEntry;
        while (e.hasMoreElements())
        {
            zipEntry = (ZipEntry) e.nextElement();
            InputStream fis = zipFile.getInputStream(zipEntry);
            if (zipEntry.isDirectory())
            {
            }
            else
            {
                File file = new File(unZipRoot + File.separator + zipEntry.getName());
                File parentFile = file.getParentFile();
                parentFile.mkdirs();
                FileOutputStream fos = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int len;
                while ((len = fis.read(b, 0, b.length)) != -1)
                {
                    fos.write(b, 0, len);
                }
                fos.close();
                fis.close();
            }
        }
    }

    /**
     * 
     * @创建人：应洪峰
     * @创建时间：2012-11-15
     * @功能说明：解压rar格式压缩包
     * @param sourceRar
     * @param destDir
     * @throws Exception
     */
    public static void unrar(String sourceRar, String destDir) throws Exception
    {
        unrar(new File(sourceRar), destDir);
    }

    /**
     * @功能简介：解压rar格式压缩包。 对应的是java-unrar-0.3.jar，但是java-unrar-0.3.jar又会用到commons-logging-1.1.1.jar
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:06:33
     * @param rarFile
     * @param destDir
     * @throws Exception
     *             ：
     */
    public static void unrar(File rarFile, String destDir) throws Exception
    {
        if (!destDir.endsWith("/"))
        {
            destDir += "/";
        }
        // 新建文件夹
        (new File(destDir)).mkdirs();
        Archive arc = null;
        FileOutputStream fos = null;
        try
        {
            arc = new Archive(rarFile);
            FileHeader fh = arc.nextFileHeader();
            while (fh != null)
            {
                if (!fh.isDirectory())
                {

                    String compressFileName = destDir + fh.getFileNameString().trim().replaceAll("\\\\", "/");

                    // 2创建文件夹
                    String destPath = compressFileName.substring(0, compressFileName.lastIndexOf("/"));
                    File dir = new File(destPath);
                    dir.mkdirs();
                    // 3解压缩文件
                    File file = new File(compressFileName);
                    fos = new FileOutputStream(file);
                    arc.extractFile(fh, fos);
                    fos.close();
                    fos = null;
                }
                fh = arc.nextFileHeader();
            }
            arc.close();
            arc = null;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if (fos != null)
            {
                try
                {
                    fos.close();
                    fos = null;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (arc != null)
            {
                try
                {
                    arc.close();
                    arc = null;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @功能简介：文件上传共用方法
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月20日 下午2:28:11
     * @param file
     *            ：经tomcat解析后的上传文件客户端的文件路径，格式：TODO
     * @param filename
     *            ：要保存到服务器段的可认文件名称，上传成功后会自动加上UUID
     * @param saveFilePath
     *            ：上传到服务器段的路径，相对于配置文件定义的 rootSavePath
     * @return：上传成功后的文件名
     * @throws Exception
     *             ：
     */
    public String uploadFile(File file, String filename, String saveFilePath) throws Exception
    {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try
        {
            String realPath = PropertiesFileUtil.getKey("rootSavePath");
            String path = realPath + saveFilePath;
            File dir = new File(path);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            int filetypeIndex = filename.lastIndexOf(".");// 文件名中.的索引值
            String filetype = filename.substring(filetypeIndex);
            String saveFilename = UUID.randomUUID().toString() + filetype;
            // 保存时文件路径和名称
            String savaFielPathAndName = path + "//" + saveFilename;
            fos = new FileOutputStream(savaFielPathAndName);
            fis = new FileInputStream(file);
            byte[] buffers = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffers)) != -1)
            {
                fos.write(buffers, 0, len);
            }
            return saveFilename;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fos != null)
            {
                fos.close();
            }
            if (fis != null)
            {
                fis.close();
            }
        }
        return null;
    }
}
