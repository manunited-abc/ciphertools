package io;

import java.io.ObjectInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class ReadFile
{
    public static String readLine(final String path) throws IOException {
        String result = "";
        final File file = new File(path);
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            result = String.valueOf(result) + line + "\r\n";
        }
        reader.close();
        return result;
    }
    
    public static Object readObject(final String path) throws IOException, ClassNotFoundException {
        final ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        final Object result = ois.readObject();
        return result;
    }
    public static byte[] readBytes(String path) throws IOException {
    	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
    	byte[] bytes = bis.readAllBytes();
    	bis.close();
    	return bytes;
    }
    public static void main(final String[] args) throws IOException {
        System.out.println("thangchoS\r\nndimem");
    }
}